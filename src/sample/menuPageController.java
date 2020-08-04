package sample;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import java.awt.*;
import java.net.URI;

import java.awt.*;
import java.io.IOException;
import java.net.URI;

import static sample.Main.hospitalList;
import static sample.Main.personInfoList;
import static sample.loginController.MyId;
import static sample.loginController.type;

public class menuPageController {

    public AnchorPane menupane;
    public JFXButton searchButton;
    public JFXButton requestlistButton;
    public JFXButton addrequestButton;
    public JFXButton adminbutton;
    public JFXButton FAQButton;
    public JFXButton hospitalButton;
    public JFXButton Myacountbutton;
    public JFXButton logoutButton;
    public JFXButton mapField;
//    public AnchorPane menupane;
//    public Button searchButton;
//    public Button requestlistButton;
//    public Button addrequestButton;
//    public Button hospitalButton;
//    public Button FAQButton;
//    public Button adminbutton;
//    public Button Myacountbutton;
//    public Button logoutButton;

    public void searchButtonAction(ActionEvent actionEvent) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("listOfUser.fxml"));
            menupane.getChildren().setAll(pane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void requestlistButtonAction(ActionEvent actionEvent) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("RequestList.fxml"));
            menupane.getChildren().setAll(pane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addrequestButtonAction(ActionEvent actionEvent) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("addRequest.fxml"));
            menupane.getChildren().setAll(pane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void hospitalButtonAction(ActionEvent actionEvent) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("HospitalList.fxml"));
            menupane.getChildren().setAll(pane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void FAQButtonAction(ActionEvent actionEvent) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("faq.fxml"));
            menupane.getChildren().setAll(pane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void adminButtonAction(ActionEvent actionEvent) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("adminpage.fxml"));
            menupane.getChildren().setAll(pane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void AccountPageAction(ActionEvent actionEvent) {
        for (int i = 0; i < personInfoList.size() ; i++) {
            if ( personInfoList.get(i).getPhoneNumber_ID().equals(MyId)){
                try {
                    System.out.println("person");
                    AnchorPane pane = FXMLLoader.load(getClass().getResource("MyPersonAccount.fxml"));
                    menupane.getChildren().setAll(pane);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        for (int i = 0; i < hospitalList.size() ; i++) {
            if ( hospitalList.get(i).getPhoneNumber_ID().equals(MyId)){
                System.out.println("hospital");
                try {
                    AnchorPane pane = FXMLLoader.load(getClass().getResource("MyHospitalAccount.fxml"));
                    menupane.getChildren().setAll(pane);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public void logoutButtonAction(ActionEvent actionEvent) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("startPage.fxml"));
            menupane.getChildren().setAll(pane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void MapFieldAction(ActionEvent actionEvent) throws Exception {
        Desktop d = Desktop.getDesktop();
        d.browse(new URI("https://www.google.com.bd/maps?source=tldsi&hl=en"));
    }
}
