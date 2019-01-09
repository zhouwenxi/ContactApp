package com.qishui.contact.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import com.qishui.commontoolslibrary.annotation.QBindView;
import com.qishui.commontoolslibrary.base.BaseQiShuiFragment;
import com.qishui.commontoolslibrary.state.StateLayoutManager;
import com.qishui.contact.R;

/**
 * Created by zhou on 2018/12/20.
 */

public class MessageFragment extends BaseQiShuiFragment {

    @QBindView(R.id.fragment_message_rv)
    RecyclerView fragment_message_ll;

    private StateLayoutManager stateLayoutManager;

    @Override
    public void setStateLayoutAttrs() {
        stateLayoutManager=StateLayoutManager.with(fragment_message_ll);
    }

    @Override
    protected int initLayout() {
        return R.layout.fragment_message;
    }

    @Override
    protected void initEvent(Bundle savedInstanceState) {

        stateLayoutManager.showLoading();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                stateLayoutManager.showNetworkError();
            }
        },2000);

    }

}
