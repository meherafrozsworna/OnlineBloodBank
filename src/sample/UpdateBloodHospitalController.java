package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import static sample.Client.nc;
import static sample.Main.hospitalList;
import static sample.loginController.MyId;

public class UpdateBloodHospitalController implements Initializable{
    @FXML
    public AnchorPane UpadateBloodPane;
    @FXML
    public JFXTextField ApAvailableField;
    @FXML
    public JFXTextField BpAvailableField;
    @FXML
    public JFXTextField OpAvailableField;
    @FXML
    public JFXTextField ABpAvailableField;
    @FXML
    public JFXTextField BnAvailableField;
    @FXML
    public JFXTextField AnAvailableField;
    @FXML
    public JFXTextField OnAvailableField;
    @FXML
    public JFXTextField ABnAvailableField;
    @FXML
    public JFXDatePicker dateField;
    @FXML
    public JFXTextField ApNeededField;
    @FXML
    public JFXTextField BpNeededField;
    @FXML
    public JFXTextField OpNeededField;
    @FXML
    public JFXTextField ABpNeededField;
    @FXML
    public JFXTextField BnNeededField;
    @FXML
    public JFXTextField AnNeededField;
    @FXML
    public JFXTextField OnNeededField;
    @FXML
    public JFXTextField ABnNeededField;
    @FXML
    public JFXButton cancelButton;
    @FXML
    public JFXButton saveButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        for (int i = 0; i < hospitalList.size() ; i++) {
            if (hospitalList.get(i).getPhoneNumber_ID().equals(MyId)){
                int[] a = hospitalList.get(i).getBloodAvailable();
                ApAvailableField.setText(a[0]+"");
                AnAvailableField.setText(a[1]+"");
                BpAvailableField.setText(a[2]+"");
                BnAvailableField.setText(a[3]+"");
                ABpAvailableField.setText(a[4]+"");
                ABnAvailableField.setText(a[5]+"");
                OpAvailableField.setText(a[6]+"");
                OnAvailableField.setText(a[7]+"");

                int[] n = hospitalList.get(i).getBloodneeded();
                ApNeededField.setText(n[0]+"");
                AnNeededField.setText(n[1]+"");
                BpNeededField.setText(n[2]+"");
                BnNeededField.setText(n[3]+"");
                ABpNeededField.setText(n[4]+"");
                ABnNeededField.setText(n[5]+"");
                OpNeededField.setText(n[6]+"");
                OnNeededField.setText(n[7]+"");

                dateField.setValue(hospitalList.get(i).getDate());
            }
        }

    }

    public void ApAvailableFieldAction(ActionEvent actionEvent) {
    }

    public void BpAvailableFieldaction(ActionEvent actionEvent) {
    }

    public void OpAvailableFieldAction(ActionEvent actionEvent) {
    }

    public void ABpAvailableFieldAction(ActionEvent actionEvent) {
    }

    public void BnAvailableFieldAction(ActionEvent actionEvent) {
    }

    public void AnAvailableFieldAction(ActionEvent actionEvent) {
    }

    public void OnAvailableFieldAction(ActionEvent actionEvent) {
    }

    public void ABnAvailableFieldAction(ActionEvent actionEvent) {
    }

    public void ApNeededFieldAction(ActionEvent actionEvent) {
    }

    public void BpNeededFieldAction(ActionEvent actionEvent) {
    }

    public void OpNeededFieldAction(ActionEvent actionEvent) {
    }

    public void ABpNeededFieldAction(ActionEvent actionEvent) {
    }

    public void BnNeededFieldAction(ActionEvent actionEvent) {
    }

    public void AnNeededFieldAction(ActionEvent actionEvent) {
    }

    public void OnNeededFieldAction(ActionEvent actionEvent) {
    }

    public void ABnNeededFieldAction(ActionEvent actionEvent) {
    }

    public void cancelButtonAction(ActionEvent actionEvent) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("MyHospitalAccount.fxml"));
            UpadateBloodPane.getChildren().setAll(pane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void savebuttonAction(ActionEvent actionEvent) {

        int flag = 0 ;
        if (ApAvailableField.getText().isEmpty() || AnAvailableField.getText().isEmpty()
                ||BpAvailableField.getText().isEmpty() || BnAvailableField.getText().isEmpty()
                || ABpAvailableField.getText().isEmpty() || ABnAvailableField.getText().isEmpty()
                || OpAvailableField.getText().isEmpty() || OnAvailableField.getText().isEmpty()
                ||ApNeededField.getText().isEmpty() || AnNeededField.getText().isEmpty()
                ||BpNeededField.getText().isEmpty() || BnNeededField.getText().isEmpty()
                || ABpNeededField.getText().isEmpty() || ABnNeededField.getText().isEmpty()
                || OpNeededField.getText().isEmpty() || OnNeededField.getText().isEmpty()){

            flag = 1;
            AlertBox.display("Form", "Please fill up all the forms");
        }


        if (flag == 0){
            LocalDate date = dateField.getValue();
            //a+ ,a- ,b+ ,b- ,ab+ ,ab- ,o+ ,o-
            int[] available = new int[8];
            available[0] = Integer.parseInt(ApAvailableField.getText());
            available[1] = Integer.parseInt(AnAvailableField.getText());
            available[2] = Integer.parseInt(BpAvailableField.getText());
            available[3] = Integer.parseInt(BnAvailableField.getText());
            available[4] = Integer.parseInt(ABpAvailableField.getText());
            available[5] = Integer.parseInt(ABnAvailableField.getText());
            available[6] = Integer.parseInt(OpAvailableField.getText());
            available[7] = Integer.parseInt(OnAvailableField.getText());

            int[] needed = new int[8];
            needed[0] = Integer.parseInt(ApNeededField.getText());
            needed[1] = Integer.parseInt(AnNeededField.getText());
            needed[2] = Integer.parseInt(BpNeededField.getText());
            needed[3] = Integer.parseInt(BnNeededField.getText());
            needed[4] = Integer.parseInt(ABpNeededField.getText());
            needed[5] = Integer.parseInt(ABnNeededField.getText());
            needed[6] = Integer.parseInt(OpNeededField.getText());
            needed[7] = Integer.parseInt(OnNeededField.getText());


            UptadeBloodInfoHospital update = new UptadeBloodInfoHospital(MyId,date,available,needed);

            nc.write(update);

            try {
                AnchorPane pane = FXMLLoader.load(getClass().getResource("MyHospitalAccount.fxml"));
                UpadateBloodPane.getChildren().setAll(pane);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }




    }
}
