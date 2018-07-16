package com.xzxx.decorate.o2o.master;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import com.xzxx.decorate.o2o.fragment.BaseFragment;
import com.xzxx.decorate.o2o.fragment.FragmentFactory;

public class PersonalOrderActivity extends AppCompatActivity {

    private TabLayout mTabLayout = null;
    private ViewPager mViewPager;
    private PageAdatper pageAdatper;
    private int[] mTabTitles = new int[]{R.string.all_order, R.string.to_be_receipt, R.string.after_sale_service};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personal_order);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    private class PageAdatper extends FragmentPagerAdapter {

        public PageAdatper(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            BaseFragment fragment = FragmentFactory.createFragment(position);
            return fragment;
        }

        @Override
        public int getCount() {
            return mTabTitles.length;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return getString(mTabTitles[position]);
        }
    }
}
