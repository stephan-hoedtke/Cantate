package com.stho.cantate.ui;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.stho.cantate.CatholicDominicaFragmentViewModel;
import com.stho.cantate.MainViewModel;
import com.stho.cantate.R;
import com.stho.cantate.Sunday;
import com.stho.cantate.databinding.FragmentCatholicDominicaBinding;


/**
 * A simple {@link Fragment} subclass.
 */
public class CatholicDominicaFragment extends Fragment {

    private static final String PARAMETER_POSITION = "POSITION";

    private CatholicDominicaFragmentViewModel viewModel;
    private FragmentCatholicDominicaBinding binding;

    public CatholicDominicaFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = createViewModel(getPositionParameter());
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_catholic_dominica, container, false);
        viewModel.getNextSundayLD().observe(this, this::setSunday);
        return binding.getRoot();
    }

    @SuppressWarnings("ConstantConditions")
    private CatholicDominicaFragmentViewModel createViewModel(int position) {
        MainViewModel mainViewModel = ViewModelProviders.of(getActivity()).get(MainViewModel.class);
        CatholicDominicaFragmentViewModel catholicDominicaFragmentViewModel = ViewModelProviders.of(this).get(CatholicDominicaFragmentViewModel.class);
        catholicDominicaFragmentViewModel.setMainViewModel(mainViewModel);
        catholicDominicaFragmentViewModel.setPosition(position);
        return catholicDominicaFragmentViewModel;
    }

    public static CatholicDominicaFragment newInstance(int position) {
        return new CatholicDominicaFragment().setPositionParameter(position);
    }

    public static Bundle createBundle(int position) {
        Bundle args = new Bundle();
        args.putInt(PARAMETER_POSITION, position);
        return args;
    }

    private static int getPosition(Bundle args) {
        return (args != null) ? args.getInt(PARAMETER_POSITION, 0) : 0;
    }

    private CatholicDominicaFragment setPositionParameter(int position) {
        this.setArguments(createBundle(position));
        return this;
    }

    private int getPositionParameter() {
        return getPosition(getArguments());
    }

    private void setSunday(Sunday sunday) {
        binding.setOccasion(sunday);
        binding.setDominica(sunday.getCatholicDominica());
        updateActionBar(sunday);
    }

    private void updateActionBar(Sunday sunday) {
        ActionBar actionBar = ((AppCompatActivity)getActivity()).getSupportActionBar();
        actionBar.setSubtitle(sunday != null ? sunday.getDateAsString() : "");
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);
    }
}
