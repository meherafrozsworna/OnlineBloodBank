package sample;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class adminPageController {
    public AnchorPane Adminpane;
    public JFXButton menuBackButton;

    public void menuBackButtonAction(ActionEvent actionEvent) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("menuPage.fxml"));
            Adminpane.getChildren().setAll(pane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
