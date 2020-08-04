package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static sample.Client.nc;
import static sample.loginController.MyId;

public class addRequestControl implements Initializable{
    @FXML
    public AnchorPane RequestPane;
    @FXML
    public JFXButton sendButtonField;
    @FXML
    public JFXButton CancelButton;
    @FXML
    public JFXTextField nameFild;
    @FXML
    public JFXTextField mobileField;
    @FXML
    public JFXTextField addressField;
    @FXML
    public JFXComboBox bloodGroupField;

    ObservableList<String> bloodGrpList = FXCollections.
            observableArrayList("O+","O-","A+","A-","B+","B-","AB+","AB-");

    @FXML
    public void cancelButtonAction(ActionEvent actionEvent) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("menuPage.fxml"));
            RequestPane.getChildren().setAll(pane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void sendButtonAction(ActionEvent actionEvent) {
        try {
            /*
            public JFXTextField nameFild;
    @FXML
    public JFXTextField mobileField;
    @FXML
    public JFXTextField addressField;
    @FXML
    public JFXComboBox bloodGroupField;
             */

            String name = nameFild.getText();
            String mobile = mobileField.getText();
            String address = addressField.getText();
            String blood = (String) bloodGroupField.getValue();

            //sending object to network
            RequestListInfo r = new RequestListInfo(name,mobile,address,blood,MyId);
            nc.write(r);

            AnchorPane pane = FXMLLoader.load(getClass().getResource("menuPage.fxml"));
            RequestPane.getChildren().setAll(pane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        bloodGroupField.setValue("O+");
        bloodGroupField.setItems(bloodGrpList);

    }
}
