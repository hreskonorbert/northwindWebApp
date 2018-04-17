package com.codecool.web.dao.database;


import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class Task5Dao extends AbstractDao{

    public Task5Dao(Connection connection) {
        super(connection);
    }

    public List<List<String>> getResults() throws SQLException{
        List<List<String>> result = new ArrayList<>();
        String sql="SELECT suppliers.companyname AS companyname ,productname, MAX(UnitPrice) as MaxPrice\n" +
                "FROM Products\n" +
                "INNER JOIN Suppliers ON products.supplierid = suppliers.supplierid\n" +
                "GROUP BY companyname, productname;";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                List<String> tmpList=new ArrayList<>();
                tmpList.add(resultSet.getString("companyname"));
                tmpList.add(resultSet.getString("productname"));
                tmpList.add(resultSet.getString("maxprice"));
                result.add(tmpList);
            }
        }

        return result;

    }


}