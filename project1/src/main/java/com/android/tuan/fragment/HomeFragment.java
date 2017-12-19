package com.android.tuan.fragment;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;

import com.android.mj.model.Post;
import com.android.mj.tools.GlideImageLoader;
import com.android.mj.tools.GlideImageLoaderBanner;
import com.android.mj.ui.LuckPanelActivity;
import com.android.mj.ui.UIBaseFragment;
import com.android.mj.ui.lotto.lottery.LottoTrendActivity;
import com.android.mj.ui.lotto.lottery.LottoTrendBlueActivity;
import com.android.mj.ui.trend.ui.TrendActivity;
import com.android.tuan.R;
import com.android.tuan.adapter.HomeAdapter;
import com.android.tuan.databinding.ActivityRefreshListviewBinding;
import com.android.tuan.databinding.FragmentHomeBinding;
import com.android.tuan.databinding.FragmentRefreshListviewBinding;
import com.android.tuan.databinding.HeaderHomefragmentBinding;
import com.android.tuan.ui.MainActivity;
import com.android.tuan.ui.PostDetailActivity;
import com.android.tuan.ui.TrendChartActivity;
import com.android.tuan.ui.WXMeiwenActivity;
import com.android.tuan.ui.XiaohuaActivity;
import com.avos.avoscloud.AVQuery;
import com.joanzapata.android.QuickAdapter;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;

import cn.bingoogolapple.bgabanner.BGABanner;

import static com.youth.banner.BannerConfig.NUM_INDICATOR_TITLE;

/**
 * author: Rea.X
 * date: 2017/12/13.
 */

public class HomeFragment extends RefreshBaseFragment<FragmentRefreshListviewBinding, Post> implements View.OnClickListener {
    private HeaderHomefragmentBinding headerBinding;


    @Override
    protected void init(View view) {
        super.init(view);
        headerBinding = DataBindingUtil.inflate(LayoutInflater.from(getActivity()), R.layout.header_homefragment, null, false);
        listView.addHeaderView(headerBinding.getRoot());
        List<Integer> images = new ArrayList<>();
        images.add(R.drawable.banner_1);
        images.add(R.drawable.banner_2);
        images.add(R.drawable.banner_3);
        images.add(R.drawable.banner_4);
        List<String> titles = new ArrayList<>();
        titles.add("实时开奖信息");
        titles.add("运势大测试，快来试试吧");
        titles.add("准确的走势图信息");
        titles.add("各种论坛让你一吐为快");
        headerBinding.banner.setImageLoader(new GlideImageLoaderBanner());
        headerBinding.banner.setBannerStyle(NUM_INDICATOR_TITLE);
        headerBinding.banner.setImages(images);
        headerBinding.banner.setBannerTitles(titles);
        headerBinding.banner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {
                switch (position) {
                    case 0:
                        startActivity(new Intent(getContext(), TrendChartActivity.class));
                        break;
                    case 1:
                        startActivity(new Intent(getContext(), LuckPanelActivity.class));
                        break;
                    case 2:
                        startActivity(new Intent(getContext(), LottoTrendActivity.class));
                        break;
                    case 3:
                        MainActivity activity = (MainActivity) getActivity();
                        activity.changeTab(1);
                        break;
                }
            }
        });
        headerBinding.banner.start();
        headerBinding.tvOne.setOnClickListener(this);
        headerBinding.tvTwo.setOnClickListener(this);
        headerBinding.tvThree.setOnClickListener(this);
        headerBinding.tvFour.setOnClickListener(this);
    }

    @Override
    protected Class<Post> getQueryClass() {
        return Post.class;
    }

    @Override
    protected AVQuery getAvQuery(AVQuery avQuery) {
        avQuery.include("user");
        avQuery.orderByDescending("createdAt");
        return avQuery;
    }

    @Override
    protected QuickAdapter<Post> getAdapter() {
        return new HomeAdapter(getActivity());
    }

    public static Fragment getInstant() {
        return new HomeFragment();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_one:
                startActivity(new Intent(getContext(), TrendChartActivity.class));
                break;
            case R.id.tv_two:
                startActivity(new Intent(getContext(), LottoTrendActivity.class));
                break;
            case R.id.tv_three:
                startActivity(new Intent(getContext(), WXMeiwenActivity.class));
                break;
            case R.id.tv_four:
                startActivity(new Intent(getContext(), XiaohuaActivity.class));
                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        super.onItemClick(adapterView, view, i, l);
        PostDetailActivity.seePost(getContext(), adapter.getItem(i - 1));
    }
}
