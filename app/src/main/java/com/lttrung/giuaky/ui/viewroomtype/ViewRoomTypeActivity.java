package com.lttrung.giuaky.ui.viewroomtype;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.lttrung.giuaky.databinding.ActivityViewRoomTypeBinding;
import com.lttrung.giuaky.entities.RoomType;
import com.lttrung.giuaky.ui.viewrooms.ViewRoomsActivity;
import com.lttrung.giuaky.ui.viewroomtype.adapters.RoomTypeAdapter;
import com.lttrung.giuaky.utils.FakeData;

public class ViewRoomTypeActivity extends AppCompatActivity {
    private ActivityViewRoomTypeBinding binding;
    private RoomTypeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityViewRoomTypeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        adapter = new RoomTypeAdapter(roomType -> {
            Intent intent = new Intent(this, ViewRoomsActivity.class);
            intent.putExtra("ROOMS", roomType);
            startActivity(intent);
        });
        adapter.submitList(FakeData.getRoomTypeList());

        binding.rcvRoomTypes.setAdapter(adapter);
    }
}