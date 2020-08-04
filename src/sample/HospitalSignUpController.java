package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

import static sample.Client.nc;
import static sample.Main.hospitalList;
import static sample.Main.personInfoList;
import static sample.loginController.MyId;

public class HospitalSignUpController {
    @FXML
    public AnchorPane hospitalSignUpPane;
    @FXML
    public JFXTextField nameField;
    @FXML
    public JFXTextField phoneNumberField;
    @FXML
    public JFXTextField addressField;
    @FXML
    public JFXPasswordField passwordField;
    @FXML
    public JFXPasswordField confirmPasswordField;
    @FXML
    public JFXButton saveButton;
    @FXML
    public JFXButton CancelButton;

    @FXML
    public void confirmPasswordFieldAction(ActionEvent actionEvent) {
        if (!passwordField.getText().equals(confirmPasswordField.getText())) {
            AlertBox.display("Password", "Your password  doesn't match");
        }
    }

    @FXML
    public void CancelButtonAction(ActionEvent actionEvent) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("startPage.fxml"));
            hospitalSignUpPane.getChildren().setAll(pane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void saveButtonAction(ActionEvent actionEvent) {

        /*
        public JFXTextField nameField;
    @FXML
    public JFXTextField phoneNumberField;
    @FXML
    public JFXTextField addressField;
    @FXML
    public JFXPasswordField passwordField;
    @FXML
    public JFXPasswordField confirmPasswordField;
         */
        int flag = 0;
        if (nameField.getText().isEmpty() || phoneNumberField.getText().isEmpty()
                || addressField.getText().isEmpty() || passwordField.getText().isEmpty()
                || confirmPasswordField.getText().isEmpty()) {

            flag = 1;
            AlertBox.display("Form", "Please fill up all the forms");
        } else if (!passwordField.getText().equals(confirmPasswordField.getText())) {
            flag = 1;
            AlertBox.display("Password", "Your password  doesn't match");
        } else if (true) {
            for (int i = 0; i < personInfoList.size(); i++) {
                if (phoneNumberField.getText().equals(personInfoList.get(i).getPhoneNumber_ID())) {
                    flag = 1;
                    AlertBox.display("Problem", "This mobile number has already been used");
                }

            }
            if (flag == 0) {
                for (int i = 0; i < hospitalList.size(); i++) {
                    if (phoneNumberField.getText().equals(hospitalList.get(i).getPhoneNumber_ID())) {
                        flag = 1;
                        AlertBox.display("Problem", "This mobile number has already been used");
                    }
                }
            }

        }


        if (flag==0){
            // name id  add  pass
            String name = nameField.getText();
            String id = phoneNumberField.getText();
            String address = addressField.getText();
            String password = passwordField.getText();

            HospitalInfo h = new HospitalInfo(name, id, address, password);
            nc.write(h);

            MyId = id;

            try {
                AnchorPane pane = FXMLLoader.load(getClass().getResource("menuPage.fxml"));
                hospitalSignUpPane.getChildren().setAll(pane);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public void PhoneNumberFieldAction(ActionEvent actionEvent) {
        try {
            long mobile = Integer.parseInt(phoneNumberField.getText());
        } catch (Exception e) {
            AlertBox.display("Mobile Number", "Enter a valid mobile number");
        }

        int flag = 0;
        for (int i = 0; i < personInfoList.size(); i++) {
            if (phoneNumberField.getText().equals(personInfoList.get(i).getPhoneNumber_ID())) {
                flag = 1;
                AlertBox.display("Problem", "This mobile number has already been used");
            }

        }
        if (flag == 0) {
            for (int i = 0; i < hospitalList.size(); i++) {
                if (phoneNumberField.getText().equals(hospitalList.get(i).getPhoneNumber_ID())) {
                    flag = 1;
                    AlertBox.display("Problem", "This mobile number has already been used");
                }
            }
        }

    }
}
