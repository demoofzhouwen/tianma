package com.system.tianmayunxi.zp01yx_bwusb.ui.officialrecommend;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.system.myproject.base.MVPBaseFragment;
import com.system.myproject.base.MVPBasePresenter;
import com.system.myproject.utils.UEMethod;
import com.system.tianmayunxi.zp01yx_bwusb.R;
import com.system.tianmayunxi.zp01yx_bwusb.R2;
import com.system.tianmayunxi.zp01yx_bwusb.TmyxRouterConfig;
import com.system.tianmayunxi.zp01yx_bwusb.ui.officialrecommend.adapter.officAdapter;
import com.system.tianmayunxi.zp01yx_bwusb.ui.officialrecommend.bean.CommonSeeBean;
import com.system.tianmayunxi.zp01yx_bwusb.ui.officialrecommend.bean.TieZiBean;
import com.system.uilibrary.views.recyclerview.decoration.VerticalSpaceItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import me.yokeyword.fragmentation.SupportFragment;

import static com.system.tianmayunxi.zp01yx_bwusb.ui.officialrecommend.adapter.officAdapter.DATA_TYPE1;
import static com.system.tianmayunxi.zp01yx_bwusb.ui.officialrecommend.adapter.officAdapter.DATA_TYPE2;


/**
 * 官方推荐
 */
@Route(path = TmyxRouterConfig.TMYX_GFTJ)
public class OfficRecommendFragment extends MVPBaseFragment {
    @BindView(R2.id.mlist)
    RecyclerView mlist;
    private officAdapter adapter;

    @Override
    protected MVPBasePresenter createPresenter() {
        return null;
    }

    @Override
    protected void init() {

    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_official_recommend;
    }

    @Override
    protected void initDatas() {
        LinearLayoutManager layout = new LinearLayoutManager(getThisContext());
        mlist.setLayoutManager(layout);
        mlist.addItemDecoration(new VerticalSpaceItemDecoration(UEMethod.dp2px(getThisContext(),5)));
        adapter = new officAdapter(new ArrayList<>());
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                SupportFragment fragment=null;
                SupportFragment parentFragment=null;
                MultiItemEntity item = (MultiItemEntity) adapter.getItem(position);
                switch (item.getItemType()){
                    case DATA_TYPE1:
                        break;
                    case DATA_TYPE2:
                        fragment = (SupportFragment) ARouter.getInstance().build(TmyxRouterConfig.TMYX_TIDETAIL)
                                .navigation();
                        parentFragment = (SupportFragment) getParentFragment();
                        parentFragment.start(fragment);
                        break;
                }
            }
        });
        adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                SupportFragment fragment=null;
                SupportFragment parentFragment=null;
                Object item1 = adapter.getItem(position);
                MultiItemEntity item = (MultiItemEntity) item1;
                switch (item.getItemType()){
                    case DATA_TYPE1:
                        switch (view.getId()){
                            case R2.id.tv_fb:
                                fragment = (SupportFragment) ARouter.getInstance().build(TmyxRouterConfig.TMYX_XZZT)
                                        .navigation();
                                parentFragment = (SupportFragment) getParentFragment();
                                parentFragment.start(fragment);
                                break;
                        }
                        break;
                    case DATA_TYPE2:
                        switch (view.getId()){
                            case R2.id.ll_iv:
                                fragment = (SupportFragment) ARouter.getInstance().build(TmyxRouterConfig.TMYX_CKIMAGE)
                                        .navigation();
                                parentFragment = (SupportFragment) getParentFragment();
                                parentFragment.start(fragment);
                                break;
                        }
                        break;
                }

            }
        });
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
        List<MultiItemEntity> data = adapter.getData();
        data.add(new CommonSeeBean());
        data.add(new TieZiBean());
        data.add(new TieZiBean());
        data.add(new TieZiBean());
        adapter.notifyDataSetChanged();
    }
}
