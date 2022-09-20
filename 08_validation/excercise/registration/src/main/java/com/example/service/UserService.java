package com.example.service;

import com.example.model.User;
import com.example.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository iUserRepository;

    @Override
    public Page<User> findAll(Pageable pageable) {
        return iUserRepository.findAll(pageable);
    }

    @Override
    public void save(User user) {
        iUserRepository.save(user);
    }

    @Override
    public void edit(User user) {
        iUserRepository.save(user);
    }

    @Override
    public void remove(User user) {
        iUserRepository.delete(user);
    }

    @Override
    public User findById(int id) {
        return iUserRepository.findById(id);
    }

    @Override
    public Page<User> finByName(String name, Pageable pageable) {
        return iUserRepository.findByLastNameContains(name,pageable);
    }
}
