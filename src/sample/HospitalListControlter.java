package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
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

import static sample.Main.hospitalList;

public class HospitalListControlter implements Initializable{
    @FXML
    public AnchorPane HospitalListpane;
    @FXML
    public JFXButton detailsButton;
    @FXML
    public JFXButton backButton;
    @FXML
    public JFXListView hospitalListField;

    ObservableList<String> hospital = FXCollections.
            observableArrayList();

    static String hospitalSearchId;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        for (int i = 0; i < hospitalList.size(); i++) {
            hospital.add(hospitalList.get(i).getName()+"("+hospitalList.get(i).getAddress()+
                    ","+hospitalList.get(i).getPhoneNumber_ID()+")");
            //hospital.add(hospitalList.get(i));
        }
        hospitalListField.setItems(hospital);


    }

    public void detailsButtonAction(ActionEvent actionEvent) {

        String string = (String) hospitalListField.getSelectionModel().getSelectedItem();
        String[] strings = string.split(",");
        int length = strings[strings.length-1].length();
        hospitalSearchId = strings[strings.length-1].substring(0,length-1);
        System.out.println(hospitalSearchId);

        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("Hospitaldetails.fxml"));
            HospitalListpane.getChildren().setAll(pane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void backButtonAction(ActionEvent actionEvent) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("menuPage.fxml"));
            HospitalListpane.getChildren().setAll(pane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
