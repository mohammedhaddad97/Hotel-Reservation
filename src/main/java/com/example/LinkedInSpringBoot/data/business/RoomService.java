package com.example.LinkedInSpringBoot.data.business;

import com.example.LinkedInSpringBoot.data.entity.Room;
import com.example.LinkedInSpringBoot.data.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoomService {
    private final RoomRepository mRoomRepository;

    public RoomService(RoomRepository roomRepository) {
        mRoomRepository = roomRepository;
    }

    public List<Room> getRooms() {
        Iterable<Room> iterableRooms = mRoomRepository.findAll();

        List<Room> rooms = new ArrayList<>();

        iterableRooms.forEach(rooms::add);
        return rooms;
    }
}
