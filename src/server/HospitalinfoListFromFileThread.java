package server;

import sample.HospitalInfo;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.List;

import static server.ServerMain.hospitalInfoList;

public class HospitalinfoListFromFileThread implements Runnable {
    public Thread thread;


    HospitalinfoListFromFileThread() {
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        // Object serialization
        try {
            FileInputStream fis = new FileInputStream("HospitalInfo");
            ObjectInputStream ois = new ObjectInputStream(fis);
            hospitalInfoList = (List<HospitalInfo>) ois.readObject();
            ois.close();
//            for (int i = 0; i < memberInfoList.size() ; i++) {
//                System.out.println(memberInfoList.get(i));
//            }
        } catch (Exception e) {
            System.out.println("Exception during deserialization: " + e);
            System.exit(0);
        }
    }
}