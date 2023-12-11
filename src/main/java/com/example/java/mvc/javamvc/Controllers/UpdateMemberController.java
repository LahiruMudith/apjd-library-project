package com.example.java.mvc.javamvc.Controllers;

import com.example.java.mvc.javamvc.HelloApplication;
import com.example.java.mvc.javamvc.Model.MemberModel;
import com.example.java.mvc.javamvc.To.Member;
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

public class UpdateMemberController {
    @FXML
    private AnchorPane root;

    @FXML
    private TextField txtSearchMemberId;

    @FXML
    private TextField txtUpdateMemberAddress;

    @FXML
    private TextField txtUpdateMemberContactNumber;

    @FXML
    private TextField txtUpdateMemberEmail;

    @FXML
    private TextField txtUpdateMemberId;

    @FXML
    private TextField txtUpdateMemberName;

    @FXML
    void Back(MouseEvent event) {
        try {
            Stage stage = (Stage) this.root.getScene().getWindow();

            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("view/Member-Menu-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 600, 400);
            stage.setScene(scene);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void UpdateBook(ActionEvent event) {
        String id = txtUpdateMemberId.getText();
        String name = txtUpdateMemberName.getText();
        String email = txtUpdateMemberEmail.getText();
        String address = txtUpdateMemberAddress.getText();
        int ContactNumber = Integer.parseInt(txtUpdateMemberContactNumber.getText());

        boolean b = MemberModel.UpdateMember(new Member(id, name, email, address, ContactNumber));

        if (b==true) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Member Update Successfully ! ");
            alert.show();
            clear();
        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Member Update Fail ! ");
            alert.show();
        }

    }

    @FXML
    void Search(ActionEvent event) {
        String id = txtSearchMemberId.getText();

        Member search = MemberModel.Search(id);

        System.out.println(search.getId());

        txtUpdateMemberId.setText(search.getId());
        txtUpdateMemberName.setText(search.getName());
        txtUpdateMemberEmail.setText(search.getEmail());
        txtUpdateMemberAddress.setText(search.getAddress());
        txtUpdateMemberContactNumber.setText(String.valueOf(search.getContactNumber()));

    }

    public void clear() {
        txtSearchMemberId.setText("");
        txtUpdateMemberId.setText("");
        txtUpdateMemberName.setText("");
        txtUpdateMemberEmail.setText("");
        txtUpdateMemberAddress.setText("");
        txtUpdateMemberContactNumber.setText("");
    }
}
