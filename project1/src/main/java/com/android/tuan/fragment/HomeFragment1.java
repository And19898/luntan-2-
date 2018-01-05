package com.android.tuan.fragment;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.view.View;

import com.android.mj.tools.GlideImageLoaderBanner;
import com.android.mj.ui.LuckPanelActivity;
import com.android.mj.ui.UIBaseFragment;
import com.android.mj.ui.lotto.lottery.LottoTrendActivity;
import com.android.tuan.R;
import com.android.tuan.databinding.FragmentHome1Binding;
import com.android.tuan.ui.ArtActivity;
import com.android.tuan.ui.FuliActivity;
import com.android.tuan.ui.GuigushiActivity;
import com.android.tuan.ui.MainActivity;
import com.android.tuan.ui.ManhuaListActivity;
import com.android.tuan.ui.TrendChartActivity;
import com.android.tuan.ui.WXMeiwenActivity;
import com.android.tuan.ui.XiaohuaActivity;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;

import static com.android.tuan.tools.Tools.changeDrawableToDefaultTheme;
import static com.youth.banner.BannerConfig.NUM_INDICATOR_TITLE;

/**
 * author: Rea.X
 * date: 2017/12/13.
 * 九宫格样式，没有列表
 */

public class HomeFragment1 extends UIBaseFragment<FragmentHome1Binding> implements View.OnClickListener {


    @Override
    protected void lazyLoad() {

    }

    @Override
    protected int getContentView() {
        return R.layout.fragment_home_1;
    }

    @Override
    protected void init(View view) {
        List<Integer> images = new ArrayList<>();
//        images.add(R.drawable.banner_1);
        images.add(R.drawable.banner_2);
//        images.add(R.drawable.banner_3);
        images.add(R.drawable.banner_4);
        List<String> titles = new ArrayList<>();
//        titles.add("实时开奖信息");
        titles.add("运势大测试，快来试试吧");
//        titles.add("准确的走势图信息");
        titles.add("各种论坛让你一吐为快");
        databinding.banner.setImageLoader(new GlideImageLoaderBanner());
        databinding.banner.setBannerStyle(NUM_INDICATOR_TITLE);
        databinding.banner.setImages(images);
        databinding.banner.setBannerTitles(titles);
        databinding.banner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {
                switch (position) {
//                    case 0:
//                        startActivity(new Intent(getContext(), TrendChartActivity.class));
//                        break;
                    case 0:
                        startActivity(new Intent(getContext(), LuckPanelActivity.class));
                        break;
//                    case 2:
//                        startActivity(new Intent(getContext(), LottoTrendActivity.class));
//                        break;
                    case 1:
                        MainActivity activity = (MainActivity) getActivity();
                        activity.changeTab(1);
                        break;
                }
            }
        });
        databinding.banner.start();
        databinding.tvOne.setOnClickListener(this);
        databinding.tvTwo.setOnClickListener(this);
        databinding.tvThree.setOnClickListener(this);
        databinding.tvFour.setOnClickListener(this);
        databinding.tvFive.setOnClickListener(this);
        databinding.tvSix.setOnClickListener(this);
        databinding.tvSeven.setOnClickListener(this);
        databinding.tvEight.setOnClickListener(this);
        databinding.tvNine.setOnClickListener(this);

        //图标颜色变成设置的主题色\
        //开奖
        databinding.tvOne.setCompoundDrawablesWithIntrinsicBounds(null, changeDrawableToDefaultTheme(getResources().getDrawable(R.drawable.ic_home_kaijiang)), null, null);
        //艺术欣赏
        databinding.tvTwo.setCompoundDrawablesWithIntrinsicBounds(null, changeDrawableToDefaultTheme(getResources().getDrawable(R.drawable.ic_home_art)), null, null);
        //微信鸡汤
        databinding.tvThree.setCompoundDrawablesWithIntrinsicBounds(null, changeDrawableToDefaultTheme(getResources().getDrawable(R.drawable.ic_home_weixinmeiwen)), null, null);
        //每日一笑
        databinding.tvFour.setCompoundDrawablesWithIntrinsicBounds(null, changeDrawableToDefaultTheme(getResources().getDrawable(R.drawable.ic_h_xiaohua)), null, null);
        //走势图
        databinding.tvFive.setCompoundDrawablesWithIntrinsicBounds(null, changeDrawableToDefaultTheme(getResources().getDrawable(R.drawable.ic_home_zoushi)), null, null);
        //测试运气
        databinding.tvSix.setCompoundDrawablesWithIntrinsicBounds(null, changeDrawableToDefaultTheme(getResources().getDrawable(R.drawable.ic_shouqi)), null, null);
        //漫画
        databinding.tvSeven.setCompoundDrawablesWithIntrinsicBounds(null, changeDrawableToDefaultTheme(getResources().getDrawable(R.drawable.ic_home_manhua)), null, null);
        //鬼故事
        databinding.tvEight.setCompoundDrawablesWithIntrinsicBounds(null, changeDrawableToDefaultTheme(getResources().getDrawable(R.drawable.ic_home_guigushi)), null, null);
        //福利
        databinding.tvNine.setCompoundDrawablesWithIntrinsicBounds(null, changeDrawableToDefaultTheme(getResources().getDrawable(R.drawable.ic_home_fuli)), null, null);

    }


    public static Fragment getInstant() {
        return new HomeFragment1();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_one:
                startActivity(new Intent(getContext(), TrendChartActivity.class));
                break;
            case R.id.tv_two:
                startActivity(new Intent(getContext(), ArtActivity.class));
                break;
            case R.id.tv_three:
                startActivity(new Intent(getContext(), WXMeiwenActivity.class));
                break;
            case R.id.tv_four:
                startActivity(new Intent(getContext(), XiaohuaActivity.class));
                break;
            case R.id.tv_five:
                startActivity(new Intent(getContext(), LottoTrendActivity.class));
                break;
            case R.id.tv_six:
                startActivity(new Intent(getContext(), LuckPanelActivity.class));
                break;
            case R.id.tv_seven:
                startActivity(new Intent(getContext(), ManhuaListActivity.class));
                break;
            case R.id.tv_eight:
                startActivity(new Intent(getContext(), GuigushiActivity.class));
                break;
            case R.id.tv_nine:
                startActivity(new Intent(getContext(), FuliActivity.class));
                break;
        }
    }

}
