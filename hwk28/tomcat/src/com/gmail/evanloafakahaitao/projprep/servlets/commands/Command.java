package com.gmail.evanloafakahaitao.hwk28.tomcat.src.com.gmail.evanloafakahaitao.projprep.servlets.commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command {

    String execute(HttpServletRequest request, HttpServletResponse response);
}
