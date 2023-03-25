package com.lttrung.giuaky.ui.viewroomtype.adapters;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lttrung.giuaky.R;
import com.lttrung.giuaky.databinding.LayoutRoomTypeBinding;
import com.lttrung.giuaky.entities.RoomType;

import java.util.Locale;

public class RoomTypeViewHolder extends RecyclerView.ViewHolder {
    private final LayoutRoomTypeBinding binding;

    public RoomTypeViewHolder(@NonNull LayoutRoomTypeBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind(RoomType roomType) {
        binding.imgRoomType.setImageResource(R.drawable.ic_home_black_24dp);
        binding.tvRoomType.setText(roomType.getName());
        binding.tvRoomTypeDescription.setText(roomType.getDescription());
        binding.tvNumBeds.setText(String.format(Locale.US, "%d beds", roomType.getNumOfBeds()));
        binding.tvPricePerMonth.setText(String.format(Locale.US, "%.1f đ / month", roomType.getPricePerMonth()));
    }
}
