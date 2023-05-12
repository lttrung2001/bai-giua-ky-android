package com.lttrung.giuaky.ui.viewroomtype.models;

import java.io.Serializable;
import java.util.List;

public class FilterAndSort implements Serializable {
    private final Integer min;
    private final Integer max;
    private final List<Integer> values;
    private final Integer sortPosition;

    public FilterAndSort(Integer min, Integer max, List<Integer> values, Integer sortPosition) {
        this.min = min;
        this.max = max;
        this.values = values;
        this.sortPosition = sortPosition;
    }

    public List<Integer> getValues() {
        return values;
    }

    public Integer getSortPosition() {
        return sortPosition;
    }

    public Integer getMin() {
        return min;
    }

    public Integer getMax() {
        return max;
    }
}
