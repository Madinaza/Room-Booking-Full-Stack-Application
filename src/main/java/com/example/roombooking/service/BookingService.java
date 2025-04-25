package com.example.roombooking.service;

import com.example.roombooking.entity.*;
import com.example.roombooking.exception.BookingConflictException;
import com.example.roombooking.repository.BookingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class BookingService {
    private final BookingRepository repo;
    private final RoomService roomService;
    private final UserService userService;

    public BookingService(BookingRepository r, RoomService rs, UserService us){
        this.repo=r; this.roomService=rs; this.userService=us;
    }

    @Transactional
    public Booking book(Booking b){
        Room room = roomService.get(b.getRoom().getId());
        List<Booking> conflicts = repo.findByRoomAndEndTimeAfterAndStartTimeBefore(
                room,b.getStartTime(),b.getEndTime());
        if(!conflicts.isEmpty())
            throw new BookingConflictException("Time slot already booked");
        b.setRoom(room);
        b.setUser(userService.findByUsername(b.getUser().getUsername()));
        return repo.save(b);
    }

    public List<Booking> listAll(){return repo.findAll();}
}
