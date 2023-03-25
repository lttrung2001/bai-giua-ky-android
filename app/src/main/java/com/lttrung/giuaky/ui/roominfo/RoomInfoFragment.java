package com.lttrung.giuaky.ui.roominfo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.lttrung.giuaky.databinding.FragmentRoomInfoBinding;


public class RoomInfoFragment extends Fragment {

    private FragmentRoomInfoBinding binding;
    private RoomInfoViewModel roomInfoViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        roomInfoViewModel = new ViewModelProvider(this).get(RoomInfoViewModel.class);

        binding = FragmentRoomInfoBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textDashboard;
        roomInfoViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}