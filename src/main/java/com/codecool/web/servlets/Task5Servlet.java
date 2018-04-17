package com.codecool.web.servlets;

import com.codecool.web.dao.database.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;


@WebServlet("/TaskFive")
public class Task5Servlet extends AbstractServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try(Connection connection = getConnection(req.getServletContext())){
            Task5Dao taskFiveDao = new Task5Dao(connection);
            List<List<String>> queryResults = taskFiveDao.getResults();
            req.getSession().setAttribute("queryResults",queryResults);

        }catch(SQLException ex){
            ex.printStackTrace();
        }
        req.setCharacterEncoding("utf-8");
        req.getRequestDispatcher("task5.jsp").forward(req,resp);

    }
}
