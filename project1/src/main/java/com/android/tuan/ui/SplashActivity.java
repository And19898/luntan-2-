package com.android.tuan.ui;

import android.content.Intent;
import android.text.TextUtils;

import com.android.mj.tools.GuideTools;
import com.android.mj.tools.LogUtil;
import com.android.mj.tools.ResourceUtil;
import com.android.mj.ui.SplashBaseActivity;
import com.android.mj.ui.WebViewActivity;
import com.android.tuan.BuildConfig;
import com.android.tuan.checkSkip.bmob.Config;
import com.android.tuan.tools.SplashTools;
import com.google.gson.Gson;

import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

/**
 * 启动页
 */
public class SplashActivity extends SplashBaseActivity {
    private long timeStamp = 0;

    @Override
    protected int getSplashRes() {
        //返回启动页图片资源，在global.gradle中配置
        return ResourceUtil.getDrawableId(context, BuildConfig.SPLASH_PIC);
    }

    @Override
    protected void init() {
        super.init();
        timeStamp = System.currentTimeMillis();
    }

    @Override
    protected String getCheckType() {
        //检测类型，bmob检测还是接口检测
        return BMOB_CHECK;
    }

    @Override
    protected String interfaceCheckUrl() {
        //如果是接口检测的话，返回拼接好的接口地址
        //如果是bmob的话，不需要返回
        return BuildConfig.INTERFACE_URL;
    }

    @Override
    protected void bmobCheck() {
        //实现bmob检测
        BmobQuery<Config> query = new BmobQuery<>();
        query.findObjects(new FindListener<Config>() {
            @Override
            public void done(List<Config> list, BmobException e) {
                if (e == null) {
                    if (list != null && list.size() != 0) {
                        for (Config config : list) {
                            if (config.getAppid().equals(getPackageName())) {
                                deal(config);
                                return;
                            }
                        }
                    }
                }
                toMain();
            }
        });
    }

    private void deal(Config configModel) {
        final String url = configModel.getUrl();
        if (configModel.isShow()) {
            if (GuideTools.needShowGuide()) {
                SplashTools.checkTime(timeStamp, new SplashTools.SplashCallback() {
                    @Override
                    public void done() {
                        GuideActivity.showGuide(context, url);
                        finish();
                    }
                });
                return;
            } else {
                SplashTools.checkTime(timeStamp, new SplashTools.SplashCallback() {
                    @Override
                    public void done() {
                        WebViewActivity.load(context, url);
                        finish();
                    }
                });
                return;
            }
        }
        toMain();
    }

    @Override
    protected String interfaceCheckAndReturnUrl(String result) {
        try {
            com.android.tuan.checkSkip.Config config = new Gson().fromJson(result, com.android.tuan.checkSkip.Config.class);
            if (config != null && config.getStatus() == 1 && config.getIsshowwap().equalsIgnoreCase("1") && !TextUtils.isEmpty(config.getWapurl())) {
                return config.getWapurl();
            }
        } catch (Exception e) {
        }
        return null;
    }

    @Override
    protected void toMain() {
        SplashTools.checkTime(timeStamp, new SplashTools.SplashCallback() {
            @Override
            public void done() {
                Intent intent = new Intent(context, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
