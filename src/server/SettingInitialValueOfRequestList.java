package server;

import sample.RequestListInfo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class SettingInitialValueOfRequestList {
    public static void main(String[] args) {
        // Object deserialization
        try {
            //for member info

            List<RequestListInfo> listofReqest = new ArrayList<>();
            RequestListInfo object1 = new RequestListInfo("sworna","01521259994",
                    "Jatrabari","O+","01521259994");

            listofReqest.add(object1);
            listofReqest.add(new RequestListInfo("monica","01521259997",
                    "Dhaka","O-","01521259997"));
            listofReqest.add(new RequestListInfo("lucky","01733573440",
                    "Uttara","B-","01733573440"));
            FileOutputStream fos = new FileOutputStream("RequestListFile");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(listofReqest);
            oos.close();
        } catch (Exception e) {
            System.out.println("Exception during serialization: " + e);
            System.exit(0);
        }
        // Object serialization
        try {
            List<RequestListInfo> member = new ArrayList<>();
            FileInputStream fis = new FileInputStream("RequestListFile");
            ObjectInputStream ois = new ObjectInputStream(fis);
            member = (List<RequestListInfo>) ois.readObject();
            ois.close();
            for (int i = 0; i < member.size() ; i++) {
                System.out.println(member.get(i));
            }
        } catch (Exception e) {
            System.out.println("Exception during deserialization: " + e);
            System.exit(0);
        }
    }
}
