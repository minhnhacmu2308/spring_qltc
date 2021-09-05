package com.qltc.springqltc.serviceimpl;

import com.qltc.springqltc.domains.Contact;
import com.qltc.springqltc.respositorys.ContactRespository;
import com.qltc.springqltc.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    public ContactRespository contactRespository;

    @Override
    public Contact save(Contact contact) {
        return contactRespository.save(contact);
    }
}
