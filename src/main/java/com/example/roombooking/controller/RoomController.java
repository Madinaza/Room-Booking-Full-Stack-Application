package com.example.roombooking.controller;

import com.example.roombooking.dto.RoomDto;
import com.example.roombooking.entity.Room;
import com.example.roombooking.service.RoomService;
import com.example.roombooking.util.EntityDtoMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/rooms")
public class RoomController {
    private final RoomService roomService;
    private final EntityDtoMapper mapper;

    public RoomController(RoomService roomService, EntityDtoMapper mapper) {
        this.roomService = roomService;
        this.mapper      = mapper;
    }

    @GetMapping
    public ResponseEntity<List<RoomDto>> list() {
        List<RoomDto> dtos = roomService.list().stream()
                .map(mapper::roomToDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }

    @PostMapping
    public ResponseEntity<RoomDto> create(@RequestBody RoomDto dto) {
        Room saved = roomService.create(mapper.dtoToRoom(dto));
        return ResponseEntity.ok(mapper.roomToDto(saved));
    }
}
