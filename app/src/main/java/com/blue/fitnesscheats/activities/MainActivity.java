package com.blue.fitnesscheats.activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;

import com.blue.fitnesscheats.R;

/**
 * Created by Blue on 2017/6/27.
 */

public class MainActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.navi_bottom);
    }

}
