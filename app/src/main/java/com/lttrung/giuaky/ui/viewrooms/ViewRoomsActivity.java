package com.lttrung.giuaky.ui.viewrooms;

import static com.lttrung.giuaky.utils.Constant.ROOM;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.lttrung.giuaky.databinding.ActivityViewRoomsBinding;
import com.lttrung.giuaky.entities.RoomType;
import com.lttrung.giuaky.ui.registerroom.RegisterRoomActivity;
import com.lttrung.giuaky.ui.viewrooms.adapters.RoomAdapter;

import java.util.Objects;

public class ViewRoomsActivity extends AppCompatActivity {
    private ActivityViewRoomsBinding binding;
    private RoomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityViewRoomsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        RoomType roomType = (RoomType) getIntent().getSerializableExtra("ROOMS");

        Objects.requireNonNull(getSupportActionBar()).setTitle(roomType.getName());

        adapter = new RoomAdapter(room -> {
            Intent registerRoomIntent = new Intent(getBaseContext(), RegisterRoomActivity.class);
            registerRoomIntent.putExtra(ROOM, room);
            startActivity(registerRoomIntent);
        });
        binding.rcvRooms.setAdapter(adapter);
        adapter.submitList(roomType.getRooms());
    }
}