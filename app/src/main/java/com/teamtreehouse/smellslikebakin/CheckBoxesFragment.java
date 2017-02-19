package com.teamtreehouse.smellslikebakin;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;

/**
 * Created by chen on 2017/2/9.
 */

public abstract class CheckBoxesFragment extends Fragment {

    public static final String KEY_CHECKED_BOXES = "checked_boxes";
    CheckBox[] mCheckBoxes;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_checkboxes,container,false);
        int index = getArguments().getInt(ViewPagerFragment.KEY_RECIPE_INDEX);

        String[] contents = getContents(index);
        mCheckBoxes = new CheckBox[contents.length];
        boolean[] checkedBoxes = new boolean[mCheckBoxes.length];
        if(savedInstanceState != null && savedInstanceState.getBooleanArray(KEY_CHECKED_BOXES) != null){
            checkedBoxes = savedInstanceState.getBooleanArray(KEY_CHECKED_BOXES);
        }
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.checkboxesLayout);
        setUpCheckBoxs(contents,linearLayout,checkedBoxes);


        return view;
    }

    public abstract String[] getContents(int index);

    private void setUpCheckBoxs(String[] contents, ViewGroup container, boolean[] checkedBoxes){
        int i = 0;
        for(String content : contents){
            mCheckBoxes[i] = new CheckBox(getActivity());
            mCheckBoxes[i].setPadding(8,16,8,16);
            mCheckBoxes[i].setTextSize(20f);
            mCheckBoxes[i].setText(content);
            container.addView(mCheckBoxes[i]);
            if(checkedBoxes[i]){
                mCheckBoxes[i].toggle();
            }

            i++;
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        boolean[] stateOfCheckBoxes = new boolean[mCheckBoxes.length];
        int i = 0;
        for(CheckBox checkBox : mCheckBoxes){
            stateOfCheckBoxes[i] = checkBox.isChecked();
            i++;
        }
        outState.putBooleanArray(KEY_CHECKED_BOXES,stateOfCheckBoxes);
    }
}
