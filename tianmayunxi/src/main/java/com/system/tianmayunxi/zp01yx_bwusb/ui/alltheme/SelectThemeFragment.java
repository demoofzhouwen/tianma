package com.system.tianmayunxi.zp01yx_bwusb.ui.alltheme;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.library.flowlayout.FlowLayoutManager;
import com.system.myproject.base.MVPBaseFragment;
import com.system.myproject.base.MVPBasePresenter;
import com.system.myproject.utils.UEMethod;
import com.system.tianmayunxi.zp01yx_bwusb.R;
import com.system.tianmayunxi.zp01yx_bwusb.R2;
import com.system.tianmayunxi.zp01yx_bwusb.TmyxRouterConfig;
import com.system.tianmayunxi.zp01yx_bwusb.ui.alltheme.adapter.ThemeListAdapter;
import com.system.uilibrary.views.recyclerview.decoration.SpaceItemDecoration;
import com.system.uilibrary.views.titlebar.TitleBarView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import me.yokeyword.fragmentation.SupportFragment;

@Route(path = TmyxRouterConfig.TMYX_XZZT)
public class SelectThemeFragment extends MVPBaseFragment {
    @BindView(R2.id.titleBar)
    TitleBarView titleBar;
    @BindView(R2.id.mlist)
    RecyclerView mlist;
    private ThemeListAdapter adapter;

    @Override
    protected MVPBasePresenter createPresenter() {
        return null;
    }

    @Override
    protected void init() {

    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_selecttheme;
    }

    @Override
    protected void initDatas() {
        titleBar.setTitleMainText("选择主题")
                .setLeftText("取消")
                .setOnLeftTextClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        pop();
                    }
                });
        FlowLayoutManager flowLayoutManager = new FlowLayoutManager();
        mlist.setLayoutManager(flowLayoutManager);
        mlist.addItemDecoration(new SpaceItemDecoration(UEMethod.dp2px(getThisContext(),5)));
        adapter = new ThemeListAdapter(new ArrayList<>());
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                SupportFragment fragment=null;
                fragment = (SupportFragment) ARouter.getInstance().build(TmyxRouterConfig.TMYX_ADDZT)
                        .navigation();
                start(fragment);
            }
        });
        mlist.setAdapter(adapter);
        initList();
    }

    private void initList() {
        List<String> data = adapter.getData();
        data.add("#大师的影像世界#");
        data.add("#大师的影像世界#");
        data.add("#宫崎骏的作品集#");
        data.add("#发现美妆#");
        data.add("#发现好物#");
        data.add("#发现好物#");
        adapter.notifyDataSetChanged();
    }
}
