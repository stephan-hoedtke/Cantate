package com.stho.cantate.ui;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.stho.cantate.HomePagerAdapter;
import com.stho.cantate.R;
import com.stho.cantate.databinding.FragmentHomeContainerBinding;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeContainerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeContainerFragment extends Fragment {

    private FragmentHomeContainerBinding binding;

    public HomeContainerFragment() {
        // Required empty public constructor
    }

    static HomeContainerFragment newInstance(String param1, String param2) {
        return new HomeContainerFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @SuppressWarnings("ConstantConditions")
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home_container, container, false);
        binding.pager.setAdapter(new HomePagerAdapter(getActivity().getSupportFragmentManager()));
        binding.pager.setCurrentItem(HomePagerAdapter.START_POSITION);
        return binding.getRoot();
    }
}

