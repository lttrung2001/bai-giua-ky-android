package com.lttrung.giuaky.ui.viewroomtype;

import static com.lttrung.giuaky.utils.Constant.ROOM_TYPE;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.lttrung.giuaky.R;
import com.lttrung.giuaky.databinding.ActivityViewRoomTypeBinding;
import com.lttrung.giuaky.entities.RoomType;
import com.lttrung.giuaky.ui.viewrooms.ViewRoomsActivity;
import com.lttrung.giuaky.ui.viewroomtype.adapters.RoomTypeAdapter;
import com.lttrung.giuaky.ui.viewroomtype.models.FilterAndSort;
import com.lttrung.giuaky.utils.FakeData;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class ViewRoomTypeActivity extends AppCompatActivity {
    private ActivityViewRoomTypeBinding binding;
    private RoomTypeAdapter adapter;

    private ViewRoomTypeViewModel viewRoomTypeViewModel;

    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewRoomTypeViewModel = new ViewModelProvider(this).get(ViewRoomTypeViewModel.class);

        viewRoomTypeViewModel.mRoomTypes.observe(this, roomTypes -> {
            Optional<RoomType> maxRoomType = roomTypes.stream().max(Comparator.comparingInt(RoomType::getNumOfBeds));
            Optional<RoomType> minRoomType = roomTypes.stream().min(Comparator.comparingInt(RoomType::getNumOfBeds));
            int min = minRoomType.isPresent() ? minRoomType.get().getNumOfBeds() : 0;
            int max = maxRoomType.isPresent() ? maxRoomType.get().getNumOfBeds() : 100;

            viewRoomTypeViewModel.applyFilterAndSort(new FilterAndSort(min, max, List.of(min, max), 0));
        });

        viewRoomTypeViewModel.mFilterAndSort.observe(this, filterAndSort -> {
            int min = filterAndSort.getValues().get(0);
            int max = filterAndSort.getValues().get(1);
            List<RoomType> filteredTypes = FakeData.getRoomTypeList()
                    .stream()
                    .filter(roomType -> roomType.getNumOfBeds() >= min && roomType.getNumOfBeds() <= max)
                    .collect(Collectors.toList());
            switch (filterAndSort.getSortPosition()) {
                case R.id.button1: // Sort by beds asc
                    filteredTypes.sort(Comparator.comparingInt(RoomType::getNumOfBeds));
                    break;
                case R.id.button2: // Sort by beds desc
                    filteredTypes.sort(Comparator.comparingInt(RoomType::getNumOfBeds).reversed());
                    break;
                case R.id.button3: // Sort by name asc
                    filteredTypes.sort(Comparator.comparing(RoomType::getName));
                    break;
                case R.id.button4: // Sort by name desc
                    filteredTypes.sort(Comparator.comparing(RoomType::getName).reversed());
                    break;
                default:
                    break;
            }
            adapter.submitList(filteredTypes);
        });

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

        binding.buttonShowFilter.setOnClickListener(v -> {
            FilterAndSortFragment fragment = new FilterAndSortFragment();
            fragment.show(getSupportFragmentManager(), FilterAndSortFragment.TAG);
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        finish();
        return true;
    }
}