package com.gmail.evanloafakahaitao.hwk28.tomcat.src.com.gmail.evanloafakahaitao.projprep.servlets;

import com.gmail.evanloafakahaitao.projprep.services.SQLExecutorService;
import com.gmail.evanloafakahaitao.projprep.servlets.commands.Command;
import com.gmail.evanloafakahaitao.projprep.servlets.commands.impl.RegisterCommandImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class DispatcherServlet extends HttpServlet {

    private Map<String, Command> commands = new HashMap<>();
    private SQLExecutorService sqlExecutorService = new SQLExecutorService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String command = req.getParameter("command");
        Command commandAction = commands.get(command);
        if (commandAction != null) {
            try {
                commandAction.execute(req, resp);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Command does not exist.");
        }
    }

    @Override
    public void init() throws ServletException {
        commands.put("register", new RegisterCommandImpl());
        sqlExecutorService.executeSQL("D:\\SHARED\\Dropbox\\JavaU\\ProjPrep1\\sql\\User.sql");
    }
}
