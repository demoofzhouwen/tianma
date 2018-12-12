package com.system.tianmayunxi.zp01yx_bwusb.ui.alltheme;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.facebook.drawee.view.SimpleDraweeView;
import com.system.myproject.base.MVPBaseFragment;
import com.system.myproject.base.MVPBasePresenter;
import com.system.myproject.utils.UEMethod;
import com.system.tianmayunxi.zp01yx_bwusb.R;
import com.system.tianmayunxi.zp01yx_bwusb.R2;
import com.system.tianmayunxi.zp01yx_bwusb.TmyxRouterConfig;
import com.system.tianmayunxi.zp01yx_bwusb.ui.alltheme.adapter.ThemeDetailAdapter;
import com.system.uilibrary.views.recyclerview.decoration.VerticalSpaceItemDecoration;
import com.system.uilibrary.views.titlebar.TitleBarView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

@Route(path = TmyxRouterConfig.TMYX_THEMEDETAIL)
public class ThemeDetailFragment extends MVPBaseFragment {
    @BindView(R2.id.titleBar)
    TitleBarView titleBar;
    @BindView(R2.id.mlist)
    RecyclerView mlist;
    @BindView(R2.id.iv)
    SimpleDraweeView iv;
    private ThemeDetailAdapter adapter;

    @Override
    protected MVPBasePresenter createPresenter() {
        return null;
    }

    @Override
    protected void init() {

    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_themedetail;
    }

    @Override
    protected void initDatas() {
        titleBar.setTitleMainText("主题信息")
                .setLeftTextDrawable(R.mipmap.icon_nav_back)
                .setOnLeftTextClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        pop();
                    }
                });
        iv.setImageURI("https://ss2.baidu.com/-vo3dSag_xI4khGko9WTAnF6hhy/image/h%3D300/sign=c7cf816776f40ad10ae4c1e3672d1151/d439b6003af33a8724e4b645cb5c10385243b5e0.jpg");
        mlist.setLayoutManager(new LinearLayoutManager(getThisContext()));
        mlist.addItemDecoration(new VerticalSpaceItemDecoration(UEMethod.dp2px(getThisContext(),5)));
        adapter = new ThemeDetailAdapter(new ArrayList<>());
        mlist.setAdapter(adapter);
        initList();
    }

    private void initList() {
        List<String> data = adapter.getData();
        data.add("");
        data.add("");
        data.add("");
        adapter.notifyDataSetChanged();
    }
}
