package com.openclassrooms.entrevoisins.ui.neighbour_list;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class ListNeighbourPagerAdapter extends FragmentPagerAdapter {

    public ListNeighbourPagerAdapter(FragmentManager fm) {
        super(fm);
    }

   @Override
    public Fragment getItem(int position){
        switch (position){
            case 0 : NeighbourFragment.newInstance();

            case 1 : NeighbourFavoriteFragment.newInstance();

            default: return null;
        }
    }

    /**
     * getItem is called to instantiate the fragment for the given page.
     * @param position
     * @return
     */
    /*@Override
    public Fragment getItem(int position) {
        return NeighbourFragment.newInstance();

    }*/


    /**
     * get the number of pages
     * @return
     */
    @Override
    public int getCount() {
        return 2;
    }
}