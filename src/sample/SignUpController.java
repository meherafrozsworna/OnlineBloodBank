package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static sample.Client.nc;
import static sample.Main.hospitalList;
import static sample.Main.personInfoList;
import static sample.loginController.MyId;

public class SignUpController implements Initializable {
    public AnchorPane SignpagePane;
    public JFXTextField weightField;
    public JFXTextField AddressField;
    public JFXTextField mobileNumberField;
    public JFXTextField nameFild;
    public JFXPasswordField passwordField;
    public JFXPasswordField ConfirmPassword;
    public JFXComboBox BloodGroupField;
    public JFXComboBox Genderfield;
    public JFXButton saveButton;
    public JFXButton cancelButton;
    public JFXTextField MailField;

    ObservableList<String> bloodGrpList2 = FXCollections.
            observableArrayList("O+", "O-", "A+", "A-", "B+", "B-", "AB+", "AB-");
    ObservableList<String> genderList = FXCollections.
            observableArrayList("Male", "Female");

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        BloodGroupField.setValue("O+");
        BloodGroupField.setItems(bloodGrpList2);
        Genderfield.setValue("Male");
        Genderfield.setItems(genderList);
    }

    public void cancelButtonAction(ActionEvent actionEvent) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("startPage.fxml"));
            SignpagePane.getChildren().setAll(pane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveButtonAction(ActionEvent actionEvent) {
        try {

            int flag = 0;
            if (mobileNumberField.getText().isEmpty() || weightField.getText().isEmpty()
                    || nameFild.getText().isEmpty() || passwordField.getText().isEmpty()
                    || ((String) BloodGroupField.getValue()).isEmpty() ||
                    ((String) Genderfield.getValue()).isEmpty() || ConfirmPassword.getText().isEmpty()) {

                flag = 1 ;
                AlertBox.display("Form", "Please fill up all the forms");
            }else if (!passwordField.getText().equals(ConfirmPassword.getText())) {
                flag = 1;
                AlertBox.display("Password", "Your password  doesn't match");
            }
            else if (true) {
                for (int i = 0; i < personInfoList. size(); i++) {
                    if (mobileNumberField.getText().equals(personInfoList.get(i).getPhoneNumber_ID())){
                        flag = 1;
                        AlertBox.display("Problem", "This mobile number has already been used");
                    }

                }
                if (flag == 0){
                    for (int i = 0; i < hospitalList.size() ; i++) {
                        if (mobileNumberField.getText().equals(hospitalList.get(i).getPhoneNumber_ID())){
                            flag = 1 ;
                            AlertBox.display("Problem", "This mobile number has already been used");
                        }
                    }
                }
            }
            if (flag == 0){

                String mobile = mobileNumberField.getText();
                int weight = Integer.parseInt(weightField.getText());
                String address = AddressField.getText();
                String name = nameFild.getText();
                String password = passwordField.getText();
                String bloodgrp = (String) BloodGroupField.getValue();
                String gender = (String) Genderfield.getValue();
                String mail = MailField.getText();

                MemberInfo m = new MemberInfo(mobile, name, address, bloodgrp, gender, weight, password,mail);

                //writing object
                nc.write(m);

                MyId = mobile;
                AnchorPane pane = FXMLLoader.load(getClass().getResource("menuPage.fxml"));
                SignpagePane.getChildren().setAll(pane);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void confirmPasswordAction(ActionEvent actionEvent) {
        if (!passwordField.getText().equals(ConfirmPassword.getText())) {
            AlertBox.display("Password", "Your password  doesn't match");
         }
    }

    public void mobileNumberAction(ActionEvent actionEvent) {
        try {
            long mobile = Integer.parseInt(mobileNumberField.getText());
        } catch (Exception e) {
            AlertBox.display("Mobile Number", "Enter a valid mobile number");
        }

        int flag = 0;
        for (int i = 0; i < personInfoList.size(); i++) {
            if (mobileNumberField.getText().equals(personInfoList.get(i).getPhoneNumber_ID())) {
                flag = 1;
                AlertBox.display("Problem", "This mobile number has already been used");
            }

        }
        if (flag == 0) {
            for (int i = 0; i < hospitalList.size(); i++) {
                if (mobileNumberField.getText().equals(hospitalList.get(i).getPhoneNumber_ID())) {
                    flag = 1;
                    AlertBox.display("Problem", "This mobile number has already been used");
                }
            }
        }


    }

    public void weightFieldAction(ActionEvent actionEvent) {
        try {
            long mobile = Integer.parseInt(mobileNumberField.getText());
        } catch (Exception e) {
            AlertBox.display("Weight", "Enter a valid weight");
        }
    }

    public void mailAction(ActionEvent actionEvent) {

    }
}