package com.qishui.contact.fragment;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.qishui.commontoolslibrary.annotation.QBindView;
import com.qishui.commontoolslibrary.banner.BannerView;
import com.qishui.commontoolslibrary.base.BaseQiShuiFragment;
import com.qishui.commontoolslibrary.core.LogUtils;
import com.qishui.contact.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhou on 2018/12/20.
 */

public class MessageFragment extends BaseQiShuiFragment {

    @QBindView(R.id.banner)
    BannerView bannerView;

    @Override
    protected int initLayout() {
        return R.layout.fragment_message;
    }

    @Override
    protected void initEvent(View view) {

        setBanner();


    }

    private void setBanner() {

        //数据
        List<Object> list = new ArrayList<>();
        list.add(R.drawable.banner);
        list.add(R.drawable.banner);
        list.add(R.drawable.banner);
        bannerView.setUnSelectId(R.drawable.white_point).setSelectId(R.drawable.red_point).setLocationLeft().setListViews(list).setImageLoader(new BannerView.ImageLoader() {
            @Override
            public void show(Context context, Object obj, ImageView iv) {
                iv.setImageResource((Integer) obj);
                LogUtils.e("~~~~~~~~~~~~~~~~~~~~~~");
            }
        }).setBannerClick(new BannerView.BannerCallBack() {
            @Override
            public void click(View view, int position) {
                toast("QQQQQQQQQQQQQQQ");
            }
        }).showView();
    }

    @Override
    public void onStart() {
        super.onStart();
        if(bannerView!=null){
            bannerView.stratPlay();
        }

    }

    @Override
    public void onStop() {
        super.onStop();
        if(bannerView!=null){
            bannerView.stopPlay();
        }
    }

}
