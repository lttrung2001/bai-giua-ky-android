package com.lttrung.giuaky.ui.viewrooms.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import com.lttrung.giuaky.databinding.LayoutRoomBinding;
import com.lttrung.giuaky.entities.Room;

public class RoomAdapter extends ListAdapter<Room, RoomViewHolder> {
    private ItemListener itemListener;

    public RoomAdapter(ItemListener itemListener) {
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
        this.itemListener = itemListener;
    }

    @NonNull
    @Override
    public RoomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutRoomBinding viewBinding = LayoutRoomBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new RoomViewHolder(viewBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull RoomViewHolder holder, int position) {
        holder.bind(getItem(position), itemListener);
    }

    public interface ItemListener {
        void onClick(LayoutRoomBinding viewBinding, Room room);
    }
}
