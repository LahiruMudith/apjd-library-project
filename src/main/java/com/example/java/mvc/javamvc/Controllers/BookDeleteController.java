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

public class BookDeleteController {
    @FXML
    private AnchorPane root;

    @FXML
    private TextField txtSearchBookId;

    @FXML
    private TextField txtDeleteBookId;

    @FXML
    private TextField txtDeleteBookIsbm;

    @FXML
    private TextField txtDeleteBookName;

    @FXML
    private TextField txtDeleteBookPrice;

    @FXML
    private TextField txtDeleteBookQty;

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
    void DeleteBook(ActionEvent event) {
        String id = txtSearchBookId.getText();

        boolean b = BookModel.DeleteBook(id);

        if (b==true) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Book Added the successfully ! ");
            alert.show();
            clear();
        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Book Added Fail ! ");
            alert.show();
        }

    }

    @FXML
    void Search(ActionEvent event) {
        String id = txtSearchBookId.getText();

        System.out.println(id);

        Book book = BookModel.SearchBook(id);
        System.out.println(book.getId());
        System.out.println(book.getName());
        txtDeleteBookId.setText(book.getId());
        txtDeleteBookName.setText(book.getName());
        txtDeleteBookIsbm.setText(book.getIsbm());
        txtDeleteBookQty.setText(String.valueOf(book.getQty()));
        txtDeleteBookPrice.setText(String.valueOf(book.getPrice()));

    }

    public void clear() {
        txtSearchBookId.setText("");
        txtDeleteBookId.setText("");
        txtDeleteBookName.setText("");
        txtDeleteBookIsbm.setText("");
        txtDeleteBookQty.setText("");
        txtDeleteBookPrice.setText("");
    }
}
