package com.system.tianmayunxi.zp01yx_bwusb.ui.officialrecommend;

import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.aries.ui.view.alpha.AlphaTextView;
import com.aries.ui.widget.BasisDialog;
import com.aries.ui.widget.action.sheet.UIActionSheetDialog;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.facebook.drawee.view.SimpleDraweeView;
import com.library.flowlayout.SpaceItemDecoration;
import com.system.myproject.base.MVPBaseFragment;
import com.system.myproject.base.MVPBasePresenter;
import com.system.myproject.utils.SizeUtil;
import com.system.myproject.utils.UEMethod;
import com.system.tianmayunxi.zp01yx_bwusb.R;
import com.system.tianmayunxi.zp01yx_bwusb.R2;
import com.system.tianmayunxi.zp01yx_bwusb.TmyxRouterConfig;
import com.system.tianmayunxi.zp01yx_bwusb.ui.officialrecommend.adapter.PlAdapter;
import com.system.tianmayunxi.zp01yx_bwusb.ui.officialrecommend.adapter.TieIvAdapter;


import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import me.yokeyword.fragmentation.SupportFragment;

@Route(path = TmyxRouterConfig.TMYX_TIDETAIL)
public class TiDetailFragment extends MVPBaseFragment {
    @BindView(R2.id.head)
    SimpleDraweeView head;
    @BindView(R2.id.iv_head)
    SimpleDraweeView iv_head;
    @BindView(R2.id.user_head)
    SimpleDraweeView user_head;
    @BindView(R2.id.mlist)
    RecyclerView mlist;
    @BindView(R2.id.pl_mlist)
    RecyclerView pl_mlist;
    private PlAdapter adapter;

    @Override
    protected MVPBasePresenter createPresenter() {
        return null;
    }

    @Override
    protected void init() {

    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_tidetail;
    }

    @Override
    protected void initDatas() {
        head.setImageURI("https://ss1.baidu.com/-4o3dSag_xI4khGko9WTAnF6hhy/image/h%3D300/sign=cc25cc7498cad1c8cfbbfa274f3f67c4/83025aafa40f4bfb0786420f0e4f78f0f7361813.jpg");

        iv_head.setImageURI("https://ss1.baidu.com/-4o3dSag_xI4khGko9WTAnF6hhy/image/h%3D300/sign=cc25cc7498cad1c8cfbbfa274f3f67c4/83025aafa40f4bfb0786420f0e4f78f0f7361813.jpg");
        user_head.setImageURI("https://ss0.baidu.com/-Po3dSag_xI4khGko9WTAnF6hhy/image/h%3D300/sign=a792b4baaecc7cd9e52d32d909002104/32fa828ba61ea8d3f622db539a0a304e251f5860.jpg");
        mlist.setLayoutManager(new GridLayoutManager(getThisContext(), 3));
        mlist.addItemDecoration(new SpaceItemDecoration(UEMethod.dp2px(getThisContext(), 5)));
        ArrayList<String> gridData = new ArrayList<>();
        gridData.add("https://ss2.baidu.com/-vo3dSag_xI4khGko9WTAnF6hhy/image/h%3D300/sign=c7cf816776f40ad10ae4c1e3672d1151/d439b6003af33a8724e4b645cb5c10385243b5e0.jpg");
        gridData.add("https://ss2.baidu.com/-vo3dSag_xI4khGko9WTAnF6hhy/image/h%3D300/sign=c7cf816776f40ad10ae4c1e3672d1151/d439b6003af33a8724e4b645cb5c10385243b5e0.jpg");
        gridData.add("https://ss2.baidu.com/-vo3dSag_xI4khGko9WTAnF6hhy/image/h%3D300/sign=c7cf816776f40ad10ae4c1e3672d1151/d439b6003af33a8724e4b645cb5c10385243b5e0.jpg");
        mlist.setAdapter(new TieIvAdapter(gridData));
        pl_mlist.setLayoutManager(new LinearLayoutManager(getThisContext()));
        DividerItemDecoration decor = new DividerItemDecoration(getThisContext(), DividerItemDecoration.VERTICAL);
        decor.setDrawable(ContextCompat.getDrawable(getThisContext(), R.drawable.recyleview_line));
        pl_mlist.addItemDecoration(decor);
        pl_mlist.setNestedScrollingEnabled(false);
        adapter = new PlAdapter(new ArrayList<>());
        adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                SupportFragment fragment = null;

                switch (view.getId()) {
                    case R2.id.btn_pl:
                        fragment = (SupportFragment) ARouter.getInstance().build(TmyxRouterConfig.TMYX_PLLIST)
                                .navigation();
                        start(fragment);
                        break;
                }
            }
        });
        pl_mlist.setAdapter(adapter);
        initList();
    }
    @OnClick({R2.id.iv_pl,R2.id.tv_share})
    public void onClick(View view){
        SupportFragment fragment=null;
        switch (view.getId()){
            case R2.id.iv_pl:
                fragment = (SupportFragment) ARouter.getInstance().build(TmyxRouterConfig.TMYX_PLALL)
                        .navigation();
                start(fragment);
                break;
            case R2.id.tv_share:
                UIActionSheetDialog dialog = new UIActionSheetDialog.GridBuilder(getThisContext())
                        .addItem("微信", R.mipmap.icon_sharewx)
                        .addItem("朋友圈", R.mipmap.icon_sharefriends)
                        .addItem("QQ好友", R.mipmap.icon_shareqq)
                        .addItem("QQ空间", R.mipmap.icon_sharespace)
                        .addItem("微博", R.mipmap.icon_sharewb)
                        .addItem("我要举报", R.mipmap.icon_jb)
                        .addItem("保存图片", R.mipmap.icon_savepic)
                        .addItem("我要点赞", R.mipmap.icon_wydz)
                        .setItemsTextColorResource(R.color.colorActionSheetNormalItemText)
                        .setCancel(R.string.cancel)
                        .setCancelMarginTop(SizeUtil.dp2px( 8 ))
                        .setNumColumns(5)
                        .setItemsTextSize(14)
                        .setTextDrawablePadding(UEMethod.dp2px(getThisContext(),5))
                        .setTextPadding(0,UEMethod.dp2px(getThisContext(),5),0,UEMethod.dp2px(getThisContext(),5))
                        .setItemsImageWidth(SizeUtil.dp2px(50))
                        .setItemsImageHeight(SizeUtil.dp2px(50))
                        .setItemsClickBackgroundEnable(false)
                        .setOnItemClickListener(new UIActionSheetDialog.OnItemClickListener() {
                            @Override
                            public void onClick(BasisDialog dialog, View itemView, int position) {
                                SupportFragment fragment=null;
                                AlphaTextView itemView1 = (AlphaTextView) itemView;
                                String item = itemView1.getText().toString();
                                switch (item){
                                    case "微信":
                                        break;
                                    case "朋友圈":
                                        break;
                                    case "QQ好友":
                                        break;
                                    case "QQ空间":
                                        break;
                                    case "微博":
                                        break;
                                    case "我要举报":
                                        fragment = (SupportFragment) ARouter.getInstance().build(TmyxRouterConfig.TMYX_REPORT)
                                                .navigation();
                                        start(fragment);
                                        break;
                                    case "保存图片":
                                        break;
                                    case "我要点赞":
                                        break;
                                }
                            }
                        })
                        .create();


                dialog.show();
                break;
        }
    }

    private void initList() {
        List<String> data = adapter.getData();
        data.add("");
        data.add("");
        data.add("");
        data.add("");
        adapter.notifyDataSetChanged();
    }
}
