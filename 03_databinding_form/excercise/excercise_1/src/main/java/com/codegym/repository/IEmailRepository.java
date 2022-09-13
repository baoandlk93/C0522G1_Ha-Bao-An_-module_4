package com.codegym.repository;

import com.codegym.model.Email;

import java.util.List;

public interface IEmailRepository {
     List<Email> displayAll();

     Email findById(int id);

     Email edit( Email email);

     List<String> languageList();

     List<Integer> pageSizeList();

}
