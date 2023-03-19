package com.examle.springcrud.service;

import com.examle.springcrud.model.User;

import java.util.List;

public interface UserService {


    void addUser(User user);

    void editUser(User user);

    void deleteUser(User user);

    List<User> getAllUsers();

    User getUserById(Long id);

}
