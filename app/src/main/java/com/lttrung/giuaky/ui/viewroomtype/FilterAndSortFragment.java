package com.lttrung.giuaky.ui.viewroomtype;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.lttrung.giuaky.databinding.FragmentFilterAndSortBinding;
import com.lttrung.giuaky.ui.viewroomtype.models.FilterAndSort;

import java.util.List;

public class FilterAndSortFragment extends BottomSheetDialogFragment {
    private FragmentFilterAndSortBinding binding;
    private ViewRoomTypeViewModel viewRoomTypeViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentFilterAndSortBinding.inflate(getLayoutInflater());
        // Inflate the layout for this fragment
        viewRoomTypeViewModel = new ViewModelProvider(requireActivity()).get(ViewRoomTypeViewModel.class);

        viewRoomTypeViewModel.mFilterAndSort.observe(this, filterAndSort -> {
            List<Integer> values = filterAndSort.getValues();
            binding.range.setLabelFormatter(value -> (int) value + " beds");
            binding.range.setValueFrom(filterAndSort.getMin());
            binding.range.setValueTo(filterAndSort.getMax());
            binding.range.setValues((float) values.get(0), (float) values.get(1));
            binding.rbSortBy.check(filterAndSort.getSortPosition());
        });

        binding.buttonApply.setOnClickListener(v -> {
            List<Float> values = binding.range.getValues();
            FilterAndSort filterAndSort = new FilterAndSort(
                    (int) binding.range.getValueFrom(),
                    (int) binding.range.getValueTo(),
                    List.of(values.get(0).intValue(), values.get(1).intValue()),
                    binding.rbSortBy.getCheckedRadioButtonId()
            );
            viewRoomTypeViewModel.applyFilterAndSort(filterAndSort);
            dismiss();
        });

        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        viewRoomTypeViewModel = null;
    }

    public static final String TAG = "com.lttrung.giuaky.FilterAndSortFragment";
}