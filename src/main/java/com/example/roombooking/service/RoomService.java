package com.example.roombooking.service;

import com.example.roombooking.entity.Room;
import com.example.roombooking.exception.ResourceNotFoundException;
import com.example.roombooking.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {
    private final RoomRepository repo;

    public RoomService(RoomRepository repo) {
        this.repo = repo;
    }

    public Room create(Room room) {
        return repo.save(room);
    }

    public List<Room> list() {
        return repo.findAll();
    }

    public Room get(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Room not found"));
    }
}
