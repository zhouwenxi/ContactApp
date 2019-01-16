package com.qishui.contact.fragment;

import android.os.Handler;
import android.view.View;
import android.widget.LinearLayout;

import com.qishui.commontoolslibrary.annotation.QBindView;
import com.qishui.commontoolslibrary.base.BaseQiShuiFragment;
import com.qishui.commontoolslibrary.state.StateLayoutManager;
import com.qishui.contact.R;

/**
 * Created by zhou on 2018/12/20.
 */

public class ContactFragment extends BaseQiShuiFragment {

    @QBindView(R.id.fragment_contract_ll)
    LinearLayout fragment_contract_ll;

    private StateLayoutManager stateLayoutManager;


    @Override
    protected int initLayout() {
        return R.layout.fragment_contract;
    }

    public void setStateLayoutAttrs(View view){
        stateLayoutManager=StateLayoutManager.with(fragment_contract_ll);
    }

    @Override
    protected void initEvent(View view) {

        stateLayoutManager.showLoading();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                stateLayoutManager.showDataError();
            }
        },2000);
    }


}
