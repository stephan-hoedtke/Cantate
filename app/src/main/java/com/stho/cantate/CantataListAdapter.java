package com.stho.cantate;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.stho.cantate.databinding.CantataListItemBinding;
import com.stho.cantate.ui.HomeFragment;

import java.util.ArrayList;

/*
    See: classic: https://guides.codepath.com/android/using-the-recyclerview
    view binding: https://androidwave.com/android-data-binding-recyclerview/
 */
public class CantataListAdapter extends RecyclerView.Adapter<CantataListAdapter.ViewHolder> {
    private ArrayList<Cantate> cantatas = null;
    private final ICantateItemListener listener;

    public interface ICantateItemListener {
        void onClick(String bwv);
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private CantataListItemBinding binding;

        ViewHolder(CantataListItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    public CantataListAdapter(final ICantateItemListener listener) {
        // cannot set the list cantatas yet, as it is live data.
        this.listener = listener;
    }

    // Usually involves inflating a layout from XML and returning the holder
    @NonNull
    @Override
    public CantataListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CantataListItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.cantata_list_item, parent, false);
        return new ViewHolder(binding);
    }

    // Involves populating data into the item through holder
    @Override
    public void onBindViewHolder(CantataListAdapter.ViewHolder viewHolder, int position) {
        Cantate cantate = cantatas.get(position);
        viewHolder.binding.setCantate(cantate);
        viewHolder.binding.cardViewCantate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(cantate.getBWV());
            }
        });
    }

    @Override
    public int getItemCount() {
        return (cantatas == null) ? 0 : cantatas.size();
    }

    public void setCantatas(ArrayList<Cantate> cantatas) {
        this.cantatas = cantatas;
        notifyDataSetChanged();
    }
}
