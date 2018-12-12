package com.system.tianmayunxi.zp01yx_bwusb.ui.integral;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.system.myproject.base.MVPBaseFragment;
import com.system.myproject.base.MVPBasePresenter;
import com.system.myproject.utils.UEMethod;
import com.system.tianmayunxi.zp01yx_bwusb.R;
import com.system.tianmayunxi.zp01yx_bwusb.R2;
import com.system.tianmayunxi.zp01yx_bwusb.TmyxRouterConfig;
import com.system.tianmayunxi.zp01yx_bwusb.ui.integral.adapter.IntegralShopAdapter;
import com.system.uilibrary.views.recyclerview.decoration.SpaceItemDecoration;
import com.system.uilibrary.views.titlebar.TitleBarView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import me.yokeyword.fragmentation.SupportFragment;

@Route(path = TmyxRouterConfig.LQJF_JFSHOP)
public class IntegralShopFragment extends MVPBaseFragment {
    @BindView(R2.id.titleBar)
    TitleBarView titleBar;
    @BindView(R2.id.mlist)
    RecyclerView mlist;
    private IntegralShopAdapter adapter;

    @Override
    protected MVPBasePresenter createPresenter() {
        return null;
    }

    @Override
    protected void init() {

    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_integralshop;
    }

    @Override
    protected void initDatas() {
        titleBar.setTitleMainText("积分商城")
                .setLeftTextDrawable(R.mipmap.icon_nav_back)
                .setOnLeftTextClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        pop();
                    }
                });
        mlist.setLayoutManager(new GridLayoutManager(getThisContext(),2));
        mlist.addItemDecoration(new SpaceItemDecoration(UEMethod.dp2px(getThisContext(),8)));
        adapter = new IntegralShopAdapter(new ArrayList<>());
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                SupportFragment fragment=null;
                fragment = (SupportFragment) ARouter.getInstance().build(TmyxRouterConfig.LQJF_SHOPDETAIL)
                        .navigation();
                start(fragment);
            }
        });
        mlist.setAdapter(adapter);
        initList();
    }

    private void initList() {
        List<String> data = adapter.getData();
        data.add("");
        data.add("");
        data.add("");
        data.add("");
        adapter.notifyDataSetChanged();
    }
}
