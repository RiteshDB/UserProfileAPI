package com.ridham.userProfile.controller;

import com.ridham.userProfile.dto.UserDTO;
import com.ridham.userProfile.entities.ErrorMessage;
import com.ridham.userProfile.entities.User;
import com.ridham.userProfile.exception.RecordNotFoundException;
import com.ridham.userProfile.service.UserService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

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
    public ResponseEntity<UserDTO> addUser(@Valid @RequestBody UserDTO userDTO){
        User user = modelMapper.map(userDTO, User.class);
        User addedUser = userService.addUser(user);
        UserDTO result = modelMapper.map(addedUser, UserDTO.class);
        return new ResponseEntity(result, HttpStatus.CREATED);
    }

    @RequestMapping(value="/findUser", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> getUser(@RequestParam(value = "name") String name){
        User userEntity = userService.getUserByName(name);
        return new ResponseEntity(userEntity, HttpStatus.OK);
    }

    @RequestMapping(value = "/findUser/{id}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getUserByid(@PathVariable(name = "id") Integer id){
        User user = userService.getUserById(id);
        UserDTO userdto = modelMapper.map(user, UserDTO.class);
        return new ResponseEntity(userdto, HttpStatus.OK);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteUser(@RequestBody UserDTO userDTO){
        User user = modelMapper.map(userDTO, User.class);
        User deletedUser = userService.delete(user);
        UserDTO userdel = modelMapper.map(deletedUser, UserDTO.class);
        return new ResponseEntity(userdel, HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateUser(@RequestBody UserDTO userDTO){
        User user = modelMapper.map(userDTO, User.class);
        User updateUser = userService.updateUser(user);
        UserDTO userUpd = modelMapper.map(updateUser, UserDTO.class);
        return new ResponseEntity(userUpd, HttpStatus.OK);
    }

    @ExceptionHandler(value = RecordNotFoundException.class)
    public ResponseEntity<ErrorMessage>  recordNotFoundExceptionHandler(RecordNotFoundException ex, WebRequest req){
        ErrorMessage message = new ErrorMessage(
                HttpStatus.NOT_FOUND.value(),
                new Date(),
                ex.getMessage(),
                req.getDescription(false));
        return new ResponseEntity<ErrorMessage>(message, HttpStatus.NOT_FOUND);
    }

}
