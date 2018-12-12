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
import com.system.tianmayunxi.zp01yx_bwusb.ui.officialrecommend.adapter.ReportAdapter;
import com.system.uilibrary.views.titlebar.TitleBarView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

@Route(path = TmyxRouterConfig.TMYX_REPORT)
public class ReportFragment extends MVPBaseFragment {
    @BindView(R2.id.titleBar)
    TitleBarView titleBar;
    @BindView(R2.id.mlist)
    RecyclerView mlist;
    private ReportAdapter adapter;

    @Override
    protected MVPBasePresenter createPresenter() {
        return null;
    }

    @Override
    protected void init() {

    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_report;
    }

    @Override
    protected void initDatas() {
        titleBar.setTitleMainText("我要举报")
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
        adapter = new ReportAdapter(new ArrayList<>());
        mlist.setAdapter(adapter);
        initList();
    }

    private void initList() {
        List<String> data = adapter.getData();
        data.add("垃圾营销号");
        data.add("低俗色情");
        data.add("标题与内容不符");
        data.add("敏感信息");
        data.add("造谣/ 诽谤/内容失实");
        adapter.notifyDataSetChanged();
    }
}
