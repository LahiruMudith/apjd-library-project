package com.example.java.mvc.javamvc.Controllers;

import com.example.java.mvc.javamvc.HelloApplication;
import com.example.java.mvc.javamvc.Model.BookModel;
import com.example.java.mvc.javamvc.Tm.LoadAllBookTM;
import com.example.java.mvc.javamvc.To.Book;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class LoadAllBookController implements Initializable {
    @FXML
    private AnchorPane root;

    @FXML
    private TableView<LoadAllBookTM> tblLoadAllBook;

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
    void LoadAll(ActionEvent event) {

        ArrayList<LoadAllBookTM> list = BookModel.LoadAllBook();


        tblLoadAllBook.setItems(FXCollections.observableArrayList(list));

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tblLoadAllBook.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        tblLoadAllBook.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        tblLoadAllBook.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("isbm"));
        tblLoadAllBook.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("qty"));
        tblLoadAllBook.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("price"));
    }
}
