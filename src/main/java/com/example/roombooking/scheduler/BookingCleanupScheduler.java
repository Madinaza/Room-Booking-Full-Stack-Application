package com.example.roombooking.scheduler;

import com.example.roombooking.repository.BookingRepository;
import org.springframework.scheduling.annotation.*;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;
import java.util.stream.Collectors;

@Component
@EnableScheduling
public class BookingCleanupScheduler {
    private final BookingRepository repo;
    public BookingCleanupScheduler(BookingRepository r){this.repo=r;}

    @Scheduled(cron="0 0 0 * * *")
    public void cleanupPastBookings() {
        var old = repo.findAll().stream()
                .filter(b -> b.getEndTime().isBefore(LocalDateTime.now()))
                .collect(Collectors.toList());
        repo.deleteAll(old);
    }
}
