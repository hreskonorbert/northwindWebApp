package com.codecool.web.dao.database;


import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class Task4Dao extends AbstractDao{

    public Task4Dao(Connection connection) {
        super(connection);
    }

    public List<List<String>> getResults() throws SQLException{
        List<List<String>> result = new ArrayList<>();
        String sql="SELECT companyname, ARRAY_AGG(Orders.OrderID) AS Orders  \n" +
                "FROM Customers\n" +
                "LEFT JOIN Orders ON Customers.CustomerID = Orders.CustomerID\n" +
                "GROUP BY companyname;";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                List<String> tmpList=new ArrayList<>();
                tmpList.add(resultSet.getString("companyname"));
                tmpList.add(resultSet.getString("Orders"));
                result.add(tmpList);
            }
        }

        return result;

    }


}