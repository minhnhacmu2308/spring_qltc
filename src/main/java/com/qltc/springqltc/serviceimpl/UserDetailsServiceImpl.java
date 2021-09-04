/*
package com.qltc.springqltc.serviceimpl;

import com.qltc.springqltc.domains.Role;
import com.qltc.springqltc.domains.UserA;
import com.qltc.springqltc.respositorys.RoleRespository;
import com.qltc.springqltc.respositorys.UserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRespository userRespository;

    @Autowired
    private RoleRespository roleRespository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserA appUserA = this.userRespository.findUsersByUserName(userName);

        if (appUserA == null) {
            System.out.println("User not found! " + userName);
            throw new UsernameNotFoundException("User " + userName + " was not found in the database");
        }

        System.out.println("Found User: " + appUserA);


        // [ROLE_USER, ROLE_ADMIN,..]

        Role role = this.roleRespository.getById(appUserA.getId());
        System.out.println("Role User: " + role);

        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
        // ROLE_USER, ROLE_ADMIN,..
        GrantedAuthority authority = new SimpleGrantedAuthority(role.getRoleName());
        grantList.add(authority);


        UserDetails userDetails = (UserDetails)new User(appUserA.getUserName(),
                appUserA.getEncrytedPassword(), grantList);

        return userDetails;
    }

}
*/
