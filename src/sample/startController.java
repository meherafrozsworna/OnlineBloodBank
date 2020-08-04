package sample;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class startController {


//    public Button loginbutton;
//    public Button signupButton;
    public AnchorPane rootpane;
    public JFXButton loginbutton;
    public JFXButton signupButton;

    public void loginAction(ActionEvent actionEvent) {
        try {
            System.out.println("login ");

            AnchorPane pane = FXMLLoader.load(getClass().getResource("loginPage.fxml"));

            rootpane.getChildren().setAll(pane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void signupAction(ActionEvent actionEvent) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("PersonOrHosipal.fxml"));
            rootpane.getChildren().setAll(pane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
