package com.javaproject.fullStcakUsingJava.Service;

import com.javaproject.fullStcakUsingJava.Entity.User;

import java.util.List;

public interface UserServiceInterface {

    public User postUser(User user);

    public List<User> getUser();


    public void deleteUser(Long id);

    public User getUserById(Long id);

    public User updateUser(Long id, User user);
}
