package com.android.tuan.fragment;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;

import com.android.mj.model.Post;
import com.android.mj.ui.UIBaseFragment;
import com.android.mj.ui.lotto.lottery.LottoTrendActivity;
import com.android.mj.ui.trend.ui.TrendActivity;
import com.android.tuan.R;
import com.android.tuan.adapter.HomeAdapter;
import com.android.tuan.databinding.ActivityRefreshListviewBinding;
import com.android.tuan.databinding.FragmentHomeBinding;
import com.android.tuan.databinding.FragmentRefreshListviewBinding;
import com.android.tuan.databinding.HeaderHomefragmentBinding;
import com.android.tuan.ui.PostDetailActivity;
import com.android.tuan.ui.TrendChartActivity;
import com.avos.avoscloud.AVQuery;
import com.joanzapata.android.QuickAdapter;

/**
 * author: Rea.X
 * date: 2017/12/13.
 */

public class HomeFragment extends RefreshBaseFragment<FragmentRefreshListviewBinding, Post> implements View.OnClickListener{
    private HeaderHomefragmentBinding headerBinding;


    @Override
    protected void init(View view) {
        super.init(view);
        headerBinding = DataBindingUtil.inflate(LayoutInflater.from(getActivity()), R.layout.header_homefragment, null, false);
        listView.addHeaderView(headerBinding.getRoot());
        headerBinding.bannerGuideContent.setData(R.drawable.banner1, R.drawable.banner2, R.drawable.banner3);
        headerBinding.tvOne.setOnClickListener(this);
        headerBinding.tvTwo.setOnClickListener(this);
        headerBinding.tvThree.setOnClickListener(this);
    }

    @Override
    protected Class<Post> getQueryClass() {
        return Post.class;
    }

    @Override
    protected AVQuery getAvQuery(AVQuery avQuery) {
        avQuery.include("user");
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
        switch(view.getId()){
            case R.id.tv_one:
                startActivity(new Intent(getContext(), TrendChartActivity.class));
                break;
            case R.id.tv_two:
                startActivity(new Intent(getContext(), LottoTrendActivity.class));
                break;
            case R.id.tv_three:
                startActivity(new Intent(getContext(), TrendActivity.class));
                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        super.onItemClick(adapterView, view, i, l);
        PostDetailActivity.seePost(getContext(), adapter.getItem(i-1));
    }
}
