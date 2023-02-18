package com.lttrung.giuaky.utils;

import com.lttrung.giuaky.entities.Room;
import com.lttrung.giuaky.entities.RoomType;

import java.util.ArrayList;
import java.util.List;

public class FakeData {

    public static List<RoomType> getRoomTypeList() {
        List<RoomType> list = new ArrayList<>();
        list.add(new RoomType("1", "Basic", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do", 6, 240000.0, "image", getRooms("Basic")));
        list.add(new RoomType("2", "Medium", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do", 4, 320000.0, "image", getRooms("Medium")));
        list.add(new RoomType("3", "High End", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do", 2, 400000.0, "image", getRooms("High End")));
        return list;
    }

    private static List<Room> getRooms(String roomType) {
        List<Room> rooms = new ArrayList<>();
        String id;
        String name;
        for (int i = 0; i < 10; i++) {
            id = String.valueOf(i);
            name = roomType + " " + id;
            rooms.add(new Room(id, name, i, "", 240000.0));
        }
        return rooms;
    }
}
