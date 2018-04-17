package com.codecool.web.dao.database;


import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class Task3Dao extends AbstractDao{

    public Task3Dao(Connection connection) {
        super(connection);
    }

    public List<List<String>> getResults() throws SQLException{
        List<List<String>> result = new ArrayList<>();
        String sql="SELECT COUNT(ProductName) AS NumberOfProducts, suppliers.companyname AS CompanyName\n" +
                "FROM Products\n" +
                "INNER JOIN suppliers ON products.supplierid = suppliers.supplierid\n" +
                "GROUP BY suppliers.companyname\n" +
                "HAVING COUNT(ProductName)>4;";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                List<String> tmpList=new ArrayList<>();
                tmpList.add(resultSet.getString("numberofproducts"));
                tmpList.add(resultSet.getString("companyname"));
                result.add(tmpList);
            }
        }

        return result;

    }


}