package com.lttrung.giuaky.ui.viewroomtype;

import static com.lttrung.giuaky.utils.Constant.ROOM_TYPE;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.slider.LabelFormatter;
import com.lttrung.giuaky.R;
import com.lttrung.giuaky.databinding.ActivityViewRoomTypeBinding;
import com.lttrung.giuaky.entities.RoomType;
import com.lttrung.giuaky.ui.viewrooms.ViewRoomsActivity;
import com.lttrung.giuaky.ui.viewroomtype.adapters.RoomTypeAdapter;
import com.lttrung.giuaky.utils.FakeData;

import java.text.NumberFormat;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class ViewRoomTypeActivity extends AppCompatActivity {
    private ActivityViewRoomTypeBinding binding;
    private RoomTypeAdapter adapter;

    private ViewRoomTypeViewModel viewRoomTypeViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewRoomTypeViewModel = new ViewModelProvider(this).get(ViewRoomTypeViewModel.class);
        viewRoomTypeViewModel.mRoomTypes.observe(this, roomTypes -> {
                    adapter.submitList(roomTypes);
                    Optional<RoomType> maxRoomType = roomTypes.stream().max(Comparator.comparingInt(RoomType::getNumOfBeds));
                    Optional<RoomType> minRoomType = roomTypes.stream().min(Comparator.comparingInt(RoomType::getNumOfBeds));
                    int min = minRoomType.isPresent() ? minRoomType.get().getNumOfBeds() : 0;
                    int max = maxRoomType.isPresent() ? maxRoomType.get().getNumOfBeds() : 100;
                    binding.range.setValueFrom(min);
                    binding.range.setValueTo(max);
                    binding.range.setValues((float) min, (float) max);
                    binding.range.setLabelFormatter((LabelFormatter) value -> (int) value + " beds");
                    binding.range.addOnChangeListener((slider, value, fromUser) -> {
                        List<RoomType> filteredTypes = FakeData.getRoomTypeList().stream().filter(roomType -> roomType.getNumOfBeds() >= slider.getValues().get(0) && roomType.getNumOfBeds() <= slider.getValues().get(1)).collect(Collectors.toList());
                        adapter.submitList(filteredTypes);
                        Log.i("INFO", slider.getValues().toString());
                    });
                }
        );

        binding = ActivityViewRoomTypeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Objects.requireNonNull(getSupportActionBar()).setTitle(getString(R.string.register));

        adapter = new RoomTypeAdapter(roomType -> {
            Intent intent = new Intent(this, ViewRoomsActivity.class);
            intent.putExtra(ROOM_TYPE, roomType);
            startActivity(intent);
        });
        binding.rcvRoomTypes.setAdapter(adapter);

        viewRoomTypeViewModel.getRoomTypes();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        finish();
        return true;
    }
}