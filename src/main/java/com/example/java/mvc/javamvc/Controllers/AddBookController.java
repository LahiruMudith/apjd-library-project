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

public class AddBookController {
    @FXML
    private AnchorPane root;

    @FXML
    private TextField txtBookId;

    @FXML
    private TextField txtBookIsbm;

    @FXML
    private TextField txtBookName;

    @FXML
    private TextField txtBookPrice;

    @FXML
    private TextField txtBookQty;

    @FXML
    void AddBook(ActionEvent event) {
        String id = txtBookId.getText();
        String name = txtBookName.getText();
        String isbm = txtBookIsbm.getText();
        int qty = Integer.parseInt(txtBookQty.getText());
        double price = Double.parseDouble(txtBookPrice.getText());
        System.out.println(id +" "+ name +" "+ price +" ");

        boolean b = BookModel.AddBook(new Book(id, name, isbm, qty, price));



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

    public void clear() {
        txtBookId.setText("");
        txtBookName.setText("");
        txtBookIsbm.setText("");
        txtBookQty.setText("");
        txtBookPrice.setText("");

    }
}
