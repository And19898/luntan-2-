package com.android.tuan.ui;

import android.content.Intent;
import android.view.View;

import com.android.mj.tools.activity_manager.ActivityManager;
import com.android.mj.ui.UIActivity;
import com.android.tuan.R;
import com.android.tuan.databinding.ActivitySettingBinding;
import com.avos.avoscloud.AVUser;

import de.greenrobot.event.EventBus;


public class SettingActivity extends UIActivity<ActivitySettingBinding> implements View.OnClickListener {
    @Override
    protected int getLayoutId() {
        return R.layout.activity_setting;
    }

    @Override
    protected void init() {
        tvTitle.setText("设置");
        databinding.tvLoginout.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_loginout:
                AVUser.logOut();
                org.simple.eventbus.EventBus.getDefault().post(0, "changeTab");
                ActivityManager.toActivity(MainActivity.class);
                finish();
                break;
        }
    }
}
