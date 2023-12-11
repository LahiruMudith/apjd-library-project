package com.example.java.mvc.javamvc.Model;

import com.example.java.mvc.javamvc.To.Book;
import com.example.java.mvc.javamvc.To.Member;
import com.example.java.mvc.javamvc.db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MemberModel {
    public static boolean AddMember(Member member) {
        Connection connection = DBConnection.getDbConnection().getConnection();

        try {

            PreparedStatement stm= connection.prepareStatement("insert into member values(?,?,?,?,?)");
            stm.setObject(1,member.getId());
            stm.setObject(2,member.getName());
            stm.setObject(3,member.getEmail());
            stm.setObject(4,member.getAddress());
            stm.setObject(5,member.getContactNumber());

            int result = stm.executeUpdate();

            if (result>0) {
                return true;
            }else {
                return false;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public static boolean DeleteMember(String id) {
        Connection connection = DBConnection.getDbConnection().getConnection();

        try {
            PreparedStatement stm = connection.prepareStatement("delete from member where Member_id=?");
            stm.setObject(1,id);

            int result = stm.executeUpdate();

            if (result>0) {
                return true;
            }else {
                return false;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static boolean UpdateMember(Member member) {

        Connection connection = DBConnection.getDbConnection().getConnection();
        try {
            PreparedStatement stm = connection.prepareStatement("update member set Name=?, Email=?, Address=?, contactNumber=? where Member_id=? ");
            stm.setObject(1,member.getName());
            stm.setObject(2,member.getEmail());
            stm.setObject(3,member.getAddress());
            stm.setObject(4,member.getContactNumber());
            stm.setObject(5,member.getId());

            int result = stm.executeUpdate();

            System.out.println(member.getId());

            if (result>0) {
                return true;
            }else {
                return false;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public static ArrayList LoadMember() {
        return null;
    }
    public static Member Search(String id) throws RuntimeException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        try {
            PreparedStatement stm = connection.prepareStatement("select * from member where Member_id=?");
            stm.setObject(1,id);

            ResultSet resultSet = stm.executeQuery();

            Member member = new Member();

            while (resultSet.next()) {
                member.setId(resultSet.getString(1));
                member.setName(resultSet.getString(2));
                member.setEmail(resultSet.getString(3));
                member.setAddress(resultSet.getString(4));
                member.setContactNumber(Integer.parseInt(resultSet.getString(5)));
            }

            return member;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
