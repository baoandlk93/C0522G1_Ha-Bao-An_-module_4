package com.example.service;

import com.example.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IUserService {
    Page<User> findAll(Pageable pageable);

    void save(User user);

    void edit(User user);

    void remove(User user);

    User findById(int id);

    Page<User> finByName(String name,Pageable pageable);
}
