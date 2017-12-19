package com.android.tuan.adapter;

import android.content.Context;

import com.android.tuan.R;
import com.android.tuan.models.XiaohuaModel;
import com.joanzapata.android.BaseAdapterHelper;
import com.joanzapata.android.QuickAdapter;


public class XiaohuaAdapter extends QuickAdapter<XiaohuaModel.ShowapiResBodyBean.ContentlistBean> {

    public XiaohuaAdapter(Context context) {
        super(context, R.layout.item_normal);
    }


    @Override
    protected void convert(BaseAdapterHelper helper, XiaohuaModel.ShowapiResBodyBean.ContentlistBean item) {
        helper.setText(R.id.tv_item_normal_title, item.getTitle()).setText(R.id.tv_item_normal_detail, item.getText());
    }
}