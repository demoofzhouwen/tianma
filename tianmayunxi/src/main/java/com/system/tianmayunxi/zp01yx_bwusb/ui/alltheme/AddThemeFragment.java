package com.system.tianmayunxi.zp01yx_bwusb.ui.alltheme;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.system.myproject.base.MVPBaseFragment;
import com.system.myproject.base.MVPBasePresenter;
import com.system.tianmayunxi.zp01yx_bwusb.R;
import com.system.tianmayunxi.zp01yx_bwusb.R2;
import com.system.tianmayunxi.zp01yx_bwusb.TmyxRouterConfig;
import com.system.tianmayunxi.zp01yx_bwusb.adapter.AddImagePhotoAdapter;
import com.system.uilibrary.views.titlebar.TitleBarView;

import butterknife.BindView;

@Route(path = TmyxRouterConfig.TMYX_ADDZT)
public class AddThemeFragment extends MVPBaseFragment {
    @BindView(R2.id.titleBar)
    TitleBarView titleBar;
    @BindView(R2.id.mlist)
    RecyclerView mlist;
    private AddImagePhotoAdapter mAdapter;

    @Override
    protected MVPBasePresenter createPresenter() {
        return null;
    }

    @Override
    protected void init() {

    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_addtheme;
    }

    @Override
    protected void initDatas() {
        titleBar.setTitleMainText("发布主题")
                .setLeftTextDrawable(R.mipmap.icon_nav_back)
                .setRightText("发布")
                .setOnLeftTextClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        pop();
                    }
                });
        GridLayoutManager mGrdiLayoutManager = new GridLayoutManager(getThisContext(), 3);
        View view = LayoutInflater.from(getContext()).inflate(R.layout.add_themeiv, null);
        mlist.setLayoutManager(mGrdiLayoutManager);
        mAdapter = new AddImagePhotoAdapter();
        mAdapter.addFooterView(view);
        mAdapter.setFooterViewAsFlow(true);
        mlist.setAdapter(mAdapter);

    }
}
