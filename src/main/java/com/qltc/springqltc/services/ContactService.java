package com.qltc.springqltc.services;

import com.qltc.springqltc.domains.Contact;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ContactService {
    Contact save(Contact contact);

    List<Contact> findAll();
}
