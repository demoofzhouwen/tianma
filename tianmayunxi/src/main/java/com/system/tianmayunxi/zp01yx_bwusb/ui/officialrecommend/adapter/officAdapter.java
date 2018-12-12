package com.system.tianmayunxi.zp01yx_bwusb.ui.officialrecommend.adapter;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.facebook.drawee.view.SimpleDraweeView;
import com.library.flowlayout.SpaceItemDecoration;
import com.system.myproject.utils.UEMethod;
import com.system.tianmayunxi.zp01yx_bwusb.R;

import java.util.ArrayList;
import java.util.List;

public class officAdapter  extends BaseMultiItemQuickAdapter<MultiItemEntity, BaseViewHolder> {
    public static final int DATA_TYPE1=0;
    public static final int DATA_TYPE2=1;

    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public officAdapter(List<MultiItemEntity> data) {
        super(data);
        addItemType(DATA_TYPE1, R.layout.layout_commensee);
        addItemType(DATA_TYPE2, R.layout.layout_tiezi_item);
    }

    @Override
    protected void convert(BaseViewHolder helper, MultiItemEntity item) {
        int itemType = item.getItemType();
        switch (itemType){
            case DATA_TYPE1:
                RecyclerView mlist=helper.getView(R.id.mlist);
                LinearLayoutManager layout = new LinearLayoutManager(mContext);
                layout.setOrientation(LinearLayout.HORIZONTAL);
                mlist.setLayoutManager(layout);
                helper.addOnClickListener(R.id.tv_fb);
                mlist.addItemDecoration(new SpaceItemDecoration(UEMethod.dp2px(mContext,5)));
                ArrayList<String> data = new ArrayList<>();
                data.add("https://ss2.baidu.com/-vo3dSag_xI4khGko9WTAnF6hhy/image/h%3D300/sign=c7cf816776f40ad10ae4c1e3672d1151/d439b6003af33a8724e4b645cb5c10385243b5e0.jpg");
                data.add("https://ss2.baidu.com/-vo3dSag_xI4khGko9WTAnF6hhy/image/h%3D300/sign=c7cf816776f40ad10ae4c1e3672d1151/d439b6003af33a8724e4b645cb5c10385243b5e0.jpg");
                data.add("https://ss2.baidu.com/-vo3dSag_xI4khGko9WTAnF6hhy/image/h%3D300/sign=c7cf816776f40ad10ae4c1e3672d1151/d439b6003af33a8724e4b645cb5c10385243b5e0.jpg");
                mlist.setAdapter(new CommonIvAdapter(data));
                break;
            case DATA_TYPE2:
                RecyclerView mgrid=helper.getView(R.id.mlist);
                mgrid.setLayoutManager(new GridLayoutManager(mContext,3));
                mgrid.addItemDecoration(new SpaceItemDecoration(UEMethod.dp2px(mContext,5)));
                ArrayList<String> gridData = new ArrayList<>();
                gridData.add("https://ss2.baidu.com/-vo3dSag_xI4khGko9WTAnF6hhy/image/h%3D300/sign=c7cf816776f40ad10ae4c1e3672d1151/d439b6003af33a8724e4b645cb5c10385243b5e0.jpg");
                gridData.add("https://ss2.baidu.com/-vo3dSag_xI4khGko9WTAnF6hhy/image/h%3D300/sign=c7cf816776f40ad10ae4c1e3672d1151/d439b6003af33a8724e4b645cb5c10385243b5e0.jpg");
                gridData.add("https://ss2.baidu.com/-vo3dSag_xI4khGko9WTAnF6hhy/image/h%3D300/sign=c7cf816776f40ad10ae4c1e3672d1151/d439b6003af33a8724e4b645cb5c10385243b5e0.jpg");
                TieIvAdapter adapter = new TieIvAdapter(gridData);
                adapter.setOnItemClickListener(new OnItemClickListener() {
                    @Override
                    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                        OnItemChildClickListener onItemChildClickListener = getOnItemChildClickListener();
                        int layoutPosition = helper.getLayoutPosition();
                        onItemChildClickListener.onItemChildClick(officAdapter.this,view,layoutPosition);
                    }
                });
                mgrid.setAdapter(adapter);
                SimpleDraweeView iv_head=helper.getView(R.id.iv_head);
                helper.addOnClickListener(R.id.mlist);
                iv_head.setImageURI("https://ss1.baidu.com/-4o3dSag_xI4khGko9WTAnF6hhy/image/h%3D300/sign=cc25cc7498cad1c8cfbbfa274f3f67c4/83025aafa40f4bfb0786420f0e4f78f0f7361813.jpg");
                SimpleDraweeView user_head=helper.getView(R.id.user_head);
                user_head.setImageURI("https://ss0.baidu.com/-Po3dSag_xI4khGko9WTAnF6hhy/image/h%3D300/sign=a792b4baaecc7cd9e52d32d909002104/32fa828ba61ea8d3f622db539a0a304e251f5860.jpg");
                break;
        }
    }
}
