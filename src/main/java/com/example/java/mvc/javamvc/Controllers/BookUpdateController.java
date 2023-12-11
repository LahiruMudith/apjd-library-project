package com.example.java.mvc.javamvc.Controllers;

import com.example.java.mvc.javamvc.HelloApplication;
import com.example.java.mvc.javamvc.Model.BookModel;
import com.example.java.mvc.javamvc.To.Book;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class BookUpdateController {
    @FXML
    private AnchorPane root;

    @FXML
    private TextField txtSearchBookId;

    @FXML
    private TextField txtUpdateBookId;

    @FXML
    private TextField txtUpdateBookIsbm;

    @FXML
    private TextField txtUpdateBookName;

    @FXML
    private TextField txtUpdateBookPrice;

    @FXML
    private TextField txtUpdateBookQty;

    @FXML
    void Back(MouseEvent event) {
        try {
            Stage stage = (Stage) this.root.getScene().getWindow();

            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("view/Book-Menu-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 600, 400);
            stage.setScene(scene);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void Search(ActionEvent event) throws SQLException {
        String id = txtSearchBookId.getText();

        Book book = BookModel.SearchBook(id);

            txtUpdateBookId.setText(book.getId());
            txtUpdateBookName.setText(book.getName());
            txtUpdateBookIsbm.setText(book.getIsbm());
            txtUpdateBookQty.setText(String.valueOf(book.getQty()));
            txtUpdateBookPrice.setText(String.valueOf(book.getPrice()));


    }

    @FXML
    void UpdateBook(ActionEvent event) {
        String id = txtUpdateBookId.getText();
        String name = txtUpdateBookName.getText();
        String isbm = txtUpdateBookIsbm.getText();
        int qty = Integer.parseInt(txtUpdateBookQty.getText());
        double price = Double.parseDouble(txtUpdateBookPrice.getText());

        boolean b = BookModel.UpdateBook(new Book(id, name, isbm, qty, price));

        if (b==true) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Book Update Successfully ! ");
            alert.show();
            clear();
        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Book Update Fail ! ");
            alert.show();
        }

    }

    public void clear() {
        txtSearchBookId.setText("");
        txtSearchBookId.setText("");
        txtUpdateBookId.setText("");
        txtUpdateBookName.setText("");
        txtUpdateBookIsbm.setText("");
        txtUpdateBookQty.setText("");
        txtUpdateBookPrice.setText("");




    }
}
