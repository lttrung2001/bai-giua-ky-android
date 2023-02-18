package com.lttrung.giuaky.entities;

import androidx.annotation.Nullable;

import java.io.Serializable;
import java.util.List;

public class RoomType implements Serializable {
    private final String id;
    private final String name;
    private final String description;
    private final Integer numOfBeds;
    private final Double pricePerMonth;
    private final String image;
    private final List<Room> rooms;

    @Override
    public boolean equals(@Nullable Object obj) {
        return super.equals(obj);
    }

    public RoomType(String id, String name, String description, Integer numOfBeds, Double pricePerMonth, String image, List<Room> rooms) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.numOfBeds = numOfBeds;
        this.pricePerMonth = pricePerMonth;
        this.image = image;
        this.rooms = rooms;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Integer getNumOfBeds() {
        return numOfBeds;
    }

    public Double getPricePerMonth() {
        return pricePerMonth;
    }

    public String getImage() {
        return image;
    }

    public List<Room> getRooms() {
        return rooms;
    }
}
