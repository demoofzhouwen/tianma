package com.system.tianmayunxi.zp01yx_bwusb.ui.main;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

import com.system.myproject.base.MVPBaseActivity;
import com.system.myproject.base.MVPBasePresenter;
import com.system.tianmayunxi.zp01yx_bwusb.R;
import com.system.tianmayunxi.zp01yx_bwusb.R2;

import butterknife.BindView;
import me.yokeyword.fragmentation.SupportFragment;

@Route(path = "/main/activity")
public class MainActivity extends MVPBaseActivity {
    @BindView(R2.id.fragment_main)
    FrameLayout layout;
    private int systemUiVisibility;

    @Override
    protected MVPBasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int getThemeResId() {
        return R.style.BlueTheme;
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_main;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
            //透明状态栏
        Window window = getWindow();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            // 透明状态栏
            window.addFlags(
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                systemUiVisibility = window.getDecorView().getSystemUiVisibility() | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN;
                window.getDecorView().setSystemUiVisibility(systemUiVisibility);
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                window.setStatusBarColor(Color.TRANSPARENT);
            }
        }
    }

    @Override
    protected void initDatas() {
        SupportFragment supportFragment = (SupportFragment) ARouter
                .getInstance()
                .build("//")
                .navigation();
        loadRootFragment(R.id.fragment_main,supportFragment);
    }
}
