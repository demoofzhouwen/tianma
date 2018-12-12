package com.system.tianmayunxi.zp01yx_bwusb.ui.alltheme;

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
import com.system.tianmayunxi.zp01yx_bwusb.ui.alltheme.adapter.ThemeAdapter;
import com.system.uilibrary.views.recyclerview.decoration.SpaceItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import me.yokeyword.fragmentation.SupportFragment;

@Route(path = TmyxRouterConfig.TMYX_QBZT)
public class AllThemeFragment extends MVPBaseFragment {
    @BindView(R2.id.mlist)
    RecyclerView mlist;
    private ThemeAdapter adapter;

    @Override
    protected MVPBasePresenter createPresenter() {
        return null;
    }

    @Override
    protected void init() {

    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_alltheme;
    }

    @Override
    protected void initDatas() {
        mlist.setLayoutManager(new GridLayoutManager(getThisContext(),3));
        mlist.addItemDecoration(new SpaceItemDecoration(UEMethod.dp2px(getThisContext(),5)));
        adapter = new ThemeAdapter(new ArrayList<String>());
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                SupportFragment fragment=null;
                SupportFragment parentFragment=null;
                fragment = (SupportFragment) ARouter.getInstance().build(TmyxRouterConfig.TMYX_THEMEDETAIL)
                        .navigation();
                parentFragment = (SupportFragment) getParentFragment();
                parentFragment.start(fragment);
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
        data.add("");
        data.add("");
        data.add("");
        data.add("");
        data.add("");
        adapter.notifyDataSetChanged();
    }
}
