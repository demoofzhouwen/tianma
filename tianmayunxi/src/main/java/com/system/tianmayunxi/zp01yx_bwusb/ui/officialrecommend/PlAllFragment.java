package com.system.tianmayunxi.zp01yx_bwusb.ui.officialrecommend;

import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.facebook.drawee.view.SimpleDraweeView;
import com.system.myproject.base.MVPBaseFragment;
import com.system.myproject.base.MVPBasePresenter;
import com.system.tianmayunxi.zp01yx_bwusb.R;
import com.system.tianmayunxi.zp01yx_bwusb.R2;
import com.system.tianmayunxi.zp01yx_bwusb.TmyxRouterConfig;
import com.system.tianmayunxi.zp01yx_bwusb.ui.officialrecommend.adapter.PlAllAdapter;
import com.system.uilibrary.views.titlebar.TitleBarView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

@Route(path = TmyxRouterConfig.TMYX_PLALL)
public class PlAllFragment extends MVPBaseFragment {
    @BindView(R2.id.titleBar)
    TitleBarView titleBar;
    @BindView(R2.id.iv_head)
    SimpleDraweeView iv_head;
    @BindView(R2.id.pl_mlist)
    RecyclerView pl_mlist;
    private PlAllAdapter adapter;

    @Override
    protected MVPBasePresenter createPresenter() {
        return null;
    }

    @Override
    protected void init() {

    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_plall;
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
        iv_head.setImageURI("https://ss1.baidu.com/-4o3dSag_xI4khGko9WTAnF6hhy/image/h%3D300/sign=cc25cc7498cad1c8cfbbfa274f3f67c4/83025aafa40f4bfb0786420f0e4f78f0f7361813.jpg");
        pl_mlist.setLayoutManager(new LinearLayoutManager(getThisContext()));
        DividerItemDecoration decor = new DividerItemDecoration(getThisContext(), DividerItemDecoration.VERTICAL);
        decor.setDrawable(ContextCompat.getDrawable(getThisContext(), R.drawable.recyleview_line));
        pl_mlist.addItemDecoration(decor);
        pl_mlist.setNestedScrollingEnabled(false);
        adapter = new PlAllAdapter(new ArrayList<>());
        pl_mlist.setAdapter(adapter);
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
