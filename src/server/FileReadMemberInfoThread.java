package server;

import sample.MemberInfo;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import static server.ServerMain.memberInfoList;

public class FileReadMemberInfoThread implements  Runnable{
    Thread thread;

    FileReadMemberInfoThread(){
        thread = new Thread(this);
        thread.start();
    }
    @Override
    public void run() {
        // Object serialization
        try {
            FileInputStream fis = new FileInputStream("PersonInfo");
            ObjectInputStream ois = new ObjectInputStream(fis);
            memberInfoList = (List<MemberInfo>) ois.readObject();
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
