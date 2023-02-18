package com.lttrung.giuaky.ui.viewroomtype.adapters;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lttrung.giuaky.R;
import com.lttrung.giuaky.entities.RoomType;

import java.util.Locale;

public class RoomTypeViewHolder extends RecyclerView.ViewHolder {
    private TextView id = itemView.findViewById(R.id.tv_room_type_id);
    private ImageView image = itemView.findViewById(R.id.img_room_type);
    private TextView name = itemView.findViewById(R.id.tv_room_type);
    private TextView description = itemView.findViewById(R.id.tv_room_type_description);
    private TextView numOfBeds = itemView.findViewById(R.id.tv_num_beds);
    private TextView pricePerMonth = itemView.findViewById(R.id.tv_price_per_month);

    public RoomTypeViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    public void bind(RoomType roomType) {
        id.setText(roomType.getId());
        image.setImageResource(R.drawable.ic_home_black_24dp);
        name.setText(roomType.getName());
        description.setText(roomType.getDescription());
        numOfBeds.setText(String.format(Locale.US, "%d beds", roomType.getNumOfBeds()));
        pricePerMonth.setText(String.format(Locale.US, "%.1f đ / month", roomType.getPricePerMonth()));
    }

    public TextView getId() {
        return id;
    }

    public void setId(TextView id) {
        this.id = id;
    }
}
