package com.javaproject.fullStcakUsingJava.Controller;

import com.javaproject.fullStcakUsingJava.Entity.User;
import com.javaproject.fullStcakUsingJava.Exceptions.UserNotFoundException;
import com.javaproject.fullStcakUsingJava.Service.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class HomeController {

    @Autowired
    private UserServiceInterface userServiceInterface;


    //post all data

    @PostMapping("/users")
    public User postUser(@RequestBody User user)
    {
        return userServiceInterface.postUser(user);
    }

    //get all data
    @GetMapping("/users")
    public List<User> getUser(){
        return userServiceInterface.getUser();
    }


    //get data by user id
    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable("id") Long id)
    {
        return userServiceInterface.getUserById(id);
    }


    //Update User

    @PutMapping("/users/{id}")
    public User updateUser(@PathVariable("id") Long id, @RequestBody User user)
    {
        return userServiceInterface.updateUser(id,user);
    }


    //Delete data by user id
    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable("id") Long id)
    {
        userServiceInterface.deleteUser(id);

        return "Mentioned User got Deleted from DataRepository!!";
    }


    //Home Page(Router)
    @GetMapping("/")
    public String HomeCall(){
        return "Welcome to Spring Boot Application";
    }

}
