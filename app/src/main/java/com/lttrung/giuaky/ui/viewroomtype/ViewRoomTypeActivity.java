package com.lttrung.giuaky.ui.viewroomtype;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.lttrung.giuaky.R;
import com.lttrung.giuaky.databinding.ActivityViewRoomTypeBinding;
import com.lttrung.giuaky.entities.RoomType;
import com.lttrung.giuaky.ui.viewrooms.ViewRoomsActivity;
import com.lttrung.giuaky.ui.viewroomtype.adapters.RoomTypeAdapter;
import com.lttrung.giuaky.utils.FakeData;

import java.util.List;
import java.util.Objects;

public class ViewRoomTypeActivity extends AppCompatActivity {
    private ActivityViewRoomTypeBinding binding;
    private RoomTypeAdapter adapter;

    private ViewRoomTypeViewModel viewRoomTypeViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewRoomTypeViewModel = new ViewModelProvider(this).get(ViewRoomTypeViewModel.class);
        viewRoomTypeViewModel.mRoomTypes.observe(this, roomTypes -> adapter.submitList(roomTypes));

        binding = ActivityViewRoomTypeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Objects.requireNonNull(getSupportActionBar()).setTitle(getString(R.string.register));

        adapter = new RoomTypeAdapter(roomType -> {
            Intent intent = new Intent(this, ViewRoomsActivity.class);
            intent.putExtra("ROOMS", roomType);
            startActivity(intent);
        });
        binding.rcvRoomTypes.setAdapter(adapter);

        viewRoomTypeViewModel.getRoomTypes();
    }
}