package com.teamtreehouse.smellslikebakin;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * Created by chen on 2017/2/8.
 */

public class ListAdapter extends RecyclerAdapter {

    private final ListFragment.OnRecipeSelectedInterface mListener;

    public ListAdapter(ListFragment.OnRecipeSelectedInterface listener){
        this.mListener = listener;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.list_item;
    }

    @Override
    protected void onListRecipeSelected(int index) {
        mListener.onListRecipeSelected(index);
    }

}
