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
import static sample.Main.hospitalList;
import static sample.Main.personInfoList;
import static sample.loginController.MyId;

public class editMyInfoController implements Initializable{
    @FXML
    public AnchorPane editPane;
    @FXML
    public JFXTextField nameField;
    @FXML
    public JFXTextField addressField;
    @FXML
    public JFXTextField mobileField;
    @FXML
    public JFXTextField measurementField;
    @FXML
    public JFXComboBox bloodgrpField;
    @FXML
    public JFXButton saveButton;
    @FXML
    public JFXButton cancelButton;

    ObservableList<String> bloodGrpList2 = FXCollections.
            observableArrayList("O+","O-","A+","A-","B+","B-","AB+","AB-");
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        bloodgrpField.setItems(bloodGrpList2);

        for (int i = 0; i < personInfoList.size(); i++) {
            if (personInfoList.get(i).getPhoneNumber_ID().equals(MyId)){
                nameField.setText(personInfoList.get(i).getName());
                addressField.setText(personInfoList.get(i).getAddress());
                mobileField.setText(personInfoList.get(i).getPhoneNumber_ID());
                measurementField.setText(personInfoList.get(i).getWeight()+"");
                bloodgrpField.setValue(personInfoList.get(i).getBloodGroup());
            }
        }
    }

    public void saveButtonAction(ActionEvent actionEvent) {

        int flag = 0;
        if (nameField.getText().isEmpty() || addressField.getText().isEmpty() ||
                mobileField.getText().isEmpty() || measurementField.getText().isEmpty() ||
                ((String) bloodgrpField.getValue()).isEmpty()){
            flag = 1 ;
            AlertBox.display("Form", "Please fill up all the forms");
        }


        if (flag== 0){
            String name = nameField.getText();
            String address = addressField.getText();
            String mobile = mobileField.getText();
            int  weight = Integer.parseInt(measurementField.getText());
            String blood = (String) bloodgrpField.getValue();

            EditMyPersonInfo edit = new EditMyPersonInfo(mobile,name,address,blood,weight);
            nc.write(edit);

            try {
                AnchorPane pane = FXMLLoader.load(getClass().getResource("MyPersonAccount.fxml"));
                editPane.getChildren().setAll(pane);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    public void cancelButtonAction(ActionEvent actionEvent) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("MyPersonAccount.fxml"));
            editPane.getChildren().setAll(pane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
