package com.example.commonbottomfragmentactivities;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class BottomFragment extends Fragment {

    private LinearLayout llActivityA;
    private LinearLayout llActivityB;
    private LinearLayout llActivityC;
    private LinearLayout llActivityD;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_bottom, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        llActivityA = view.findViewById(R.id.llActivityA);
        llActivityB = view.findViewById(R.id.llActivityB);
        llActivityC = view.findViewById(R.id.llActivityC);
        llActivityD = view.findViewById(R.id.llActivityD);

        AppCompatActivity currentActivity = (AppCompatActivity) getActivity();
        if (currentActivity instanceof ActivityA) {

            ((TextView)llActivityA.getChildAt(1)).setTextSize(22);

        }
        if (currentActivity instanceof ActivityB) {


            ((TextView)llActivityB.getChildAt(1)).setTextSize(22);

        }
        if (currentActivity instanceof ActivityC) {


            ((TextView)llActivityC.getChildAt(1)).setTextSize(22);

        }
        if (currentActivity instanceof ActivityD) {

            ((TextView)llActivityD.getChildAt(1)).setTextSize(22);
        }


        llActivityA.setOnClickListener(v -> startFragmentActivity(ActivityA.class));

        llActivityB.setOnClickListener(v -> startFragmentActivity(ActivityB.class));

        llActivityC.setOnClickListener(v -> startFragmentActivity(ActivityC.class));

        llActivityD.setOnClickListener(v -> startFragmentActivity(ActivityD.class));
    }



    private void startFragmentActivity(Class<? extends AppCompatActivity> activityClass) {
        Intent intent = new Intent(getActivity(), activityClass);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}