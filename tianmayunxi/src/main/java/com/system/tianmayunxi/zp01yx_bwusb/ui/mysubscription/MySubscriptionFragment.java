package com.system.tianmayunxi.zp01yx_bwusb.ui.mysubscription;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.system.myproject.base.MVPBaseFragment;
import com.system.myproject.base.MVPBasePresenter;
import com.system.myproject.utils.UEMethod;
import com.system.tianmayunxi.zp01yx_bwusb.R;
import com.system.tianmayunxi.zp01yx_bwusb.R2;
import com.system.tianmayunxi.zp01yx_bwusb.TmyxRouterConfig;
import com.system.tianmayunxi.zp01yx_bwusb.ui.mysubscription.adapter.MySubAdapter;
import com.system.uilibrary.views.recyclerview.decoration.VerticalSpaceItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import me.yokeyword.fragmentation.SupportFragment;

/**
 * 我的订阅
 */
@Route(path = TmyxRouterConfig.TMYX_WDDY)
public class MySubscriptionFragment extends MVPBaseFragment {
    @BindView(R2.id.mlist)
    RecyclerView mlist;
    private MySubAdapter adapter;

    @Override
    protected MVPBasePresenter createPresenter() {
        return null;
    }

    @Override
    protected void init() {

    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_mysubscrio;
    }

    @Override
    protected void initDatas() {
        mlist.setLayoutManager(new LinearLayoutManager(getThisContext()));
        mlist.addItemDecoration(new VerticalSpaceItemDecoration(UEMethod.dp2px(getThisContext(),5)));
        adapter = new MySubAdapter(new ArrayList<>());
        mlist.setAdapter(adapter);
        initList();
    }
    @OnClick({R2.id.iv_jf})
    public void onClick(View view){
        SupportFragment fragment=null;
        SupportFragment parentFragment=null;
        switch (view.getId()){
            case R2.id.iv_jf:
                fragment = (SupportFragment) ARouter.getInstance().build(TmyxRouterConfig.TMYX_LQJF)
                        .navigation();
                parentFragment = (SupportFragment) getParentFragment();
                parentFragment.start(fragment);
                break;
        }
    }

    private void initList() {
        List<String> data = adapter.getData();
        data.add("");
        data.add("");
        data.add("");
        adapter.notifyDataSetChanged();
    }
}
