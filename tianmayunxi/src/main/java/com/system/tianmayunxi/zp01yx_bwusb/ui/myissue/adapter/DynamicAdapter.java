package com.system.tianmayunxi.zp01yx_bwusb.ui.myissue.adapter;

import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.library.flowlayout.SpaceItemDecoration;
import com.system.myproject.utils.UEMethod;
import com.system.tianmayunxi.zp01yx_bwusb.R;
import com.system.tianmayunxi.zp01yx_bwusb.ui.officialrecommend.adapter.TieIvAdapter;

import java.util.ArrayList;
import java.util.List;

public class DynamicAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    public DynamicAdapter(@Nullable List<String> data) {
        super(R.layout.fragment_dynamic_item, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        RecyclerView mgrid=helper.getView(R.id.mlist);
        mgrid.setLayoutManager(new GridLayoutManager(mContext,3));
        mgrid.addItemDecoration(new SpaceItemDecoration(UEMethod.dp2px(mContext,5)));
        ArrayList<String> gridData = new ArrayList<>();
        gridData.add("https://ss2.baidu.com/-vo3dSag_xI4khGko9WTAnF6hhy/image/h%3D300/sign=c7cf816776f40ad10ae4c1e3672d1151/d439b6003af33a8724e4b645cb5c10385243b5e0.jpg");
        gridData.add("https://ss2.baidu.com/-vo3dSag_xI4khGko9WTAnF6hhy/image/h%3D300/sign=c7cf816776f40ad10ae4c1e3672d1151/d439b6003af33a8724e4b645cb5c10385243b5e0.jpg");
        gridData.add("https://ss2.baidu.com/-vo3dSag_xI4khGko9WTAnF6hhy/image/h%3D300/sign=c7cf816776f40ad10ae4c1e3672d1151/d439b6003af33a8724e4b645cb5c10385243b5e0.jpg");
        mgrid.setAdapter(new TieIvAdapter(gridData));
        SimpleDraweeView iv_head=helper.getView(R.id.iv_head);
        iv_head.setImageURI("https://ss1.baidu.com/-4o3dSag_xI4khGko9WTAnF6hhy/image/h%3D300/sign=cc25cc7498cad1c8cfbbfa274f3f67c4/83025aafa40f4bfb0786420f0e4f78f0f7361813.jpg");
        SimpleDraweeView user_head=helper.getView(R.id.user_head);
        user_head.setImageURI("https://ss0.baidu.com/-Po3dSag_xI4khGko9WTAnF6hhy/image/h%3D300/sign=a792b4baaecc7cd9e52d32d909002104/32fa828ba61ea8d3f622db539a0a304e251f5860.jpg");

    }

}
