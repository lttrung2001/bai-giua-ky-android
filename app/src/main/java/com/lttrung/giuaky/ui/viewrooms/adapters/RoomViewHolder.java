package com.lttrung.giuaky.ui.viewrooms.adapters;

import androidx.recyclerview.widget.RecyclerView;

import com.lttrung.giuaky.R;
import com.lttrung.giuaky.databinding.LayoutRoomBinding;
import com.lttrung.giuaky.entities.Room;

import java.util.Locale;

public class RoomViewHolder extends RecyclerView.ViewHolder {
    private LayoutRoomBinding binding;

    public RoomViewHolder(LayoutRoomBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind(Room room, RoomAdapter.ItemListener itemListener) {
        binding.tvRoomName.setText(room.getName());
        binding.tvPrice.setText(String.format(Locale.US, "%.1f đ", room.getPrice()));
        binding.tvAvailableBeds.setText(String.format(Locale.US, "%d available beds", room.getAvailableBeds()));
        binding.imgRoom.setImageResource(R.drawable.img);

        binding.getRoot().setOnClickListener(v -> {
            itemListener.onClick(binding, room);
        });
    }
}
