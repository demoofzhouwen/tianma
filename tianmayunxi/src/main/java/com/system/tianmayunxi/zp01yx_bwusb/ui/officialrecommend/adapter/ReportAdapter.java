package com.system.tianmayunxi.zp01yx_bwusb.ui.officialrecommend.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.system.tianmayunxi.zp01yx_bwusb.R;

import java.util.List;

public class ReportAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    public ReportAdapter(@Nullable List<String> data) {
        super(R.layout.fragment_report_item, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.tv_content,item);
    }

}
