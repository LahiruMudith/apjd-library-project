package com.example.java.mvc.javamvc.Controllers;

import com.example.java.mvc.javamvc.HelloApplication;
import com.example.java.mvc.javamvc.Model.BookModel;
import com.example.java.mvc.javamvc.Model.MemberModel;
import com.example.java.mvc.javamvc.To.Book;
import com.example.java.mvc.javamvc.To.Member;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class IssueMenuController {
    @FXML
    private AnchorPane root;

    @FXML
    private TextField txtBookIsbm;

    @FXML
    private TextField txtBookName;

    @FXML
    private TextField txtBookPrice;

    @FXML
    private TextField txtBookQty;

    @FXML
    private TextField txtIssueBookId;

    @FXML
    private TextField txtIssueMemberId;

    @FXML
    private TextField txtMemberAddress;

    @FXML
    private TextField txtMemberContactNumber;

    @FXML
    private TextField txtMemberEmail;

    @FXML
    private TextField txtMemberName;

    @FXML
    void Back(MouseEvent event) {
        try {
            Stage stage = (Stage) this.root.getScene().getWindow();

            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("view/Main-Menu.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 600, 400);
            stage.setScene(scene);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void BookID(ActionEvent event) {
        String id = txtIssueBookId.getText();

        Book book = BookModel.SearchBook(id);

        txtBookName.setText(book.getName());
        txtBookIsbm.setText(book.getIsbm());
        txtBookQty.setText(String.valueOf(book.getQty()));
        txtBookPrice.setText(String.valueOf(book.getPrice()));

    }

    @FXML
    void IssueBook(ActionEvent event) {

    }

    @FXML
    void MemberId(ActionEvent event) {
        String id = txtIssueMemberId.getText();

        Member search = MemberModel.Search(id);

        txtMemberName.setText(search.getName());
        txtMemberEmail.setText(search.getEmail());
        txtMemberAddress.setText(search.getAddress());
        txtMemberContactNumber.setText(String.valueOf(search.getContactNumber()));


    }
}
