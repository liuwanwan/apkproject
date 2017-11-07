package com.mycourse.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.mycourse.fragment.BaseFragment;
import com.mycourse.fragment.PAAFragement;
import com.mycourse.fragment.CPVFragement;
import com.mycourse.fragment.MainUIFragement;

/**
 * Created by Administrator on 2017/2/25.
 */

public class MainFragmentAdapter extends FragmentPagerAdapter {
    private int sectionIndex;
    private String sectionName[] = {"知识点", "练习题", "记笔记"};

    public MainFragmentAdapter(FragmentManager fm, int section) {
        super(fm);
        sectionIndex = section;
    }

    @Override
    public Fragment getItem(int position) {
        BaseFragment fragment = null;
        if (sectionIndex == 0)//CPV
            switch (position) {
                case 0:
                    fragment = new MainUIFragement();
                    break;
                case 1:
                    fragment = new CPVFragement();
                    break;
                case 2:
                    fragment = new PAAFragement();
                    break;
                case 3:
                    fragment = new CPVFragement();
                    break;
            }
        if (sectionIndex == 1)
            switch (position) {
                case 0:
                   fragment = new MainUIFragement();
                    break;
                case 1:
                    fragment = new MainUIFragement();
                    break;
                case 2:
                    fragment = new MainUIFragement();
                    break;
            }
        return fragment;
    }

    @Override
    public int getCount() {
        return sectionName.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return sectionName[position];
    }
}
