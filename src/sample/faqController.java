package sample;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class faqController {
    @FXML
    public AnchorPane faqPane;
    @FXML
    public JFXButton backButton;

    public void backButtonAction(ActionEvent actionEvent) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("menuPage.fxml"));
            faqPane.getChildren().setAll(pane);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
