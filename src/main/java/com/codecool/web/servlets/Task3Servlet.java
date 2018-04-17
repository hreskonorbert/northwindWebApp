package com.codecool.web.servlets;

import com.codecool.web.dao.database.Task1Dao;
import com.codecool.web.dao.database.Task2Dao;
import com.codecool.web.dao.database.Task3Dao;

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


@WebServlet("/TaskThree")
public class Task3Servlet extends AbstractServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try(Connection connection = getConnection(req.getServletContext())){
            Task3Dao taskThreeDao = new Task3Dao(connection);
            List<List<String>> queryResults = taskThreeDao.getResults();
            req.getSession().setAttribute("queryResults",queryResults);

        }catch(SQLException ex){
            ex.printStackTrace();
        }
        req.setCharacterEncoding("utf-8");
        req.getRequestDispatcher("task3.jsp").forward(req,resp);

    }
}
