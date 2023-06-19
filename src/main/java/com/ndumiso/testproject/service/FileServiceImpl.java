package com.ndumiso.testproject.service;

import com.ndumiso.testproject.model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

@Service
public class FileServiceImpl implements FileService{
    @Value("${file.location}")
    private String fileLocation;
    public String writeToAFile(User user) {
        try {
            FileWriter myWriter = new FileWriter(fileLocation);
            myWriter.append("First Name : " +user.getFirstName()+"\t,");
            myWriter.append("Last Name : " +user.getLastName()+"\t,");
            myWriter.append("ContactNumber : " +user.getContactNumber()+"\t");
            myWriter.close();
            return "Successfully wrote to the file.";
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return "Unsuccessfully wrote to the file.";
        }
    }

    @Override
    public User findUser() {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(fileLocation));
            String line = reader.readLine();

            if (line != null) {
                User user = new User();
                String userInformation [] = line.split(",");
                if(userInformation.length > 0) {
                    user.setFirstName(userInformation[0].replaceAll("\t" , "").split(":")[1]);
                }
                if(userInformation.length > 1) {
                    user.setLastName(userInformation[1].replaceAll("\t" , "").split(":")[1]);
                }
                if(userInformation.length >= 2) {
                    user.setContactNumber(userInformation[2].replaceAll("\t" , "").split(":")[1]);
                }
                return user;
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public String updateUser(User user) {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(fileLocation));
            String line = reader.readLine();
            if(line != null) {
                FileWriter myWriter = new FileWriter(fileLocation);
                myWriter.append("First Name : " + user.getFirstName() + "\t,");
                myWriter.append("Last Name : " + user.getLastName() + "\t,");
                myWriter.append("ContactNumber : " + user.getContactNumber() + "\t");
                myWriter.close();
                return "Updated Successfully.";
            } else {
                return "Record does not exists";
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return "Failed to update successfully.";
        }
    }

    @Override
    public String deleteUser() throws FileNotFoundException {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(fileLocation));
            String line = reader.readLine();
            if(line != null) {
                PrintWriter writer = new PrintWriter(fileLocation);
                writer.print("");
                writer.close();
                return "User data deleted successfully.";
            } else {
                return "User data does not exists.";
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return "Failed to delete user data successfully.";
        }
    }
}
