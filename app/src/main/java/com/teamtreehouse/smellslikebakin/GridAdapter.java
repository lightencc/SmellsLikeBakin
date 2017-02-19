package com.teamtreehouse.smellslikebakin;


/**
 * Created by chen on 2017/2/8.
 */

public class GridAdapter extends RecyclerAdapter {

    private final GridFragment.OnRecipeSelectedInterface mListener;

    public GridAdapter(GridFragment.OnRecipeSelectedInterface listener){
        this.mListener = listener;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.grid_item;
    }

    @Override
    protected void onListRecipeSelected(int index) {
        mListener.onGridRecipeSelected(index);
    }

}
