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
    @Override
    public void submitList(@Nullable List<Room> list) {
        super.submitList(list);
    }

    @Override
    public void submitList(@Nullable List<Room> list, @Nullable Runnable commitCallback) {
        super.submitList(list, commitCallback);
    }

    @Override
    protected Room getItem(int position) {
        return super.getItem(position);
    }

    @Override
    public int getItemCount() {
        return super.getItemCount();
    }

    @NonNull
    @Override
    public List<Room> getCurrentList() {
        return super.getCurrentList();
    }

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
