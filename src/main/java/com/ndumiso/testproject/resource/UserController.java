package com.ndumiso.testproject.resource;

import com.ndumiso.testproject.model.User;
import com.ndumiso.testproject.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1")
public class UserController {
    @Autowired
    FileService fileService;
    @RequestMapping(value = "/user", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.TEXT_HTML_VALUE)
    public String addUser(@RequestBody User user) {
        return fileService.writeToAFile(user);
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public User getUser(String firstName) {
        return fileService.findUser();
    }

    @RequestMapping(value = "/user", method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.TEXT_HTML_VALUE)
    public String updateUser(@RequestBody User user) {
        return fileService.updateUser(user);
    }

    @RequestMapping(value = "/user", method = RequestMethod.DELETE,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.TEXT_HTML_VALUE)
    public String deleteUser() throws FileNotFoundException {
        return fileService.deleteUser();
    }
}
