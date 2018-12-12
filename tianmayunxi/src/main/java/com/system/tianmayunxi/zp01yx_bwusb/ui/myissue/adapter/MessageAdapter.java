package com.system.tianmayunxi.zp01yx_bwusb.ui.myissue.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.system.tianmayunxi.zp01yx_bwusb.R;

import java.util.List;

public class MessageAdapter  extends BaseQuickAdapter<String, BaseViewHolder> {
    public MessageAdapter(@Nullable List<String> data) {
        super(R.layout.fragment_message_item, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        SimpleDraweeView iv_head=helper.getView(R.id.iv_head);
        SimpleDraweeView iv=helper.getView(R.id.iv);
        iv_head.setImageURI("https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=2577022489,1269768065&fm=26&gp=0.jpg");
        iv.setImageURI("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=3301357945,1129788635&fm=15&gp=0.jpg");

    }

}

