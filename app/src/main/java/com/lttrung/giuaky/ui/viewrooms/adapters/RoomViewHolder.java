package com.lttrung.giuaky.ui.viewrooms.adapters;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lttrung.giuaky.R;
import com.lttrung.giuaky.databinding.LayoutRoomBinding;
import com.lttrung.giuaky.entities.Room;

import java.util.Locale;

public class RoomViewHolder extends RecyclerView.ViewHolder {
    private final LayoutRoomBinding binding;

    public RoomViewHolder(@NonNull LayoutRoomBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind(Room room) {
        binding.tvRoomName.setText(room.getName());
        binding.tvPrice.setText(String.format(Locale.US, "%.1f đ", room.getPrice()));
        binding.tvAvailableBeds.setText(String.format(Locale.US, "%d available beds", room.getAvailableBeds()));
        binding.imgRoom.setImageResource(R.drawable.img);
    }
}
