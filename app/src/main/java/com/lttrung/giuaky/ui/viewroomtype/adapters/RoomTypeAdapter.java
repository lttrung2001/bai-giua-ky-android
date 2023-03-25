package com.lttrung.giuaky.ui.viewroomtype.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import com.lttrung.giuaky.R;
import com.lttrung.giuaky.databinding.LayoutRoomTypeBinding;
import com.lttrung.giuaky.entities.RoomType;

import java.util.List;

public class RoomTypeAdapter extends ListAdapter<RoomType, RoomTypeViewHolder> {
    private final OnClickListener listener;

    public RoomTypeAdapter(OnClickListener listener) {
        super(ITEM_CALLBACK);
        this.listener = listener;
    }

    @NonNull
    @Override
    public RoomTypeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutRoomTypeBinding binding = LayoutRoomTypeBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new RoomTypeViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RoomTypeViewHolder holder, int position) {
        holder.bind(getItem(position));
        holder.itemView.setOnClickListener(v -> listener.onClick(getItem(position)));
    }

    public interface OnClickListener {
        void onClick(RoomType roomType);
    }

    private static final DiffUtil.ItemCallback<RoomType> ITEM_CALLBACK = new DiffUtil.ItemCallback<RoomType>() {
        @Override
        public boolean areItemsTheSame(@NonNull RoomType oldItem, @NonNull RoomType newItem) {
            return oldItem.getId().equals(newItem.getId());
        }

        @Override
        public boolean areContentsTheSame(@NonNull RoomType oldItem, @NonNull RoomType newItem) {
            return oldItem.equals(newItem);
        }
    };
}
