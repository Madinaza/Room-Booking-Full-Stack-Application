package com.example.roombooking.util;

import com.example.roombooking.dto.BookingDto;
import com.example.roombooking.dto.RoomDto;
import com.example.roombooking.dto.UserDto;
import com.example.roombooking.entity.Booking;
import com.example.roombooking.entity.Room;
import com.example.roombooking.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface EntityDtoMapper {
    UserDto userToDto(User u);
    User dtoToUser(UserDto d);

    RoomDto roomToDto(Room r);
    Room dtoToRoom(RoomDto d);

    BookingDto bookingToDto(Booking b);

    @Mapping(target="id", ignore=true)
    Booking dtoToBooking(BookingDto d);
}
