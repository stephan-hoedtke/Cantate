package com.stho.cantate.ui;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.stho.cantate.HomePagerAdapter;
import com.stho.cantate.MainViewModel;
import com.stho.cantate.R;
import com.stho.cantate.databinding.FragmentHomeContainerBinding;


public class HomeContainerFragment extends Fragment {

    private MainViewModel viewModel;
    private FragmentHomeContainerBinding binding;

    public HomeContainerFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = ViewModelProviders.of(getActivity()).get(MainViewModel.class);
    }

    @SuppressWarnings("ConstantConditions")
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home_container, container, false);
        HomePagerAdapter adapter = new HomePagerAdapter(getActivity().getSupportFragmentManager());
        adapter.setOnCurrentPositionChangedListener(new HomePagerAdapter.IOnCurrentPositionChangedListener() {
            @Override
            public void onCurrentPositionChanged(int position) {
                updateActionBar(position);
            }
        });
        binding.pager.setAdapter(adapter);
        viewModel.getCurrentPositionLD().observe(this, this::setCurrentPosition);
        return binding.getRoot();
    }

    private void setCurrentPosition(int position) {
        if (binding.pager.getCurrentItem() != position) {
            binding.pager.setCurrentItem(position);
        }
    }

    private void updateActionBar(int position) {
        // TODO find proper text to show here...
        String title = "Home";
        String subTitle = Integer.toString(position);
        updateActionBar(title, subTitle);
    }

    private void updateActionBar(String title, String subTitle) {
        ActionBar actionBar = ((AppCompatActivity)getActivity()).getSupportActionBar();
        actionBar.setTitle(title);
        actionBar.setSubtitle(subTitle);
        actionBar.setDisplayHomeAsUpEnabled(false);
        actionBar.setHomeButtonEnabled(false);
    }
}


