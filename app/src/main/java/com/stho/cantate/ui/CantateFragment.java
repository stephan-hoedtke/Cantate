package com.stho.cantate.ui;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.stho.cantate.CantataListAdapter;
import com.stho.cantate.Cantate;
import com.stho.cantate.CantateFragmentViewModel;
import com.stho.cantate.CantateSqliteHelper;
import com.stho.cantate.MainNavigator;
import com.stho.cantate.MainViewModel;
import com.stho.cantate.R;
import com.stho.cantate.TrackListAdapter;
import com.stho.cantate.databinding.FragmentCantateBinding;

public class CantateFragment extends Fragment {

    private static final String PARAMETER_BWV = "BWV";
    private TrackListAdapter adapter;
    private CantateFragmentViewModel viewModel;
    private FragmentCantateBinding binding;

    public CantateFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = createViewModel(getParameterBWV());
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        adapter = new TrackListAdapter(new TrackListAdapter.ITrackItemListener() {
            @Override
            public void onClick(int no) {
                // TODO
                // ... open information about that track...
                // ... MainNavigator.build(getActivity()).openTrack(no);
            }
        });
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_cantate, container, false);
        binding.list.setAdapter(adapter);
        binding.list.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.list.setHasFixedSize(true);
        viewModel.getCantateLD().observe(this, this::setCantate);
        viewModel.getEvangelicSundayLD().observe(this, sunday -> binding.setSunday(sunday));
        return binding.getRoot();
    }

    @SuppressWarnings("ConstantConditions")
    private CantateFragmentViewModel createViewModel(String bwv) {
        MainViewModel mainViewModel = ViewModelProviders.of(getActivity()).get(MainViewModel.class);
        CantateFragmentViewModel cantateFragmentViewModel = ViewModelProviders.of(this).get(CantateFragmentViewModel.class);
        cantateFragmentViewModel.setMainViewModel(mainViewModel);
        Cantate cantate = mainViewModel.prepareCantate(new CantateSqliteHelper(getContext()), bwv);
        cantateFragmentViewModel.setCantate(cantate);
        return cantateFragmentViewModel;
    }

    public static Bundle createBundle(String bwv) {
        Bundle args = new Bundle();
        args.putString(PARAMETER_BWV, bwv);
        return args;
    }

    private static String getBWV(Bundle args) {
        final String defaultValue = "54";
        return (args != null) ? args.getString(PARAMETER_BWV, defaultValue) : defaultValue;
    }

    private String getParameterBWV() {
        return getBWV(getArguments());
    }

    private void setCantate(Cantate cantate) {
        binding.setCantate(cantate);
        adapter.setTracks(cantate.getTracks());
        updateActionBar(cantate);
    }

    private void updateActionBar(Cantate cantate) {
        ActionBar actionBar = ((AppCompatActivity)getActivity()).getSupportActionBar();
        actionBar.setSubtitle(cantate.getOriginalDate());
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);
    }
}
