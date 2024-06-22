package com.ridham.userProfile.controller;

import com.ridham.userProfile.dto.UserDTO;
import com.ridham.userProfile.entities.User;
import com.ridham.userProfile.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController

@RequestMapping(value = "/api/user")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private ModelMapper modelMapper;
    @RequestMapping(value = "/addUser", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addUser(@RequestBody User user){

        return new ResponseEntity(userService.addUser(user), HttpStatus.CREATED);
    }

    @RequestMapping(value="/findUser", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> getUser(@RequestParam(value = "name") String name){
        List<User> userEntity = userService.getUserByName(name);
        List<UserDTO> userList = new ArrayList<>();
        for(User i: userEntity){
            userList.add(modelMapper.map(i, UserDTO.class));
        }
        return new ResponseEntity(userList, HttpStatus.OK);
    }

    @RequestMapping(value = "/findUser/{id}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getUserByid(@PathVariable(name = "id") Integer id){
        Optional<User> user = userService.getUserById(id);

        UserDTO userdto = modelMapper.map(user.get(), UserDTO.class);
        return new ResponseEntity(userdto, HttpStatus.OK);
    }
}
