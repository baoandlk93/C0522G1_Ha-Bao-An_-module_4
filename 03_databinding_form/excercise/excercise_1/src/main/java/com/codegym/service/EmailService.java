package com.codegym.service;

import com.codegym.model.Email;
import com.codegym.repository.IEmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailService implements IEmailService {
    @Autowired
    private IEmailRepository emailRepository;
    @Override
    public List<Email> displayAll() {
        return emailRepository.displayAll();
    }

    @Override
    public Email findById(int id) {
        return emailRepository.findById(id);
    }

    @Override
    public Email edit(Email email) {
       return emailRepository.edit(email);
    }

    @Override
    public List<String> languageList() {
        return emailRepository.languageList();
    }

    @Override
    public List<Integer> pageSizeList() {
        return emailRepository.pageSizeList();
    }
}
