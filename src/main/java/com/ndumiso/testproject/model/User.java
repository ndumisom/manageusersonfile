package com.ndumiso.testproject.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class User {
    private String firstName;
    private String lastName;
    private String contactNumber;
}
