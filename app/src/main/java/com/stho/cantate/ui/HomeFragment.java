package com.stho.cantate.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.stho.cantate.CantataListAdapter;
import com.stho.cantate.Cantate;
import com.stho.cantate.HomeFragmentViewModel;
import com.stho.cantate.HomePagerAdapter;
import com.stho.cantate.MainNavigator;
import com.stho.cantate.MainViewModel;
import com.stho.cantate.R;
import com.stho.cantate.Sunday;
import com.stho.cantate.databinding.FragmentHomeBinding;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private static final String PARAMETER_POSITION = "POSITION";

    private HomeFragmentViewModel viewModel;
    private FragmentHomeBinding binding;
    private CantataListAdapter adapter;

    public HomeFragment() {
        // need public default constructor
    }

    /*
      The home fragment is bound to its position through the viewmodel and therefore bound to a fixed day.
      Scrolling through days is managed by the pager adapter, which creates new fragments for every day.
     */
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = createViewModel(getPositionParameter());
    }

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        adapter = new CantataListAdapter(new CantataListAdapter.ICantateItemListener() {
            @Override
            public void onClick(String bwv) {
                int position = viewModel.getPosition();
                viewModel.setCurrentPosition(position);
                MainNavigator.build(getActivity()).openCantate(bwv);
            }
        });
        binding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.fragment_home, container, false);
        binding.list.setAdapter(adapter);
        binding.list.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.list.setHasFixedSize(true);
        binding.cardViewCatholic.setOnClickListener(v -> {
            int position = viewModel.getPosition();
            viewModel.setCurrentPosition(position);
            MainNavigator.build(getActivity()).openCatholicDominica(position);
        });
        viewModel.getNextSundayLD().observe(this, this::setSunday);
        viewModel.getCantatasLD().observe(this, this::setCantatas);
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
        this.setArguments(HomeFragment.createBundle(position));
        return this;
    }

    private static Bundle createBundle(int position) {
        Bundle args = new Bundle();
        args.putInt(PARAMETER_POSITION, position);
        return args;
    }

    private int getPositionParameter() {
        Bundle args = getArguments();
        if (args != null) {
            return args.getInt(PARAMETER_POSITION, 0);
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
