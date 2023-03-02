package com.lttrung.giuaky.ui.viewrooms;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.lttrung.giuaky.databinding.ActivityViewRoomsBinding;
import com.lttrung.giuaky.entities.RoomType;
import com.lttrung.giuaky.ui.viewrooms.adapters.RoomAdapter;
import com.lttrung.giuaky.utils.FakeData;

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

        adapter = new RoomAdapter();
        binding.rcvRooms.setAdapter(adapter);
        adapter.submitList(roomType.getRooms());
    }
}