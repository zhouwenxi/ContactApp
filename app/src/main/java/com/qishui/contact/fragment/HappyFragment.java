package com.qishui.contact.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.LinearLayout;

import com.qishui.commontoolslibrary.annotation.QBindView;
import com.qishui.commontoolslibrary.base.BaseQiShuiFragment;
import com.qishui.commontoolslibrary.state.StateLayoutManager;
import com.qishui.contact.R;
import com.qishui.mylibrary.base.BaseFragment;

/**
 * Created by zhou on 2018/12/20.
 */

public class HappyFragment extends BaseQiShuiFragment {

    @QBindView(R.id.fragment_happy_ll)
    LinearLayout fragment_happy_ll;

    private StateLayoutManager stateLayoutManager;

    @Override
    public void setStateLayoutAttrs() {
        stateLayoutManager=StateLayoutManager.with(fragment_happy_ll);
    }

    @Override
    protected int initLayout() {
        return R.layout.fragment_happy;
    }

    @Override
    protected void initEvent(Bundle savedInstanceState) {

        stateLayoutManager.showLoading();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                stateLayoutManager.showDataEmpty();
            }
        },2000);

    }

}
