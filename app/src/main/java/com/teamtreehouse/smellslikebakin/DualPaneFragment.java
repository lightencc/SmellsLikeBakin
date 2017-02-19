package com.teamtreehouse.smellslikebakin;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import static com.teamtreehouse.smellslikebakin.ViewPagerFragment.KEY_RECIPE_INDEX;

/**
 * Created by chen on 2017/2/10.
 */

public class DualPaneFragment extends Fragment{

    public static final String INGREDIENTS_FRAGMENT = "ingredients_fragment";
    private static final String DIRECTIONS_FRAGMENT = "directions_fragment";


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dualpane,container,false);

        int index = getArguments().getInt(KEY_RECIPE_INDEX);

        IngredientsFragment ingredientsFragment = (IngredientsFragment) getChildFragmentManager().findFragmentByTag(INGREDIENTS_FRAGMENT);
        if (ingredientsFragment == null) {
            IngredientsFragment fragment = new IngredientsFragment();
            Bundle bundle = new Bundle();
            bundle.putInt(KEY_RECIPE_INDEX,index);
            fragment.setArguments(bundle);
            FragmentManager fragmentManager = getChildFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.leftPlaceholder, fragment, INGREDIENTS_FRAGMENT);
            fragmentTransaction.commit();
        }

        DirectionsFragment directionsFragment = (DirectionsFragment) getChildFragmentManager().findFragmentByTag(DIRECTIONS_FRAGMENT);
        if (directionsFragment == null) {
            DirectionsFragment fragment = new DirectionsFragment();
            Bundle bundle = new Bundle();
            bundle.putInt(KEY_RECIPE_INDEX,index);
            fragment.setArguments(bundle);
            FragmentManager fragmentManager = getChildFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.rightPlaceholder, fragment, DIRECTIONS_FRAGMENT);
            fragmentTransaction.commit();
        }
        
        return view;
    }

    @Override
    public void onStop() {
        super.onStop();
        getActivity().setTitle(getResources().getString(R.string.app_name));
    }
}
