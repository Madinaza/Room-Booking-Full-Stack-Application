package com.example.roombooking.controller;

import com.example.roombooking.dto.BookingDto;
import com.example.roombooking.entity.Booking;
import com.example.roombooking.service.BookingService;
import com.example.roombooking.util.EntityDtoMapper;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {
    private final BookingService service;
    private final SimpMessagingTemplate ws;
    private final EntityDtoMapper mapper;

    public BookingController(BookingService service,
                             SimpMessagingTemplate ws,
                             EntityDtoMapper mapper) {
        this.service = service;
        this.ws      = ws;
        this.mapper  = mapper;
    }

    @PostMapping
    public BookingDto book(@RequestBody BookingDto dto) {
        // DTO → Entity
        Booking toSave = mapper.dtoToBooking(dto);
        // Save
        Booking saved = service.book(toSave);
        // Entity → DTO
        BookingDto out = mapper.bookingToDto(saved);
        ws.convertAndSend("/topic/bookings", out);
        return out;
    }

    @GetMapping
    public List<BookingDto> list() {
        return service.listAll()
                .stream()
                .map(mapper::bookingToDto)
                .collect(Collectors.toList());
    }
}
