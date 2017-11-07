package com.mycourse.fragment;

import android.os.Bundle;


public class PAAFragement extends BaseFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);// 为了在Fragment中显示右上角的menu
    }

   
}
