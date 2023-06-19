package com.ndumiso.testproject.service;

import com.ndumiso.testproject.model.User;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public interface FileService {
    String writeToAFile(User user);
    User findUser();
    String updateUser(User user);
    String deleteUser() throws FileNotFoundException;
}
