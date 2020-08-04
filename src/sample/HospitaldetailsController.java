package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static sample.HospitalListControlter.hospitalSearchId;
import static sample.Main.hospitalList;

public class HospitaldetailsController implements Initializable{
    @FXML
    public AnchorPane Hospitaldetailspane;
    @FXML
    public Label nameHosField;
    @FXML
    public Label addressField;
    @FXML
    public Label MobileField;
    @FXML
    public JFXButton backbutton;
    @FXML
    public Label ApAvailableField;
    @FXML
    public Label BpAvailableField;
    @FXML
    public Label ABpAvailableField;
    @FXML
    public Label OpAvailableField;
    @FXML
    public Label AnAvailableField;
    @FXML
    public Label BnAvailableField;
    @FXML
    public Label ABnAvailableField;
    @FXML
    public Label OnAvailableField;
    @FXML
    public Label ApNeeded;
    @FXML
    public Label BpNeeded;
    @FXML
    public Label ABpNeeded;
    @FXML
    public Label OpNeeded;
    @FXML
    public Label AnNeeded;
    @FXML
    public Label BnNeeded;
    @FXML
    public Label ABnNeeded;
    @FXML
    public Label Onneeded;
    @FXML
    public Label dateField;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //hospitalSearchId
               // hospitalList
        for (int i = 0; i < hospitalList.size(); i++) {
            if (hospitalList.get(i).getPhoneNumber_ID().equals(hospitalSearchId)){
                nameHosField.setText(hospitalList.get(i).getName());
                MobileField.setText(hospitalList.get(i).getPhoneNumber_ID());
                addressField.setText(hospitalList.get(i).getAddress());
                dateField.setText(hospitalList.get(i).getDate().toString());

                int[] available = hospitalList.get(i).getBloodAvailable();
                ApAvailableField.setText(available[0]+"");
                AnAvailableField.setText(available[1]+"");
                BpAvailableField.setText(available[2]+"");
                BnAvailableField.setText(available[3]+"");
                ABpAvailableField.setText(available[4]+"");
                ABnAvailableField.setText(available[5]+"");
                OpAvailableField.setText(available[6]+"");
                OnAvailableField.setText(available[7]+"");

                int[] need = hospitalList.get(i).getBloodneeded();
                ApNeeded.setText(need[0]+"");
                AnNeeded.setText(need[1]+"");
                BpNeeded.setText(need[2]+"");
                BnNeeded.setText(need[3]+"");
                ABpNeeded.setText(need[4]+"");
                ABnNeeded.setText(need[5]+"");
                OpNeeded.setText(need[6]+"");
                Onneeded.setText(need[7]+"");
            }
        }
    }

    public void backButtonAction(ActionEvent actionEvent) {

        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("HospitalList.fxml"));
            Hospitaldetailspane.getChildren().setAll(pane);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
