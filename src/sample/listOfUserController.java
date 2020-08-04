package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static sample.Main.personInfoList;

public class listOfUserController implements Initializable{
    /*
     //configure the table
    @FXML private TableView<Person> tableView;
    @FXML private TableColumn<Person, String> firstNameColumn;
    @FXML private TableColumn<Person, String> lastNameColumn;
    @FXML private TableColumn<Person, LocalDate> birthdayColumn;
     */
    @FXML
    public AnchorPane listPane;
    @FXML
    public JFXComboBox bloodgrpField;
    @FXML
    public TableView<MemberInfo> table;
    @FXML
    public TableColumn<MemberInfo,String> nameField;
    @FXML
    public TableColumn<MemberInfo,String> genderField;
    @FXML
    public TableColumn<MemberInfo,String> weightField;
    @FXML
    public TableColumn<MemberInfo,String> mobileField;
    @FXML
    public TableColumn<MemberInfo,String> addressField;
    @FXML
    public JFXButton backButton;

    ObservableList<String> bloodGrpList3 = FXCollections.
            observableArrayList("O+","O-","A+","A-","B+","B-","AB+","AB-");


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //for list combo Box
        bloodgrpField.setValue("O+");
        bloodgrpField.setItems(bloodGrpList3);

        /*
        //set up the columns in the table
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("firstName"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("lastName"));
        birthdayColumn.setCellValueFactory(new PropertyValueFactory<Person, LocalDate>("birthday"));

        //load dummy data
        tableView.setItems(getPeople());

         */
        nameField.setCellValueFactory(new PropertyValueFactory<MemberInfo, String>("name"));
        genderField.setCellValueFactory(new PropertyValueFactory<MemberInfo, String>("gender"));
        weightField.setCellValueFactory(new PropertyValueFactory<MemberInfo, String>("weight"));
        mobileField.setCellValueFactory(new PropertyValueFactory<MemberInfo, String>("phoneNumber_ID"));
        addressField.setCellValueFactory(new PropertyValueFactory<MemberInfo, String>("address"));

        table.setItems(getMember());

    }

    @FXML
    public void BloodGrpAction(ActionEvent actionEvent) {

        nameField.setCellValueFactory(new PropertyValueFactory<MemberInfo, String>("name"));
        genderField.setCellValueFactory(new PropertyValueFactory<MemberInfo, String>("gender"));
        weightField.setCellValueFactory(new PropertyValueFactory<MemberInfo, String>("weight"));
        mobileField.setCellValueFactory(new PropertyValueFactory<MemberInfo, String>("phoneNumber_ID"));
        addressField.setCellValueFactory(new PropertyValueFactory<MemberInfo, String>("address"));

        table.setItems(getMember());
    }

    @FXML
    public void backButtonAction(ActionEvent actionEvent) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("menuPage.fxml"));
            listPane.getChildren().setAll(pane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ObservableList<MemberInfo>  getMember()
    {
      String bloodgrp = (String) bloodgrpField.getValue();

        ObservableList<MemberInfo> people = FXCollections.observableArrayList();
        for (int i = 0; i < personInfoList.size(); i++) {
            if (personInfoList.get(i).getBloodGroup().equals(bloodgrp)){
                people.add(personInfoList.get(i));
            }
        }
//        for (int i = 0; i < personInfoList.size() ; i++) {
//            people.add(personInfoList.get(i));
//        }
        return people;
    }
}
