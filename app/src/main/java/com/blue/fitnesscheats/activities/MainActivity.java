package com.blue.fitnesscheats.activities;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;

import com.blue.fitnesscheats.R;
import com.blue.fitnesscheats.fragments.CalculatorFragment;
import com.blue.fitnesscheats.fragments.CoursesFragment;
import com.blue.fitnesscheats.fragments.PlanFragment;

import java.util.ArrayList;

/**
 * Created by Blue on 2017/6/27.
 */

public class MainActivity extends Activity {
    private ArrayList<Fragment> fragmentArrayList;
    private Fragment mCurrentFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.navi_bottom);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                onBottomClick(item.getItemId());
                return true;
            }
        });
        initFragment();
    }

    private void initFragment() {
        fragmentArrayList = new ArrayList<Fragment>();
        fragmentArrayList.add(new PlanFragment());
        fragmentArrayList.add(new CoursesFragment());
        fragmentArrayList.add(new CalculatorFragment());
        changeFragment(0);
//        onBottomClick(R.id.tab_menu_plan);
    }

    private void changeFragment(int index) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        if (mCurrentFragment != null) {
            transaction.hide(mCurrentFragment);
        }
        Fragment fragment = getFragmentManager().findFragmentByTag(fragmentArrayList.get(index).getClass().getName());
        if (fragment == null) {
            fragment = fragmentArrayList.get(index);
        }
        mCurrentFragment = fragment;
        if (fragment != null && !fragment.isAdded()) {
            transaction.add(R.id.container_fl, fragment, fragment.getClass().getName());
        } else {
            transaction.show(fragment);
        }
        transaction.commit();
    }

    private void onBottomClick(int id) {
        switch (id) {
            case R.id.tab_menu_plan:
                changeFragment(0);
                break;
            case R.id.tab_menu_all:
                changeFragment(1);
                break;
            case R.id.tab_menu_calculator:
                changeFragment(2);
                break;
        }
    }

}
