package com.system.tianmayunxi.zp01yx_bwusb.ui.alltheme.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.system.tianmayunxi.zp01yx_bwusb.R;

import java.util.List;

public class ThemeListAdapter  extends BaseQuickAdapter<String, BaseViewHolder> {
    public ThemeListAdapter(@Nullable List<String> data) {
        super(R.layout.fragment_themelist_item, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.tv_title,item);
    }
}

