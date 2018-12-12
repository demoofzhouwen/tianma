package com.system.tianmayunxi.zp01yx_bwusb.ui.integral.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.system.tianmayunxi.zp01yx_bwusb.R;

import java.util.List;

public class QdAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    public QdAdapter(@Nullable List<String> data) {
        super(R.layout.fragment_qd_item, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {

    }

}
