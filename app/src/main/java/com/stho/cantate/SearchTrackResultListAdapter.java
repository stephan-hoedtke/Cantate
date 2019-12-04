package com.stho.cantate;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.stho.cantate.databinding.SearchTrackResultListItemBinding;
import com.stho.cantate.databinding.TrackListItemBinding;

import java.util.ArrayList;

/*
    See: classic: https://guides.codepath.com/android/using-the-recyclerview
    view binding: https://androidwave.com/android-data-binding-recyclerview/
 */
public class SearchTrackResultListAdapter extends RecyclerView.Adapter<SearchTrackResultListAdapter.ViewHolder> {
    private ArrayList<SearchTrackResult> tracks = null;
    private final ISearchTrackResultItemListener listener;

    public interface ISearchTrackResultItemListener {
        void onClick(String bwv, int no);
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private SearchTrackResultListItemBinding binding;

        ViewHolder(SearchTrackResultListItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    public SearchTrackResultListAdapter(final ISearchTrackResultItemListener listener) {
        this.listener = listener;
    }

    // Usually involves inflating a layout from XML and returning the holder
    @NonNull
    @Override
    public SearchTrackResultListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        SearchTrackResultListItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.search_track_result_list_item, parent, false);
        return new ViewHolder(binding);
    }

    // Involves populating data into the item through holder
    @Override
    public void onBindViewHolder(SearchTrackResultListAdapter.ViewHolder viewHolder, int position) {
        SearchTrackResult track = tracks.get(position);
        viewHolder.binding.setTrack(track);
        viewHolder.binding.cardViewTrack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(track.bwv, track.trackNo);
            }
        });
    }

    @Override
    public int getItemCount() {
        return (tracks == null) ? 0 : tracks.size();
    }

    public void setTracks(ArrayList<SearchTrackResult> tracks) {
        this.tracks = tracks;
        notifyDataSetChanged();
    }
}
