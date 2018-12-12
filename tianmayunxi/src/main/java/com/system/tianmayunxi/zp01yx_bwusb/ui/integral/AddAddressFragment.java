package com.system.tianmayunxi.zp01yx_bwusb.ui.integral;

import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.system.myproject.base.MVPBaseFragment;
import com.system.myproject.base.MVPBasePresenter;
import com.system.tianmayunxi.zp01yx_bwusb.R;
import com.system.tianmayunxi.zp01yx_bwusb.R2;
import com.system.tianmayunxi.zp01yx_bwusb.TmyxRouterConfig;
import com.system.uilibrary.views.titlebar.TitleBarView;

import butterknife.BindView;
import me.yokeyword.fragmentation.SupportFragment;

@Route(path = TmyxRouterConfig.LQJF_ADDADDRESS)
public class AddAddressFragment extends MVPBaseFragment {
    @BindView(R2.id.titleBar)
    TitleBarView titleBar;
    @Override
    protected MVPBasePresenter createPresenter() {
        return null;
    }

    @Override
    protected void init() {

    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_addaddress;
    }

    @Override
    protected void initDatas() {
        titleBar.setTitleMainText("填写地址")
                .setLeftTextDrawable(R.mipmap.icon_nav_back)
                .setOnLeftTextClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        pop();
                    }
                }).setRightText("完成").setOnRightTextClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SupportFragment fragment = (SupportFragment) ARouter.getInstance().build(TmyxRouterConfig.TMYX_DHJG)
                        .navigation();
                start(fragment);
            }
        });
    }
}
