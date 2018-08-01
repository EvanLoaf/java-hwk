package com.gmail.evanloafakahaitao.hwk28.tomcat.src.com.gmail.evanloafakahaitao.projprep.dao;

import com.gmail.evanloafakahaitao.projprep.dao.model.User;

import java.sql.Connection;

public interface UserDao {

    User save(Connection connection, User user);
}
