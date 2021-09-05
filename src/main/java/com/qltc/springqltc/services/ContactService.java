package com.qltc.springqltc.services;

import com.qltc.springqltc.domains.Contact;
import org.springframework.stereotype.Service;

@Service
public interface ContactService {
    Contact save(Contact contact);
}
