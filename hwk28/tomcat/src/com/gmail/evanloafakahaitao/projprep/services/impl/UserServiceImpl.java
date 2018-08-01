package com.gmail.evanloafakahaitao.hwk28.tomcat.src.com.gmail.evanloafakahaitao.projprep.services.impl;

import com.gmail.evanloafakahaitao.projprep.dao.UserDao;
import com.gmail.evanloafakahaitao.projprep.dao.connection.ConnectionSingletonService;
import com.gmail.evanloafakahaitao.projprep.dao.impl.UserDaoImpl;
import com.gmail.evanloafakahaitao.projprep.dao.model.User;
import com.gmail.evanloafakahaitao.projprep.services.UserService;

import java.sql.Connection;
import java.sql.SQLException;

public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    @Override
    public User save(User user) {
        Connection connection = ConnectionSingletonService.getInstance().getConnection();
        try {
            connection.setAutoCommit(false);
            userDao.save(connection, user);
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
        return user;
    }
}
