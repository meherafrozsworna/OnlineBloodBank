package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static sample.Client.nc;
import static sample.Main.requestList;
import static sample.loginController.MyId;

public class RequestListController implements Initializable{
    @FXML
    public AnchorPane RequestListPane;
    @FXML
    public JFXButton backButton;
    @FXML
    public ComboBox BloodGroupField;
    @FXML
    public TableView<RequestListInfo> tableField;
    @FXML
    public TableColumn<RequestListInfo,String> nameField;
    @FXML
    public TableColumn<RequestListInfo,String> mobileField;
    @FXML
    public TableColumn addressfield;
//    public JFXButton deleteButton;
//    public JFXComboBox DeleteBloodGrp;

    ObservableList<String> bloodGrpList3 = FXCollections.
            observableArrayList("O+","O-","A+","A-","B+","B-","AB+","AB-");

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //for list combo Box
        BloodGroupField.setValue("O+");
        BloodGroupField.setItems(bloodGrpList3);

        //for BloodGrp delete list
//        DeleteBloodGrp.setValue("O+");
//        DeleteBloodGrp.setItems(bloodGrpList3);

        //table view
        nameField.setCellValueFactory(new PropertyValueFactory<RequestListInfo, String>("name"));
        mobileField.setCellValueFactory(new PropertyValueFactory<RequestListInfo, String>("mobile"));
        addressfield.setCellValueFactory(new PropertyValueFactory<RequestListInfo, String>("address"));

        tableField.setItems(getMember());


    }

    public void BloodGroupSelectAction(ActionEvent actionEvent) {

        nameField.setCellValueFactory(new PropertyValueFactory<RequestListInfo, String>("name"));
        mobileField.setCellValueFactory(new PropertyValueFactory<RequestListInfo, String>("mobile"));
        addressfield.setCellValueFactory(new PropertyValueFactory<RequestListInfo, String>("address"));

        tableField.setItems(getMember());


    }

    public void backButtonAction(ActionEvent actionEvent) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("menuPage.fxml"));
            RequestListPane.getChildren().setAll(pane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ObservableList<RequestListInfo>  getMember()
    {
        String blood = (String) BloodGroupField.getValue();
        ObservableList<RequestListInfo> people = FXCollections.observableArrayList();
        for (int i = 0; i < requestList.size() ; i++) {
            if (requestList.get(i).getBloodGroup().equals(blood)){
                people.add(requestList.get(i));
            }
        }
        return people;

    }

}
