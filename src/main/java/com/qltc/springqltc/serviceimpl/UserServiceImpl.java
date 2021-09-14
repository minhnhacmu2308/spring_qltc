package com.qltc.springqltc.serviceimpl;

import com.qltc.springqltc.domains.Role;
import com.qltc.springqltc.domains.User;
import com.qltc.springqltc.respositorys.RoleRespository;
import com.qltc.springqltc.respositorys.UserRespository;
import com.qltc.springqltc.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    public UserRespository userRespository;

    @Autowired
    public RoleRespository roleRespository;

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

    @Override
    public Role findRoleById(int id) {
        return roleRespository.findRoleById(id);
    }

    @Override
    public List<User> getCus() {
        return userRespository.getCus();
    }

    @Override
    public List<User> getEm() {
        return userRespository.getEm();
    }

    @Override
    public int update(String fullname, String email,String phonenumber, String address, String username, String password, String image, int id) {
        return userRespository.update(fullname,email,phonenumber,address,username,password,image,id);
    }

    @Override
    public int delete(int id) {
        return userRespository.delete(id);
    }
}
