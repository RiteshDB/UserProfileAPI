package com.ridham.userProfile.controller;

import com.ridham.userProfile.entities.User;
import com.ridham.userProfile.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/addUser", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addUser(@RequestBody User user){
        return new ResponseEntity(userService.addUser(user), HttpStatus.CREATED);
    }

    @RequestMapping(value="/findUser/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE,
    consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getUser(@PathVariable(name = "name") String name){
        return new ResponseEntity(userService.getUserByName(name), HttpStatus.OK);
    }
}
