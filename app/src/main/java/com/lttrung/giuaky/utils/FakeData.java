package com.lttrung.giuaky.utils;

import com.lttrung.giuaky.entities.Room;
import com.lttrung.giuaky.entities.RoomType;

import java.util.ArrayList;
import java.util.List;

public class FakeData {
    private static String description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.";

    public static List<RoomType> getRoomTypeList() {
        List<RoomType> list = new ArrayList<>();
        list.add(new RoomType("1", "Basic", description, 6, 240000.0, "image", getRooms("Basic")));
        list.add(new RoomType("2", "Medium", description, 4, 320000.0, "image", getRooms("Medium")));
        list.add(new RoomType("3", "High End", description, 2, 400000.0, "image", getRooms("High End")));
        list.add(new RoomType("4", "Luxury", description, 1, 800000.0, "image", getRooms("Luxury")));
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
