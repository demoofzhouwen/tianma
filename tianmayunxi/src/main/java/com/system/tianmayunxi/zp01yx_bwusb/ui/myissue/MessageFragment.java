package com.system.tianmayunxi.zp01yx_bwusb.ui.myissue;

import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.system.myproject.base.MVPBaseFragment;
import com.system.myproject.base.MVPBasePresenter;
import com.system.tianmayunxi.zp01yx_bwusb.R;
import com.system.tianmayunxi.zp01yx_bwusb.R2;
import com.system.tianmayunxi.zp01yx_bwusb.TmyxRouterConfig;
import com.system.tianmayunxi.zp01yx_bwusb.ui.myissue.adapter.MessageAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

@Route(path = TmyxRouterConfig.WDFB_MESSAGE)
public class MessageFragment extends MVPBaseFragment {
    @BindView(R2.id.mlist)
    RecyclerView mlist;
    private MessageAdapter adapter;

    @Override
    protected MVPBasePresenter createPresenter() {
        return null;
    }

    @Override
    protected void init() {

    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_message;
    }

    @Override
    protected void initDatas() {
        mlist.setLayoutManager(new LinearLayoutManager(getThisContext()));
        DividerItemDecoration decor = new DividerItemDecoration(getThisContext(), DividerItemDecoration.VERTICAL);
        decor.setDrawable(ContextCompat.getDrawable(getThisContext(),R.drawable.recyleview_line));
        mlist.addItemDecoration(decor);
        adapter = new MessageAdapter(new ArrayList<>());
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
