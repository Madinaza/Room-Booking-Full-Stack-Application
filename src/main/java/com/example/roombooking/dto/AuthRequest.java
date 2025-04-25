package com.example.roombooking.dto;

public class AuthRequest {
    private String username;
    private String password;
    public AuthRequest() {}
    public AuthRequest(String u, String p) {username=u;password=p;}
    public String getUsername(){return username;}
    public void setUsername(String u){this.username=u;}
    public String getPassword(){return password;}
    public void setPassword(String p){this.password=p;}
}
