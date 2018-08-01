package com.gmail.evanloafakahaitao.hwk28.tomcat.src.com.gmail.evanloafakahaitao.projprep.servlets.commands.impl;

import com.gmail.evanloafakahaitao.projprep.dao.model.User;
import com.gmail.evanloafakahaitao.projprep.services.UserService;
import com.gmail.evanloafakahaitao.projprep.services.impl.UserServiceImpl;
import com.gmail.evanloafakahaitao.projprep.servlets.commands.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterCommandImpl implements Command {

    private UserService userService = new UserServiceImpl();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String firstName = request.getParameter("first_name");
        String lastName = request.getParameter("last_name");
        User user = new User(
                email,
                password,
                firstName,
                lastName
        );
        userService.save(user);
        return null;
    }
}
