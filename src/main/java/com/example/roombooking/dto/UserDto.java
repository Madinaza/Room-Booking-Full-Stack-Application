package com.example.roombooking.dto;

public class UserDto {
    private Long id;
    private String username;
    public UserDto() {}
    public UserDto(Long i, String u){id=i;username=u;}
    public Long getId(){return id;}
    public void setId(Long i){this.id=i;}
    public String getUsername(){return username;}
    public void setUsername(String u){this.username=u;}
}
