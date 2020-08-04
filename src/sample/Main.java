package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class Main extends Application {
    public static List<MemberInfo> personInfoList = new ArrayList<MemberInfo>();
    public static List<RequestListInfo> requestList = new ArrayList<>();
    public static List<HospitalInfo> hospitalList = new ArrayList<>();

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("startPage.fxml"));
        primaryStage.setTitle("Online Blood Bank");

        primaryStage.setScene(new Scene(root, 600, 600));
        primaryStage.show();
    }


    public static void main(String[] args) {
        String serverAddress = "127.0.0.1";
        int serverPort = 33333;
        Client c = new Client(serverAddress,serverPort);

        try {
            Thread.sleep(1000);
            System.out.println(personInfoList.size());
            for (int i = 0; i < personInfoList.size() ; i++) {
                System.out.println(personInfoList.get(i));
                System.out.println("address"+personInfoList.get(i));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        launch(args);



    }
}
