package com.example.roombooking.dto;

import java.time.LocalDateTime;

public class BookingDto {
    private Long id, userId, roomId;
    private LocalDateTime startTime, endTime;
    public BookingDto() {}
    public BookingDto(Long i,Long u,Long r,LocalDateTime s,LocalDateTime e){
        id=i;userId=u;roomId=r;startTime=s;endTime=e;
    }
    public Long getId(){return id;} public void setId(Long i){id=i;}
    public Long getUserId(){return userId;} public void setUserId(Long u){userId=u;}
    public Long getRoomId(){return roomId;} public void setRoomId(Long r){roomId=r;}
    public LocalDateTime getStartTime(){return startTime;} public void setStartTime(LocalDateTime s){startTime=s;}
    public LocalDateTime getEndTime(){return endTime;} public void setEndTime(LocalDateTime e){endTime=e;}
}
