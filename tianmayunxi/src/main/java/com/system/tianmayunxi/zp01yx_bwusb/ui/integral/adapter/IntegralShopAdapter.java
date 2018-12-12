package com.system.tianmayunxi.zp01yx_bwusb.ui.integral.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.system.myproject.utils.UEMethod;
import com.system.tianmayunxi.zp01yx_bwusb.R;

import java.util.List;

public class IntegralShopAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    public IntegralShopAdapter(@Nullable List<String> data) {
        super(R.layout.fragment_integralshop_item, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        SimpleDraweeView iv=helper.getView(R.id.iv);
        iv.setImageURI("https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=4154581417,3895758580&fm=26&gp=0.jpg");

        RoundingParams roundingParams = new RoundingParams();
        roundingParams.setCornersRadii(UEMethod.dp2px(mContext,10), UEMethod.dp2px(mContext,10), 0, 0);
        GenericDraweeHierarchyBuilder builder = new GenericDraweeHierarchyBuilder(mContext.getResources());
        GenericDraweeHierarchy hierarchy = builder.build();
        hierarchy.setRoundingParams(roundingParams);
        iv.setHierarchy(hierarchy);
    }

}
