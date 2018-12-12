package com.system.tianma;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.system.myproject.BaseConfig;
import com.system.myproject.base.MVPBaseActivity;
import com.system.myproject.base.MVPBasePresenter;

public class MainActivity extends MVPBaseActivity {

    @Override
    protected MVPBasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int getThemeResId() {
        return 0;
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_main;
    }

    @Override
    protected void init(Bundle bundle) {

    }

    @Override
    protected void initDatas() {

    }
}
