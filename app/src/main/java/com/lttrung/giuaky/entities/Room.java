package com.lttrung.giuaky.entities;

import androidx.annotation.Nullable;

import java.io.Serializable;

public class Room implements Serializable {
    private final String id;
    private final String name;
    private final Integer availableBeds;
    private final String image;
    private final Double price;

    public Room(String id, String name, Integer availableBeds, String image, Double price) {
        this.id = id;
        this.name = name;
        this.availableBeds = availableBeds;
        this.image = image;
        this.price = price;
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        return super.equals(obj);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAvailableBeds() {
        return availableBeds;
    }

    public String getImage() {
        return image;
    }

    public Double getPrice() {
        return price;
    }
}
