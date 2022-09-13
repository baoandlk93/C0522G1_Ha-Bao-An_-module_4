package com.codegym.service;

import com.codegym.model.Email;

import java.util.List;

public interface IEmailService {
    List<Email> displayAll();

    Email findById(int id);

    Email edit(Email email);

    List<String> languageList();

    List<Integer> pageSizeList();
}
