package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ResourceBundle;

import static sample.Client.nc;
import static sample.Main.requestList;
import static sample.loginController.MyId;

public class MyRequestListController implements Initializable{
    public AnchorPane MyRequestList;
    public JFXListView listField;
    public JFXButton DeleteButton;
    public JFXButton BackButton;

    ObservableList<String> request = FXCollections.
            observableArrayList();
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        for (int i = 0; i < requestList.size(); i++) {
            if (requestList.get(i).getFromWhichIdRequestCome().equals(MyId)){
                request.add(requestList.get(i).info());
            }

        }
        listField.setItems(request);

    }

    public void DeleteButtonAction(ActionEvent actionEvent) {

//        String name, String mobile,
//        String address, String bloodGroup, String fromWhichIdRequestCome)

        //name+","+mobile+","+address+","+bloodGroup;
        //return  name+","+mobile+","+address+","+bloodGroup;

        try {
            String string = (String) listField.getSelectionModel().getSelectedItem();
            String[] info = string.split(",");
            System.out.println(string);
            System.out.println(info.length);
            for (int i = 0; i < info.length; i++) {

                System.out.println(info[i]);
            }
            String name = info[0];
            String mobile = info[1];
            String address = info[2];
            String bloodGroup = info[3];
            DeleteRequest d = new DeleteRequest(name,mobile,address,bloodGroup,MyId);

            nc.write(d);
        } catch (Exception e) {

            // Answer:
            e.printStackTrace();
        }

    }

    public void BackButtonAction(ActionEvent actionEvent) {

        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("MyPersonAccount.fxml"));
            MyRequestList.getChildren().setAll(pane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
