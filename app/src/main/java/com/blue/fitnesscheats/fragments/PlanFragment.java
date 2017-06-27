package com.blue.fitnesscheats.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.blue.fitnesscheats.R;

/**
 * Created by Blue on 2017/6/27.
 */

public class PlanFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.plan_fragment, container, false);
        Log.d("bluedai", "PlanFragment");
        return view;
    }
}
