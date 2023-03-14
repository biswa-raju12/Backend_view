package com.javaproject.fullStcakUsingJava.Service;


import com.javaproject.fullStcakUsingJava.Entity.User;
import com.javaproject.fullStcakUsingJava.Exceptions.UserNotFoundException;
import com.javaproject.fullStcakUsingJava.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserServiceClass implements UserServiceInterface {

    @Autowired
    private UserRepository userRepository;
    @Override
    public User postUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getUser() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUser(Long id) {

        if(!userRepository.existsById(id))
        {
            throw new UserNotFoundException(id);
        }

        userRepository.deleteById(id);


    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(()->new UserNotFoundException(id));
    }

    @Override
    public User updateUser(Long id, User user) {

        return userRepository.findById(id)
                .map(user2 ->{
                        user2.setUserFirstName(user.getUserFirstName());
                        user2.setUserLastName(user.getUserLastName());
                        user2.setUserAge(user.getUserAge());

                        return userRepository.save(user2);}
                ).orElseThrow(()-> new UserNotFoundException(id));
    }

}
