package com.teamtreehouse.smellslikebakin;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by chen on 2017/2/9.
 */

public class DirectionsFragment extends CheckBoxesFragment {

    @Override
    public String[] getContents(int index) {
        return Recipes.directions[index].split("`");
    }
}
