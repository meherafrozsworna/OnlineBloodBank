package sample;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class PersonOrHosipalController {
    public AnchorPane PersonHospitalPane;
    public JFXButton personButton;
    public JFXButton hospitalButton;
    public JFXButton backButton;

    public void backButtonAction(ActionEvent actionEvent) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("startPage.fxml"));
            PersonHospitalPane.getChildren().setAll(pane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void hospitalButtonAction(ActionEvent actionEvent) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("HospitalSignUp.fxml"));
            PersonHospitalPane.getChildren().setAll(pane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void personButtonAction(ActionEvent actionEvent) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("SignUpPage.fxml"));
            PersonHospitalPane.getChildren().setAll(pane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
