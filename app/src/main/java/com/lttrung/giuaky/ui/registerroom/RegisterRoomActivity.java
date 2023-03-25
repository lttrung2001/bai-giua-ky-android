package com.lttrung.giuaky.ui.registerroom;

import static com.lttrung.giuaky.utils.Constant.ROOM;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;
import com.lttrung.giuaky.R;
import com.lttrung.giuaky.databinding.ActivityRegisterRoomBinding;
import com.lttrung.giuaky.entities.Room;

public class RegisterRoomActivity extends AppCompatActivity {
    private ActivityRegisterRoomBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterRoomBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initData();
        initListeners();
    }

    private void initListeners() {
        binding.registerRoomButton.setOnClickListener(view -> {
            Snackbar.make(view, "Register clicked", Snackbar.LENGTH_INDEFINITE).show();
        });
    }

    private void initData() {
        Room room = (Room) getIntent().getSerializableExtra(ROOM);
        binding.roomImg.setImageResource(R.drawable.img);
        binding.roomName.setText(room.getName());
        binding.roomBeds.setText(room.getAvailableBeds() + " beds");
        binding.roomPrice.setText(room.getPrice() + " đ/m");
        binding.roomAvailableBeds.setText(room.getAvailableBeds() + " available beds");
    }
}