package com.system.tianmayunxi.zp01yx_bwusb.ui.myissue;

import android.support.v4.view.ViewPager;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.system.myproject.base.MVPBaseFragment;
import com.system.myproject.base.MVPBasePresenter;
import com.system.tianmayunxi.zp01yx_bwusb.R;
import com.system.tianmayunxi.zp01yx_bwusb.R2;
import com.system.tianmayunxi.zp01yx_bwusb.TmyxRouterConfig;
import com.system.tianmayunxi.zp01yx_bwusb.adapter.ViewPagerAdapter;

import butterknife.BindView;
import me.yokeyword.fragmentation.SupportFragment;

/**
 * 我的发布
 */
@Route(path = TmyxRouterConfig.TMYX_WDFB)
public class MyIssueFragment extends MVPBaseFragment {
    @BindView(R2.id.viewpager)
    ViewPager mViewpager;
    private ViewPagerAdapter adapter;

    @Override
    protected MVPBasePresenter createPresenter() {
        return null;
    }

    @Override
    protected void init() {

    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_myissue;
    }

    @Override
    protected void initDatas() {
        adapter = new ViewPagerAdapter(getChildFragmentManager());

        SupportFragment fragment01 = (SupportFragment) ARouter
                .getInstance()
                .build(TmyxRouterConfig.WDFB_DYNAMIC)
                .navigation();
        SupportFragment fragment02 = (SupportFragment) ARouter
                .getInstance()
                .build(TmyxRouterConfig.WDFB_MESSAGE).navigation();

        adapter.addFrag(fragment01, "动态");
        adapter.addFrag(fragment02, "消息");
        mViewpager.setAdapter(adapter);
        mViewpager.setOffscreenPageLimit(3);

        mViewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:

                        break;
                    case 1:

                        break;

                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
