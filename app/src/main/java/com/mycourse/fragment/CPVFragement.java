package com.mycourse.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mycourse.R;


public class CPVFragement extends BaseFragment {
    private View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);// 为了在Fragment中显示右上角的menu
         view = inflater.inflate(R.layout.layout_cpv_fragment, container, false);
    return view;
    }

   
}
