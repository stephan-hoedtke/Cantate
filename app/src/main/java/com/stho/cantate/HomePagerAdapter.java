package com.stho.cantate;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.stho.cantate.ui.HomeFragment;

public class HomePagerAdapter extends FragmentStatePagerAdapter {

    public final static int START_POSITION = 100000;
    private IOnCurrentPositionChangedListener listener = null;

    public interface IOnCurrentPositionChangedListener {
        void onCurrentPositionChanged(int position);
    }

    public HomePagerAdapter(FragmentManager fm) {
        super(fm, FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
    }

    public void setOnCurrentPositionChangedListener(IOnCurrentPositionChangedListener listener) {
        this.listener = listener;
    }

    @Override
    public int getCount() {
        return HomePagerAdapter.START_POSITION * 2;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return HomeFragment.newInstance(position);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        super.destroyItem(container, position, object);
    }

    @Override
    public void setPrimaryItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        super.setPrimaryItem(container, position, object);
        if (listener != null)
            listener.onCurrentPositionChanged(position);
    }
}

