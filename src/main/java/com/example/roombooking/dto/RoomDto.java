package com.example.roombooking.dto;

public class RoomDto {
    private Long id; private String name, location; private Integer capacity;
    public RoomDto() {}
    public RoomDto(Long i,String n,String l,Integer c){id=i;name=n;location=l;capacity=c;}
    public Long getId(){return id;} public void setId(Long i){id=i;}
    public String getName(){return name;} public void setName(String n){name=n;}
    public String getLocation(){return location;} public void setLocation(String l){location=l;}
    public Integer getCapacity(){return capacity;} public void setCapacity(Integer c){capacity=c;}
}
