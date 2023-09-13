package com.example.msusers.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
public class User {
    private String id;
    private String username;
    private String email;
    private String firstname;
    private List<Bill> bills;
}
