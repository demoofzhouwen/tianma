package com.system.tianmayunxi.zp01yx_bwusb.ui.alltheme.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.system.tianmayunxi.zp01yx_bwusb.R;

import java.util.List;

public class ThemeAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    public ThemeAdapter(@Nullable List<String> data) {
        super(R.layout.fragment_theme_item, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        SimpleDraweeView simpleDraweeView=helper.getView(R.id.iv_head);
        simpleDraweeView.setImageURI("https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=2901043482,2406695108&fm=26&gp=0.jpg");
    }

}
