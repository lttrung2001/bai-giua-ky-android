package com.lttrung.giuaky.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.lttrung.giuaky.R;
import com.lttrung.giuaky.databinding.FragmentHomeBinding;
import com.lttrung.giuaky.ui.test.TestFragment;
import com.lttrung.giuaky.ui.viewroomtype.ViewRoomTypeActivity;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.registerButton.setOnClickListener(v -> startActivity(new Intent(getContext(), ViewRoomTypeActivity.class)));
        binding.btnTest.setOnClickListener(v -> {
            TestFragment testFragment = new TestFragment();
            FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.nav_host_fragment_activity_main, testFragment);
            fragmentTransaction.addToBackStack(testFragment.getClass().getName());
            fragmentTransaction.commit();
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}