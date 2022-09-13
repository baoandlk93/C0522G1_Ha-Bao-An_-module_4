package com.codegym.repository;

import com.codegym.model.Email;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmailRepository implements IEmailRepository {
    private static List<Email> emailList = new ArrayList<>();

    static {
        emailList.add(new Email(1, "English", 5, false, "Ok"));
        emailList.add(new Email(2, "English", 5, true, "Ok"));
        emailList.add(new Email(3, "English", 5, false, "Ok"));
        emailList.add(new Email(4, "English", 5, false, "Ok"));
        emailList.add(new Email(5, "English", 5, false, "Ok"));
        emailList.add(new Email(6, "English", 5, false, "Ok"));

    }

    @Override
    public List<Email> displayAll() {
        return emailList;
    }

    @Override
    public Email findById(int id) {
        return emailList.get(id);
    }

    @Override
    public Email edit( Email email) {
        Email origin = findById(email.getId());
        origin.setLanguage(email.getLanguage());
        origin.setPageSize(email.getPageSize());
        origin.setSignature(email.getSignature());
        origin.setSpamFilter(email.isSpamFilter());
        return origin;
    }

    @Override
    public List<String> languageList() {
        List<String> language = new ArrayList<>();
        language.add("English");
        language.add("Vietnamese");
        language.add("French");
        language.add("Spain");
        language.add("Chinese");
        language.add("Japanese");
        return language;
    }

    @Override
    public List<Integer> pageSizeList() {
        List<Integer> pageSize = new ArrayList<>();
        pageSize.add(5);
        pageSize.add(10);
        pageSize.add(15);
        pageSize.add(20);
        pageSize.add(25);
        return pageSize;
    }

}
