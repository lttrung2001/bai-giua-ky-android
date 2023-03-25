package com.lttrung.giuaky;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.lttrung.giuaky.databinding.ActivityMainBinding;
import com.lttrung.giuaky.ui.home.HomeFragment;
import com.lttrung.giuaky.ui.roominfo.RoomInfoFragment;
import com.lttrung.giuaky.ui.user.UserFragment;
import com.lttrung.giuaky.utils.FragmentSupportFunctions;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initViews();
        initListeners();
    }

    private void initListeners() {
        binding.navView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.navigation_home: {
                    item.setChecked(true);
                    FragmentSupportFunctions.replaceFragment(this, new HomeFragment());
                    break;
                }
                case R.id.navigation_room_info: {
                    item.setChecked(true);
                    FragmentSupportFunctions.replaceFragment(this, new RoomInfoFragment());
                    break;
                }
                case R.id.navigation_user: {
                    item.setChecked(true);
                    FragmentSupportFunctions.replaceFragment(this, new UserFragment());
                    break;
                }
            }
            return false;
        });
    }

    private void initViews() {
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        FragmentSupportFunctions.replaceFragment(this, new HomeFragment());
    }
}