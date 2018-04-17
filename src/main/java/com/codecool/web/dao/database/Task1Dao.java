package com.codecool.web.dao.database;


import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class Task1Dao extends AbstractDao{

    public Task1Dao(Connection connection) {
        super(connection);
    }

    public List<List<String>> getResults() throws SQLException{
        List<List<String>> result = new ArrayList<>();
        String sql="SELECT ProductName AS Product, suppliers.companyname AS Company\n" +
                "FROM Products\n" +
                "INNER JOIN Suppliers ON products.supplierid = suppliers.supplierid\n" +
                "ORDER BY Product ASC, Company ASC;";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                List<String> tmpList=new ArrayList<>();
                tmpList.add(resultSet.getString("product"));
                tmpList.add(resultSet.getString("company"));
                result.add(tmpList);
            }
        }

        return result;

    }


}