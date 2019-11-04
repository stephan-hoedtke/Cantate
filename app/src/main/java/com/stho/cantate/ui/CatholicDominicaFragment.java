package com.stho.cantate.ui;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.stho.cantate.CatholicDominicaFragmentViewModel;
import com.stho.cantate.HomeFragmentViewModel;
import com.stho.cantate.MainViewModel;
import com.stho.cantate.R;
import com.stho.cantate.Sunday;
import com.stho.cantate.databinding.FragmentCatholicDominicaBinding;


/**
 * A simple {@link Fragment} subclass.
 */
public class CatholicDominicaFragment extends Fragment {

    private static final String POSITION_PARAMETER = "POSITION";

    private CatholicDominicaFragmentViewModel viewModel;
    private FragmentCatholicDominicaBinding binding;

    public CatholicDominicaFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = createViewModel(1);
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

    private CatholicDominicaFragment setPositionParameter(int position) {
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
            binding.setDominica(sunday.getCatholicDominica());
        }
    }
}
