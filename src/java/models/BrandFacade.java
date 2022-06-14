/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class BrandFacade extends AbstractFacade<Brand>{

    @Override
    protected List<Brand> readAll(Connection con) throws SQLException {
        List<Brand> list = new ArrayList<>();        
        //Creating and executing JDBC statements
        String sql = "select * from Brand";
        Statement stm = con.createStatement(); // dùng vs câu lệnh không có tham số # vs prepareStatement
        ResultSet rs = stm.executeQuery(sql);
        //Loading data into the list            
        while (rs.next()) {
            Brand brand = new Brand();
            brand.setId(rs.getString("id"));
            brand.setName(rs.getString("name"));
            list.add(brand);
        }
        return list;
    }

    @Override
    protected void create(Connection con, Brand brand) throws SQLException {
        try {
            String sql = "insert into Brand values(?, ?)"; // câu lệnh SQL có tham số
            PreparedStatement stm = con.prepareStatement(sql); // tạo interface để truyền câu lệnh sql vô. PreparedStatement dùng để thực hiện câu lệnh có tham số
            stm.setString(1, brand.getId());
            stm.setString(2, brand.getName()); 
            stm.executeUpdate(); // Thực hiện update
        } catch (SQLException ex) {
            throw ex;
        }
    }

    @Override
    protected Brand read(Connection con, Object id) throws SQLException {
       Brand brand = null;
        String sql = "select * from Brand where id = ?";
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setString(1, id.toString());
        ResultSet rs = stm.executeQuery();
        //Loading data into the list            
        if (rs.next()) {
            brand = new Brand();
            brand.setId(rs.getString("id"));
            brand.setName(rs.getString("name"));
        }
        return brand;
    }

    @Override
    protected void update(Connection con, Brand brand) throws SQLException {
        String sql = "update Brand set name=? where id=?";
        PreparedStatement stm = con.prepareStatement(sql);        
        stm.setString(1, brand.getName());
        stm.setString(2, brand.getId());
        stm.executeUpdate();
    }

    @Override
    protected void delete(Connection con, Object id) throws SQLException {
        String sql = "delete from Brand where id=?";
        PreparedStatement stm = con.prepareStatement(sql);        
        stm.setString(1, id.toString());
        stm.executeUpdate();
    }
    
}
