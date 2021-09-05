package com.qltc.springqltc.serviceimpl;

import com.qltc.springqltc.domains.User;
import com.qltc.springqltc.respositorys.UserRespository;
import com.qltc.springqltc.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    public UserRespository userRespository;

    @Override
    public User save(User user) {
        return userRespository.save(user);
    }

    @Override
    public boolean login(String username, String password) {
        return false;
    }

    @Override
    public boolean checkEmail(String email) {
        return false;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User findByEmail(String email) {
        return null;
    }

    @Override
    public User findByUserName(String username) {
        return userRespository.findUsersByUserName(username);
    }

    @Override
    public User findByUserNameAndPassword(String username, String password) {
        return userRespository.findUsersByUserNameAndPassword(username,password);
    }

    @Override
    public User findById(int id) {
        return null;
    }

    @Override
    public int changeAvatar(String image, int id) {
        return userRespository.changeAvatar(image,id);
    }
}
