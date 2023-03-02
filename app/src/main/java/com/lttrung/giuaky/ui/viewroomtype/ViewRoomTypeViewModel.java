package com.lttrung.giuaky.ui.viewroomtype;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.lttrung.giuaky.entities.RoomType;
import com.lttrung.giuaky.utils.FakeData;

import java.util.List;

public class ViewRoomTypeViewModel extends ViewModel {
    protected final MutableLiveData<List<RoomType>> mRoomTypes;

    public ViewRoomTypeViewModel() {
        super();
        mRoomTypes = new MutableLiveData<List<RoomType>>();
    }

    protected void getRoomTypes() {
        mRoomTypes.postValue(FakeData.getRoomTypeList());
    }
}
