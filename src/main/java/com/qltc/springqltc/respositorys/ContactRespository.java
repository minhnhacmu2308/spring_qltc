package com.qltc.springqltc.respositorys;

import com.qltc.springqltc.domains.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRespository extends JpaRepository<Contact,Integer> {
    Contact save(Contact contact);
}
