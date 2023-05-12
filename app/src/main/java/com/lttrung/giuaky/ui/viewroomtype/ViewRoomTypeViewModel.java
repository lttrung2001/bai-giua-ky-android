package com.lttrung.giuaky.ui.viewroomtype;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.lttrung.giuaky.entities.RoomType;
import com.lttrung.giuaky.ui.viewroomtype.models.FilterAndSort;
import com.lttrung.giuaky.utils.FakeData;

import java.util.List;

public class ViewRoomTypeViewModel extends ViewModel {
    protected final MutableLiveData<List<RoomType>> mRoomTypes = new MutableLiveData<>();
    protected final MutableLiveData<FilterAndSort> mFilterAndSort = new MutableLiveData<>();

    protected void getRoomTypes() {
        mRoomTypes.postValue(FakeData.getRoomTypeList());
    }

    protected void applyFilterAndSort(FilterAndSort filterAndSort) {
        mFilterAndSort.postValue(filterAndSort);
    }
}
