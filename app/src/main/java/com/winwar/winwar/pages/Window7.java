package com.winwar.winwar.pages;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.winwar.winwar.InstallActivity;
import com.winwar.winwar.R;
import com.winwar.winwar.adapter.CustomListViewAdapter;
import com.winwar.winwar.attribute.AppConstant;
import com.winwar.winwar.model.DetailStep;

import java.util.ArrayList;
import java.util.List;

public class Window7 extends android.support.v4.app.Fragment{

    private List<DetailStep> detailSteps;

    private ListView listView;

    public Window7() {

    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.window_7_install, container, false);

        detailSteps = initDetailStepWindow7();
        /* setup list view */
        listView = view.findViewById(R.id.listStepWindow7);

        CustomListViewAdapter adapter = new CustomListViewAdapter(detailSteps, getActivity().getApplicationContext());
        listView.setAdapter(adapter);

        return view;
    }

    private List<DetailStep> initDetailStepWindow7() {
        List<DetailStep> detailSteps = new ArrayList<>();
        for (int i = 0; i < AppConstant.NUMBER_OF_WINDOW7_STEP; i ++){
            DetailStep detailStep = new DetailStep(i+1);

            detailSteps.add(detailStep);
        }
        return detailSteps;
    }
}
