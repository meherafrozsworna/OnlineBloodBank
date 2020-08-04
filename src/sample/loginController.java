package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

import static sample.Main.hospitalList;
import static sample.Main.personInfoList;

public class loginController {
    public AnchorPane loginScene;
    public JFXButton loginAccountButton;
    public JFXButton backButton;
    public JFXTextField phoneNumberField;
    public JFXPasswordField passwordField;
    public static String MyId;
    public static String type="";

    public void loginAccountAction(ActionEvent actionEvent) {
        try {

            MyId = "";

            MyId = phoneNumberField.getText();
            String password = passwordField.getText();
            for (int i = 0; i < personInfoList.size(); i++) {
                if (personInfoList.get(i).getPhoneNumber_ID().equals(MyId)
                        && personInfoList.get(i).getPassword().equals(password)){

                    type = "person";
                    AnchorPane pane = FXMLLoader.load(getClass().getResource("menuPage.fxml"));
                    loginScene.getChildren().setAll(pane);

                }
            }
                for (int i = 0; i < hospitalList.size(); i++) {
                    if (hospitalList.get(i).getPhoneNumber_ID().equals(MyId)
                            && hospitalList.get(i).getPassword().equals(password)){

                        type = "hospital";
                        AnchorPane pane = FXMLLoader.load(getClass().getResource("menuPage.fxml"));
                        loginScene.getChildren().setAll(pane);

                    }
                }





        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void backButtonAction(ActionEvent actionEvent) {
        try {
            System.out.println("back ");

            AnchorPane pane = FXMLLoader.load(getClass().getResource("startPage.fxml"));

            loginScene.getChildren().setAll(pane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
