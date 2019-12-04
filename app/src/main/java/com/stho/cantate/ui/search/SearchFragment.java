package com.stho.cantate.ui.search;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.stho.cantate.CantateSqliteAdapter;
import com.stho.cantate.CantateSqliteHelper;
import com.stho.cantate.MainNavigator;
import com.stho.cantate.R;
import com.stho.cantate.SearchTrackResult;
import com.stho.cantate.SearchTrackResultListAdapter;
import com.stho.cantate.databinding.FragmentSearchBinding;

import java.util.ArrayList;

public class SearchFragment extends Fragment {

    private SearchTrackResultListAdapter adapter;
    private SearchViewModel viewModel;
    private FragmentSearchBinding binding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = ViewModelProviders.of(getActivity()).get(SearchViewModel.class);
    }

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        adapter = new SearchTrackResultListAdapter(new SearchTrackResultListAdapter.ISearchTrackResultItemListener() {
            @Override
            public void onClick(String bwv, int no) {
                MainNavigator.build(getActivity()).openCantate(bwv);
            }
        });
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_search, container, false);
        binding.list.setAdapter(adapter);
        binding.list.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.list.setHasFixedSize(true);
        viewModel.getLyricsFilterLD().observe(this, filter -> binding.setViewModel(viewModel));
        viewModel.getVoicesFilterLD().observe(this, filter -> binding.setViewModel(viewModel));
        viewModel.getInstrumentationFilterLD().observe(this, filter -> binding.setViewModel(viewModel));
        viewModel.getBwvFilterLD().observe(this, filter -> binding.setViewModel(viewModel));
        viewModel.getSearchTrackResultLD().observe(this, list -> adapter.setTracks(list));
        binding.buttonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onSearch();
            }
        });
        updateActionBar();
        return binding.getRoot();
    }

    private void onSearch() {
        viewModel.setLyricsFilter(binding.editLyricsFilter.getText().toString());
        viewModel.setVoicesFilter(binding.editVoicesFilter.getText().toString());
        viewModel.setInstrumentationFilter(binding.editInstrumentationFilter.getText().toString());
        viewModel.setBwvFilter(binding.editBwvFilter.getText().toString());
        viewModel.setLyricsFilter(binding.editLyricsFilter.getText().toString());
        viewModel.setSearchTrackResult(
                search(
                    viewModel.getLyricsFilter(),
                    viewModel.getVoicesFilter(),
                    viewModel.getInstrumentationFilter(),
                    viewModel.getBwvFilter()));
    }

    private ArrayList<SearchTrackResult> search(String lyricsFilter, String voicesFilter, String instrumentationFilter, String bwvFilter) {
        CantateSqliteHelper hlp = new CantateSqliteHelper(getContext());
        try {
            SQLiteDatabase db = hlp.getReadableDatabase();
            CantateSqliteAdapter adapter = new CantateSqliteAdapter(db);
            return adapter.searchTracks(lyricsFilter, voicesFilter, instrumentationFilter, bwvFilter);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException("Cannot read tracks or remarks from database", ex);
        }
    }

    private void updateActionBar() {
        ActionBar actionBar = ((AppCompatActivity)getActivity()).getSupportActionBar();
        actionBar.setSubtitle("");
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);
    }
}

