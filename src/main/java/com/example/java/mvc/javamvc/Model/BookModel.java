package com.example.java.mvc.javamvc.Model;

import com.example.java.mvc.javamvc.Tm.LoadAllBookTM;
import com.example.java.mvc.javamvc.To.Book;
import com.example.java.mvc.javamvc.db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookModel {


    public static boolean AddBook(Book book) throws RuntimeException {
        Connection connection = DBConnection.getDbConnection().getConnection();

        try {

            PreparedStatement stm = connection.prepareStatement("insert into book values(?,?,?,?,?)");
            stm.setObject(1,book.getId());
            stm.setObject(2,book.getName());
            stm.setObject(3,book.getIsbm());
            stm.setObject(4,book.getQty());
            stm.setObject(5,book.getPrice());

            int results = stm.executeUpdate();


            if (results>0) {
                return true;
            }else {
                return false;
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public static boolean UpdateBook(Book book) {

        Connection connection = DBConnection.getDbConnection().getConnection();

        try {

            PreparedStatement stm = connection.prepareStatement("update book set NAME=?, ISBM=?, QTY=?, PRICE=? where BOOK_ID=?");
            stm.setObject(1,book.getName());
            stm.setObject(2,book.getIsbm());
            stm.setObject(3,book.getQty());
            stm.setObject(4,book.getPrice());
            stm.setObject(5,book.getId());

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
    public static boolean DeleteBook(String id) {

        Connection connection = DBConnection.getDbConnection().getConnection();

        try {

            PreparedStatement stm = connection.prepareStatement("delete from book where BOOK_ID=?");
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
    public static ArrayList<LoadAllBookTM> LoadAllBook() {

        Connection connection = DBConnection.getDbConnection().getConnection();

        try {

            PreparedStatement stm = connection.prepareStatement("select * from book");

            ResultSet resultSet = stm.executeQuery();

            ArrayList<LoadAllBookTM> list = new ArrayList<>();

            while (resultSet.next()) {

                LoadAllBookTM tm = new LoadAllBookTM();
                tm.setId(resultSet.getString(1));
                tm.setName(resultSet.getString(2));
                tm.setIsbm(resultSet.getString(3));
                tm.setQty(resultSet.getInt(4));
                tm.setPrice(resultSet.getDouble(5));

                list.add(tm);
            }
            return list;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static Book SearchBook(String id) {
        Connection connection = DBConnection.getDbConnection().getConnection();

        try {
            PreparedStatement stm = connection.prepareStatement("select * from book where BOOK_ID=?");
            stm.setObject(1,id);

            ResultSet resultSet = stm.executeQuery();

            Book book = new Book();

            while (resultSet.next()) {
                book.setId(resultSet.getString(1));
                book.setName(resultSet.getString(2));
                book.setIsbm(resultSet.getString(3));
                book.setQty(resultSet.getInt(4));
                book.setPrice(resultSet.getDouble(5));
            }

            return book;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

}
