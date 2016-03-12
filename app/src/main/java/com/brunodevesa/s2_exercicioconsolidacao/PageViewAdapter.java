package com.brunodevesa.s2_exercicioconsolidacao;

import android.app.Activity;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by bruno.devesa on 12/03/2016.
 */
public class PageViewAdapter extends PagerAdapter {

    View layout;
    private ArrayList<Integer> layout_ids;
    Activity mActivity;


    public PageViewAdapter(Activity activity, final int vec[]) {
        mActivity = activity;
        this.layout_ids = new ArrayList<>();
        for (int i = 0; i < vec.length; i++) {
            layout_ids.add(vec[i]);
        }

    }

    @Override
    public int getCount() {
        return layout_ids.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((View) object);
    }


    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        LayoutInflater inflater = (LayoutInflater)mActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        layout = inflater.inflate(layout_ids.get(position), null);
        ((ViewPager) container).addView(layout, 0);
        return layout;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager) container).removeView((View) object);
    }
}
