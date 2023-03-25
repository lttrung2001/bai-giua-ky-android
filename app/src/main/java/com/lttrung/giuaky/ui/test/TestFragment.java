package com.lttrung.giuaky.ui.test;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lttrung.giuaky.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TestFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TestFragment extends Fragment {
    public TestFragment() {
        // Required empty public constructor
    }
    public static TestFragment newInstance() {
        return new TestFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_test, container, false);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i("INFO", "onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("INFO", "onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i("INFO", "onDetach");
    }
}