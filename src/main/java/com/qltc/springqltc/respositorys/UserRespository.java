package com.qltc.springqltc.respositorys;


import com.qltc.springqltc.domains.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRespository extends JpaRepository<User,Integer> {
    User findUsersByUserName(String userName);
    User findUsersById(int id);
}
