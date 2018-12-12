package com.system.tianmayunxi.zp01yx_bwusb.ui.officialrecommend.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.system.tianmayunxi.zp01yx_bwusb.R;

import java.util.List;

public class PlAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    public PlAdapter(@Nullable List<String> data) {
        super(R.layout.fragment_pl_item, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        SimpleDraweeView iv_head=helper.getView(R.id.iv_head);
        helper.addOnClickListener(R.id.btn_pl);
        iv_head.setImageURI("https://ss1.baidu.com/-4o3dSag_xI4khGko9WTAnF6hhy/image/h%3D300/sign=cc25cc7498cad1c8cfbbfa274f3f67c4/83025aafa40f4bfb0786420f0e4f78f0f7361813.jpg");
    }

}

