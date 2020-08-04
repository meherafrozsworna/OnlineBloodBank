package sample;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static sample.Main.hospitalList;
import static sample.loginController.MyId;
import static sample.loginController.type;

public class MyHospitalController implements Initializable{
    public AnchorPane myHospitalAccountPane;
    public Label nameField;
    public Label addressField;
    public Label numberField;
    public JFXButton backButton;
    public JFXButton updateButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        for (int i = 0; i < hospitalList.size() ; i++) {
            if (hospitalList.get(i).getPhoneNumber_ID().equals(MyId)){
                nameField.setText(hospitalList.get(i).getName());
                addressField.setText(hospitalList.get(i).getAddress());
                numberField.setText(hospitalList.get(i).getPhoneNumber_ID());

            }

        }
    }

    public void backButtonAction(ActionEvent actionEvent) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("menuPage.fxml"));
            myHospitalAccountPane.getChildren().setAll(pane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updateButtonAction(ActionEvent actionEvent) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("UpdateBloodHospital.fxml"));
            myHospitalAccountPane.getChildren().setAll(pane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
