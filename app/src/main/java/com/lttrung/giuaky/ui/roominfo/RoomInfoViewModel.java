package com.lttrung.giuaky.ui.roominfo;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class RoomInfoViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public RoomInfoViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is room info fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}