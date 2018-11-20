package com.example.demo.Services;


import com.example.demo.Model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    User createUser(User user);
    User getUser(Long id);
    User editUser(User user);
    void deleteUser(User user);
    List<User> getAllUser();
    
}
