package com.system.tianmayunxi.zp01yx_bwusb.ui.integral;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.system.myproject.base.MVPBaseFragment;
import com.system.myproject.base.MVPBasePresenter;
import com.system.tianmayunxi.zp01yx_bwusb.R;
import com.system.tianmayunxi.zp01yx_bwusb.R2;
import com.system.tianmayunxi.zp01yx_bwusb.TmyxRouterConfig;
import com.system.tianmayunxi.zp01yx_bwusb.ui.integral.adapter.QdAdapter;
import com.system.tianmayunxi.zp01yx_bwusb.views.SwitchView;
import com.system.uilibrary.dialog.DialogsTools;
import com.system.uilibrary.views.titlebar.TitleBarView;


import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import me.yokeyword.fragmentation.SupportFragment;

/**
 * 领取积分
 */
@Route(path = TmyxRouterConfig.TMYX_LQJF)
public class IntegralFragment extends MVPBaseFragment {
    @BindView(R2.id.titleBar)
    TitleBarView titleBar;
    @BindView(R2.id.mlist)
    RecyclerView mlist;
    @BindView(R2.id.switchview)
    SwitchView switchView;
    private QdAdapter adapter;

    @Override
    protected MVPBasePresenter createPresenter() {
        return null;
    }

    @Override
    protected void init() {

    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_integral;
    }

    @Override
    protected void initDatas() {
        titleBar.setTitleMainText("领取积分")
                .setLeftTextDrawable(R.mipmap.icon_nav_back)
                .setOnLeftTextClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        pop();
                    }
                }).setRightText("积分商城").setOnRightTextClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SupportFragment fragment=null;
                fragment = (SupportFragment) ARouter.getInstance().build(TmyxRouterConfig.LQJF_JFSHOP)
                        .navigation();
                start(fragment);
            }
        });
        switchView.setOpenColor(Color.GREEN);
        switchView.setOnStateChangedListener(new SwitchView.OnStateChangedListener() {
            @Override
            public void toggleToOn(View view) {
                switchView.setOpened(true);
                DialogsTools.getInstance().createAndroidMessage("", "提醒开启成功, 每日21:00进行提醒请确保手机通知功能处于开启状态！",
                        "知道了", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        },getResources().getColor(R.color.blue_primary));
            }

            @Override
            public void toggleToOff(View view) {
                switchView.setOpened(false);
            }
        });

        LinearLayoutManager layout = new LinearLayoutManager(getThisContext());
        layout.setOrientation(LinearLayoutManager.HORIZONTAL);
        mlist.setLayoutManager(layout);
        adapter = new QdAdapter(new ArrayList<>());
        mlist.setAdapter(adapter);

    }

    @Override
    public void onEnterAnimationEnd(Bundle savedInstanceState) {
        super.onEnterAnimationEnd(savedInstanceState);
        initList();
    }

    @OnClick({R2.id.tv_userinfo,R2.id.tv_account,R2.id.tv_signrule,R2.id.tv_sign})
    public void onClick(View view){
        SupportFragment fragment=null;
        switch (view.getId()){
            case R2.id.tv_userinfo:
                fragment = (SupportFragment) ARouter.getInstance().build(TmyxRouterConfig.LQJF_INFO)
                        .navigation();
                start(fragment);
                break;
            case R2.id.tv_account:
                fragment = (SupportFragment) ARouter.getInstance().build(TmyxRouterConfig.LQJF_ACCOUNT)
                        .navigation();
                start(fragment);
                break;
            case R2.id.tv_signrule:
                fragment = (SupportFragment) ARouter.getInstance().build(TmyxRouterConfig.TMYX_SIGNRULE)
                        .navigation();
                start(fragment);
                break;
            case R2.id.tv_sign:
                View inflate = LayoutInflater.from(getThisContext()).inflate(R.layout.custom_sign, null, false);
                DialogsTools.getInstance().CreateCustomViewDialog(inflate, new DialogsTools.onButtonClickListener() {
                    @Override
                    public void onClick(String message) {

                    }
                });
                break;
        }
    }

    private void initList() {
        List<String> data = adapter.getData();
        for (int i=0;i<7;i++){
            data.add("");
        }
        adapter.notifyDataSetChanged();
    }
}
