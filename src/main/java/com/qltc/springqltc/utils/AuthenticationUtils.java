package com.qltc.springqltc.utils;

import com.qltc.springqltc.constants.MyConstants;
import com.qltc.springqltc.domains.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class AuthenticationUtils {
    public static boolean middleWare(HttpServletRequest request){
        HttpSession session = request.getSession();
        User userAdmin = (User)session.getAttribute(MyConstants.SESSION_USER);
        if(userAdmin == null) {
            return false;
        }else {
            return true;
        }
    }
}
