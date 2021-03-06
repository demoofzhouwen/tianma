package com.system.tianmayunxi.zp01yx_bwusb.ui.officialrecommend.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.system.tianmayunxi.zp01yx_bwusb.R;

import java.util.List;

public class CommonIvAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    public CommonIvAdapter(@Nullable List<String> data) {
        super(R.layout.fragment_iv_item, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        SimpleDraweeView iv=helper.getView(R.id.iv);
        iv.setImageURI(item);
    }

}

