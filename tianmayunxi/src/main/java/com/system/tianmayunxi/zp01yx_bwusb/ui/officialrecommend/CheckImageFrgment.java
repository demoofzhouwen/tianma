package com.system.tianmayunxi.zp01yx_bwusb.ui.officialrecommend;

import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.aries.ui.view.alpha.AlphaTextView;
import com.aries.ui.widget.BasisDialog;
import com.aries.ui.widget.action.sheet.UIActionSheetDialog;
import com.facebook.drawee.view.SimpleDraweeView;
import com.system.myproject.base.MVPBaseFragment;
import com.system.myproject.base.MVPBasePresenter;
import com.system.myproject.utils.SizeUtil;
import com.system.myproject.utils.UEMethod;
import com.system.tianmayunxi.zp01yx_bwusb.R;
import com.system.tianmayunxi.zp01yx_bwusb.R2;
import com.system.tianmayunxi.zp01yx_bwusb.TmyxRouterConfig;
import com.system.tianmayunxi.zp01yx_bwusb.ui.officialrecommend.adapter.UltraPagerAdapter;
import com.tmall.ultraviewpager.UltraViewPager;

import butterknife.BindView;
import butterknife.OnClick;
import me.yokeyword.fragmentation.SupportFragment;

@Route(path = TmyxRouterConfig.TMYX_CKIMAGE)
public class CheckImageFrgment extends MVPBaseFragment {
    @BindView(R2.id.ultra_viewpager)
    UltraViewPager ultraViewPager;
    @BindView(R2.id.head)
    SimpleDraweeView head;
    private int[] images = {R.mipmap.item1, R.mipmap.item2, R.mipmap.item3, R.mipmap.item4, R.mipmap.item5, R.mipmap.item6};
    private UltraPagerAdapter adapter;

    @Override
    protected MVPBasePresenter createPresenter() {
        return null;
    }

    @Override
    protected void init() {

    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_checkimage;
    }

    @Override
    protected void initDatas() {


        head.setImageURI("https://ss1.baidu.com/-4o3dSag_xI4khGko9WTAnF6hhy/image/h%3D300/sign=cc25cc7498cad1c8cfbbfa274f3f67c4/83025aafa40f4bfb0786420f0e4f78f0f7361813.jpg");
        ultraViewPager.setScrollMode(UltraViewPager.ScrollMode.HORIZONTAL);
        adapter = new UltraPagerAdapter(true, images);
        adapter.setListener(new UltraPagerAdapter.onImageViewClickListener() {
            @Override
            public void onListener(int position) {

            }
        });
        ultraViewPager.setAdapter(adapter);

    }

    @OnClick({R2.id.iv_pl, R2.id.tv_share,R2.id.iv_back})
    public void onClick(View view) {
        SupportFragment fragment = null;
        switch (view.getId()) {
            case R2.id.iv_pl:
                fragment = (SupportFragment) ARouter.getInstance().build(TmyxRouterConfig.TMYX_PLALL)
                        .navigation();
                start(fragment);
                break;
            case R2.id.iv_back:
                pop();
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
                        .setCancelMarginTop(SizeUtil.dp2px(8))
                        .setNumColumns(5)
                        .setItemsTextSize(14)
                        .setTextDrawablePadding(UEMethod.dp2px(getThisContext(), 5))
                        .setTextPadding(0, UEMethod.dp2px(getThisContext(), 5), 0, UEMethod.dp2px(getThisContext(), 5))
                        .setItemsImageWidth(SizeUtil.dp2px(50))
                        .setItemsImageHeight(SizeUtil.dp2px(50))
                        .setItemsClickBackgroundEnable(false)
                        .setOnItemClickListener(new UIActionSheetDialog.OnItemClickListener() {
                            @Override
                            public void onClick(BasisDialog dialog, View itemView, int position) {
                                SupportFragment fragment = null;
                                AlphaTextView itemView1 = (AlphaTextView) itemView;
                                String item = itemView1.getText().toString();
                                switch (item) {
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
}
