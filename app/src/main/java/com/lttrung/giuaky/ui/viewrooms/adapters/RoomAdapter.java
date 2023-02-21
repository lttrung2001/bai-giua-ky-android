package com.lttrung.giuaky.ui.viewrooms.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import com.lttrung.giuaky.R;
import com.lttrung.giuaky.entities.Room;

import java.util.List;

public class RoomAdapter extends ListAdapter<Room, RoomViewHolder> {
    public RoomAdapter() {
        super(new DiffUtil.ItemCallback<Room>() {
            @Override
            public boolean areItemsTheSame(@NonNull Room oldItem, @NonNull Room newItem) {
                return oldItem.getId().equals(newItem.getId());
            }

            @Override
            public boolean areContentsTheSame(@NonNull Room oldItem, @NonNull Room newItem) {
                return oldItem.equals(newItem);
            }
        });
    }

    @NonNull
    @Override
    public RoomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_room, parent, false);
        return new RoomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RoomViewHolder holder, int position) {
        holder.bind(getItem(position));
    }
}
