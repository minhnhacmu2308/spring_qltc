package com.qltc.springqltc.respositorys;


import com.qltc.springqltc.domains.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface UserRespository extends JpaRepository<User,Integer> {
    User findUsersByUserName(String userName);

    @Query("select u from User u where u.userName = :userName and u.password = :password")
    User findUsersByUserNameAndPassword(@Param("userName") String  userName, @Param("password") String  password);

    User findUsersById(int id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE User SET image = ? WHERE id = ?",nativeQuery = true)
    int changeAvatar(String image,int id);
}
