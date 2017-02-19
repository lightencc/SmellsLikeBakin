package com.teamtreehouse.smellslikebakin;

/**
 * Created by chen on 2017/2/9.
 */

public class IngredientsFragment extends CheckBoxesFragment {

    @Override
    public String[] getContents(int index) {
        return Recipes.ingredients[index].split("`");
    }
}
