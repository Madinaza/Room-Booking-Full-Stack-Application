package com.example.roombooking.repository;
import com.example.roombooking.entity.Booking;
import com.example.roombooking.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDateTime;
import java.util.List;
public interface BookingRepository extends JpaRepository<Booking,Long> {
    List<Booking> findByRoomAndEndTimeAfterAndStartTimeBefore(
            Room room, LocalDateTime start, LocalDateTime end);
}
