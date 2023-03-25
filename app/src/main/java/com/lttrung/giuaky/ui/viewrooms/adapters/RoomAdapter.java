package com.lttrung.giuaky.ui.viewrooms.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import com.lttrung.giuaky.databinding.LayoutRoomBinding;
import com.lttrung.giuaky.entities.Room;

public class RoomAdapter extends ListAdapter<Room, RoomViewHolder> {
    private final static DiffUtil.ItemCallback<Room> ITEM_CALLBACK = new DiffUtil.ItemCallback<Room>() {
        @Override
        public boolean areItemsTheSame(@NonNull Room oldItem, @NonNull Room newItem) {
            return oldItem.getId().equals(newItem.getId());
        }

        @Override
        public boolean areContentsTheSame(@NonNull Room oldItem, @NonNull Room newItem) {
            return oldItem.equals(newItem);
        }
    };

    public RoomAdapter() {
        super(ITEM_CALLBACK);
    }

    @NonNull
    @Override
    public RoomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutRoomBinding binding = LayoutRoomBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new RoomViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RoomViewHolder holder, int position) {
        holder.bind(getItem(position));
    }
}
