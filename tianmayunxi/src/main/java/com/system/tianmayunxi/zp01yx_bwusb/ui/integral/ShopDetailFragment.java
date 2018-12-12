package com.system.tianmayunxi.zp01yx_bwusb.ui.integral;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.listener.OnItemClickListener;
import com.system.myproject.base.MVPBaseFragment;
import com.system.myproject.base.MVPBasePresenter;
import com.system.tianmayunxi.zp01yx_bwusb.R;
import com.system.tianmayunxi.zp01yx_bwusb.R2;
import com.system.tianmayunxi.zp01yx_bwusb.TmyxRouterConfig;
import com.system.tianmayunxi.zp01yx_bwusb.bean.BannerBean;
import com.system.tianmayunxi.zp01yx_bwusb.ui.integral.adapter.ShopDetailAdapter;
import com.system.tianmayunxi.zp01yx_bwusb.views.NetWorkImageHolderView;
import com.system.uilibrary.views.titlebar.TitleBarView;


import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import me.yokeyword.fragmentation.SupportFragment;

@Route(path = TmyxRouterConfig.LQJF_SHOPDETAIL)
public class ShopDetailFragment extends MVPBaseFragment {
    @BindView(R2.id.titleBar)
    TitleBarView titleBar;
    @BindView(R2.id.convenientBanner)
    ConvenientBanner convenientBanner;
    @BindView(R2.id.mlist)
    RecyclerView mlist;
    private ShopDetailAdapter adapter;

    @Override
    protected MVPBasePresenter createPresenter() {
        return null;
    }

    @Override
    protected void init() {

    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_shopdetail;
    }

    @Override
    protected void initDatas() {
        titleBar.setTitleMainText("商品详情")
                .setLeftTextDrawable(R.mipmap.icon_nav_back)
                .setOnLeftTextClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        pop();
                    }
                });
        List<BannerBean> banners = null;
        if (banners == null) {
            banners = new ArrayList<>();
            BannerBean bannerBean = new BannerBean();
            bannerBean.setImg("https://f12.baidu.com/it/u=3712725086,1110359346&fm=72");
            banners.add(bannerBean);
        }
        if (banners != null && banners.size() > 0) {
            convenientBanner.setPages(
                    new CBViewHolderCreator() {
                        @Override
                        public NetWorkImageHolderView createHolder(View itemView) {
                            return new NetWorkImageHolderView(itemView);
                        }

                        @Override
                        public int getLayoutId() {
                            return R.layout.item_photoview;
                        }
                    }, banners);
            convenientBanner.setOnItemClickListener(new OnItemClickListener() {
                @Override
                public void onItemClick(int position) {

                }
            });
        }
        mlist.setLayoutManager(new LinearLayoutManager(getThisContext()));
        mlist.setNestedScrollingEnabled(false);
        adapter = new ShopDetailAdapter(new ArrayList<>());
        mlist.setAdapter(adapter);
        initList();
    }
    @OnClick({R2.id.tv_next})
    public void onClick(View view){
        SupportFragment fragment=null;
        switch (view.getId()){
            case R2.id.tv_next:
                fragment = (SupportFragment) ARouter.getInstance().build(TmyxRouterConfig.LQJF_ADDADDRESS)
                        .navigation();
                start(fragment);
                break;
        }
    }

    private void initList() {
        List<String> data = adapter.getData();
        data.add("https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=2296185292,1651244454&fm=26&gp=0.jpg");
        adapter.notifyDataSetChanged();
    }
}
