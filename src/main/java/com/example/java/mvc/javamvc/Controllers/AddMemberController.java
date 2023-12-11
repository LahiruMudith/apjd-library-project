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

public class AddMemberController {
    @FXML
    private AnchorPane root;

    @FXML
    private TextField txtMemberAddress;

    @FXML
    private TextField txtMemberContactNumber;

    @FXML
    private TextField txtMemberEmail;

    @FXML
    private TextField txtMemberID;

    @FXML
    private TextField txtMemberName;

    @FXML
    void AddMember(ActionEvent event) {
        String id = txtMemberID.getText();
        String name = txtMemberName.getText();
        String email = txtMemberEmail.getText();
        String address = txtMemberAddress.getText();
        int contactNumber = Integer.parseInt(txtMemberContactNumber.getText());

        boolean b = MemberModel.AddMember(new Member(id, name, email, address, contactNumber));

        if (b==true) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Member Added the successfully ! ");
            alert.show();
            clear();
        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Member Added Fail ! ");
            alert.show();
        }
    }

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

    public void clear() {
        txtMemberID.setText("");
        txtMemberName.setText("");
        txtMemberEmail.setText("");
        txtMemberAddress.setText("");
        txtMemberContactNumber.setText("");
    }
}
