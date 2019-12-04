package com.stho.cantate;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.stho.cantate.databinding.CantataListItemBinding;
import com.stho.cantate.databinding.TrackListItemBinding;

import java.util.ArrayList;

/*
    See: classic: https://guides.codepath.com/android/using-the-recyclerview
    view binding: https://androidwave.com/android-data-binding-recyclerview/
 */
public class TrackListAdapter extends RecyclerView.Adapter<TrackListAdapter.ViewHolder> {
    private ArrayList<Track> tracks = null;
    private final ITrackItemListener listener;

    public interface ITrackItemListener {
        void onClick(int no);
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TrackListItemBinding binding;

        ViewHolder(TrackListItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    public TrackListAdapter(final ITrackItemListener listener) {
        this.listener = listener;
    }

    // Usually involves inflating a layout from XML and returning the holder
    @NonNull
    @Override
    public TrackListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        TrackListItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.track_list_item, parent, false);
        return new ViewHolder(binding);
    }

    // Involves populating data into the item through holder
    @Override
    public void onBindViewHolder(TrackListAdapter.ViewHolder viewHolder, int position) {
        Track track = tracks.get(position);
        viewHolder.binding.setTrack(track);
        viewHolder.binding.cardViewTrack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(track.getNo());
            }
        });
    }

    @Override
    public int getItemCount() {
        return (tracks == null) ? 0 : tracks.size();
    }

    public void setTracks(ArrayList<Track> tracks) {
        this.tracks = tracks;
        notifyDataSetChanged();
    }
}
