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

public abstract class RecyclerAdapter extends RecyclerView.Adapter {

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(getLayoutId(),parent,false);
        return new ListViewHolder(view);
    }

    protected abstract int getLayoutId();

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ListViewHolder)holder).bindView(position);
    }

    @Override
    public int getItemCount() {
        return Recipes.names.length;
    }

    private class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView mTextItem;
        private ImageView mImageItem;
        private int index;

        public ListViewHolder(View itemView) {
            super(itemView);
            mTextItem = (TextView) itemView.findViewById(R.id.itemText);
            mImageItem = (ImageView) itemView.findViewById(R.id.itemImage);
            itemView.setOnClickListener(this);
        }

        private void bindView(int position){
            index = position;
            mTextItem.setText(Recipes.names[position]);
            mImageItem.setImageResource(Recipes.resourceIds[position]);
        }

        @Override
        public void onClick(View v) {
            onListRecipeSelected(index);
        }
    }

    protected abstract void onListRecipeSelected(int index);
}
