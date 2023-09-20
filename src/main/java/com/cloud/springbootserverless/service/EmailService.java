package com.cloud.springbootserverless.service;

import com.cloud.springbootserverless.dto.Email;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmailService {

    private static List<Email> emailList =  new ArrayList<>();

    public String addEmail(String email) {
        emailList.add(new Email(email));
        return "OK";
    }

    public List<Email> getEmailByEmailId(String email) {
        return emailList.stream().filter(emailObj -> {
            return emailObj.getEmail().equals(email);
        }).collect(Collectors.toList());
    }

    public List<Email> getEmailList() {
        return emailList;
    }
}

