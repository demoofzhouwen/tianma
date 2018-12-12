package com.system.tianmayunxi.zp01yx_bwusb.ui.officialrecommend;

import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.system.myproject.base.MVPBaseFragment;
import com.system.myproject.base.MVPBasePresenter;
import com.system.tianmayunxi.zp01yx_bwusb.R;
import com.system.tianmayunxi.zp01yx_bwusb.R2;
import com.system.tianmayunxi.zp01yx_bwusb.TmyxRouterConfig;
import com.system.tianmayunxi.zp01yx_bwusb.ui.officialrecommend.adapter.PlListAdapter;
import com.system.uilibrary.views.titlebar.TitleBarView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

@Route(path = TmyxRouterConfig.TMYX_PLLIST)
public class PinLunListFragment extends MVPBaseFragment {
    @BindView(R2.id.titleBar)
    TitleBarView titleBar;
    @BindView(R2.id.mlist)
    RecyclerView mlist;
    private PlListAdapter adapter;

    @Override
    protected MVPBasePresenter createPresenter() {
        return null;
    }

    @Override
    protected void init() {

    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_pllist;
    }

    @Override
    protected void initDatas() {
        titleBar.setTitleMainText("评论")
                .setLeftTextDrawable(R.mipmap.icon_nav_back)
                .setOnLeftTextClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        pop();
                    }
                });
        mlist.setLayoutManager(new LinearLayoutManager(getThisContext()));
        DividerItemDecoration decor = new DividerItemDecoration(getThisContext(), DividerItemDecoration.VERTICAL);
        decor.setDrawable(ContextCompat.getDrawable(getThisContext(),R.drawable.recyleview_line));
        mlist.addItemDecoration(decor);
        mlist.setNestedScrollingEnabled(false);
        adapter = new PlListAdapter(new ArrayList<>());
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
