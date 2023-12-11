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

public class MemberDeleteController {
    @FXML
    private AnchorPane root;

    @FXML
    private TextField txtDeleteMemberAddress;

    @FXML
    private TextField txtDeleteMemberContactNumber;

    @FXML
    private TextField txtDeleteMemberEmail;

    @FXML
    private TextField txtDeleteMemberId;

    @FXML
    private TextField txtDeleteMemberName;

    @FXML
    private TextField txtSearchMemberId;

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
    void DeleteMember(ActionEvent event) {
        String id = txtDeleteMemberId.getText();

        boolean b = MemberModel.DeleteMember(id);

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

    @FXML
    void Search(ActionEvent event) {
        String id = txtSearchMemberId.getText();

        Member search = MemberModel.Search(id);
        System.out.println(search.getId() +" "+ search.getName() +" "+ search.getEmail() +" "+ search.getAddress() +" "+ search.getContactNumber());
        txtDeleteMemberId.setText(search.getId());
        txtDeleteMemberName.setText(search.getName());
        txtDeleteMemberEmail.setText(search.getEmail());
        txtDeleteMemberAddress.setText(search.getAddress());
        txtDeleteMemberContactNumber.setText(String.valueOf(search.getContactNumber()));
    }
    public void clear() {
        txtSearchMemberId.setText("");
        txtDeleteMemberId.setText("");
        txtDeleteMemberName.setText("");
        txtDeleteMemberEmail.setText("");
        txtDeleteMemberAddress.setText("");
        txtDeleteMemberContactNumber.setText("");
    }

}
