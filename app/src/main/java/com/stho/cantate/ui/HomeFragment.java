package com.stho.cantate.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.core.view.GestureDetectorCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.stho.cantate.CantataListAdapter;
import com.stho.cantate.Cantate;
import com.stho.cantate.HomeFragmentViewModel;
import com.stho.cantate.R;
import com.stho.cantate.MainViewModel;
import com.stho.cantate.Sunday;
import com.stho.cantate.databinding.FragmentHomeBinding;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private static final String POSITION_PARAMETER = "POSITION";

    private HomeFragmentViewModel viewModel;
    private FragmentHomeBinding binding;
    private CantataListAdapter adapter;

    public HomeFragment() {
        // need public default constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = createViewModel(getPositionParameter());
        adapter = new CantataListAdapter();
    }

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.fragment_home, container, false);
        viewModel.getNextSundayLD().observe(this, this::setSunday);
        viewModel.getCantatasLD().observe(this, this::setCantatas);
        binding.list.setAdapter(adapter);
        binding.list.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.list.setHasFixedSize(true);
        binding.cardViewCatholic.setOnClickListener(v -> {
            // TODOs
            // Navigation.findNavController(v).navigate(...);
        });
        return binding.getRoot();
    }

    @SuppressWarnings("ConstantConditions")
    private HomeFragmentViewModel createViewModel(int position) {
        MainViewModel mainViewModel = ViewModelProviders.of(getActivity()).get(MainViewModel.class);
        HomeFragmentViewModel homeFragmentViewModel = ViewModelProviders.of(this).get(HomeFragmentViewModel.class);
        homeFragmentViewModel.setMainViewModel(mainViewModel);
        homeFragmentViewModel.setPosition(position);
        return homeFragmentViewModel;
    }

    public static HomeFragment newInstance(int position) {
        return new HomeFragment().setPositionParameter(position);
    }

    private HomeFragment setPositionParameter(int position) {
        Bundle args = new Bundle();
        args.putInt(POSITION_PARAMETER, position);
        this.setArguments(args);
        return this;
    }

    private int getPositionParameter() {
        Bundle args = getArguments();
        if (args != null) {
            return args.getInt(POSITION_PARAMETER, 0);
        }
        else {
            return 0;
        }
    }

    private void setSunday(Sunday sunday) {
        if (sunday != null) {
            binding.setOccasion(sunday);
            binding.setSunday(sunday.getEvangelicSunday());
            binding.setDominica(sunday.getCatholicDominica());
        }
    }

    private void setCantatas(ArrayList<Cantate> cantatas) {
        adapter.setCantatas(cantatas);
    }
}
