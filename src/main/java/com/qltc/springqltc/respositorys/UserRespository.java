package com.qltc.springqltc.respositorys;


import com.qltc.springqltc.domains.Service;
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

    User save(User user);

    @Query(value = "SELECT * FROM user WHERE enable = 1 and role_id = 1 ",nativeQuery = true)
    List<User> getCus();

    @Query(value = "SELECT * FROM user WHERE enable = 1 and role_id = 3 ",nativeQuery = true)
    List<User> getEm();

    @Modifying
    @Transactional
    @Query(value = "Update user SET full_name = ? , email = ?, phone_number = ?, address = ?, username = ?, password = ?, image = ? WHERE id = ?",nativeQuery = true)
    int update(String fullname, String email,String phonenumber, String address, String username, String password, String image, int id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE user SET enable = 0 WHERE id = ?",nativeQuery = true)
    int delete( int id);
}
