package sample;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static sample.Main.personInfoList;
import static sample.loginController.MyId;

public class MyPersonAccountController implements Initializable{
    @FXML
    public AnchorPane myPersonAccountPane;
    @FXML
    public Label nameField;
    @FXML
    public Label mobileField;
    @FXML
    public Label addressField;
    @FXML
    public Label BloodgroupField;
    @FXML
    public Label measurementField;
    @FXML
    public JFXButton editButton;
    @FXML
    public JFXButton backbutton;
    public JFXButton MyRequestField;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        for (int i = 0; i < personInfoList.size(); i++) {
            if (personInfoList.get(i).getPhoneNumber_ID().equals(MyId)){
                nameField.setText(personInfoList.get(i).getName());
                mobileField.setText(personInfoList.get(i).getPhoneNumber_ID());
                addressField.setText(personInfoList.get(i).getAddress());
                BloodgroupField.setText(personInfoList.get(i).getBloodGroup());
                measurementField.setText(personInfoList.get(i).getWeight()+"");

            }
        }

    }


    public void editButtonAction(ActionEvent actionEvent) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("EditMyInfo.fxml"));
            myPersonAccountPane.getChildren().setAll(pane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void backbuttonAction(ActionEvent actionEvent) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("menuPage.fxml"));
            myPersonAccountPane.getChildren().setAll(pane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void MyRequestFieldAction(ActionEvent actionEvent) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("MyRequestList.fxml"));
            myPersonAccountPane.getChildren().setAll(pane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
