package com.lttrung.giuaky.ui.viewrooms;

import static com.lttrung.giuaky.utils.Constant.ROOM;
import static com.lttrung.giuaky.utils.Constant.ROOM_TYPE;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.util.Pair;

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

        RoomType roomType = (RoomType) getIntent().getSerializableExtra(ROOM_TYPE);

        Objects.requireNonNull(getSupportActionBar()).setTitle(roomType.getName());

        adapter = new RoomAdapter((viewBinding, room) -> {
            Intent registerRoomIntent = new Intent(getBaseContext(), RegisterRoomActivity.class);
            registerRoomIntent.putExtra(ROOM, room);
            Pair<View, String> p1 = Pair.create(viewBinding.cardviewRoom, "transition_room_image");
            Pair<View, String> p2 = Pair.create(viewBinding.tvRoomName, "transition_room_name");
            Pair<View, String> p3 = Pair.create(viewBinding.tvAvailableBeds, "transition_room_available_beds");
            Pair<View, String> p4 = Pair.create(viewBinding.tvPrice, "transition_room_price");
            ActivityOptionsCompat options = ActivityOptionsCompat.
                    makeSceneTransitionAnimation(this, p1, p2, p3, p4);
            startActivity(registerRoomIntent, options.toBundle());
        });
        binding.rcvRooms.setAdapter(adapter);
        adapter.submitList(roomType.getRooms());
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        finish();
        return true;
    }
}