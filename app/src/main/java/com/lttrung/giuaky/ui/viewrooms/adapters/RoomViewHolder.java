package com.lttrung.giuaky.ui.viewrooms.adapters;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lttrung.giuaky.R;
import com.lttrung.giuaky.entities.Room;

import java.util.Locale;

public class RoomViewHolder extends RecyclerView.ViewHolder {
    private final TextView name;
    private final TextView price;
    private final TextView availableBeds;
    private final ImageView image;

    public RoomViewHolder(@NonNull View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.tv_room_name);
        price = itemView.findViewById(R.id.tv_price);
        availableBeds = itemView.findViewById(R.id.tv_available_beds);
        image = itemView.findViewById(R.id.img_room);
    }

    public void bind(Room room) {
        name.setText(room.getName());
        price.setText(String.format(Locale.US, "%.1f đ", room.getPrice()));
        availableBeds.setText(String.format(Locale.US, "%d available beds", room.getAvailableBeds()));
        image.setImageResource(R.drawable.img);
    }
}
