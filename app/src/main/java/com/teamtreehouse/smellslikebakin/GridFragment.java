package com.teamtreehouse.smellslikebakin;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by chen on 2017/2/10.
 */

public class GridFragment extends Fragment {
    public interface OnRecipeSelectedInterface{
        public void onGridRecipeSelected(int index);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        GridFragment.OnRecipeSelectedInterface listener = (GridFragment.OnRecipeSelectedInterface) getActivity();
        View view = inflater.inflate(R.layout.fragment_recyclerview, container,false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        GridAdapter listAdapter = new GridAdapter(listener);
        recyclerView.setAdapter(listAdapter);

        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        float dpWidth = displayMetrics.widthPixels / displayMetrics.density;
        int numColumns = (int)dpWidth / 200;
        RecyclerView.LayoutManager layoutManger = new GridLayoutManager(getActivity(),numColumns);
        recyclerView.setLayoutManager(layoutManger);
        return view;
    }
}
