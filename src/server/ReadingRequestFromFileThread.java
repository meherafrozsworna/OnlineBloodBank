package server;

import sample.RequestListInfo;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.List;
import static server.ServerMain.requestListInfoList;

public class ReadingRequestFromFileThread implements Runnable{
    Thread thread;

    ReadingRequestFromFileThread(){
        thread = new Thread(this);
        thread.start();
    }
    @Override
    public void run() {
        // Object serialization
        try {
            FileInputStream fis = new FileInputStream("RequestListFile");
            ObjectInputStream ois = new ObjectInputStream(fis);
            requestListInfoList = (List<RequestListInfo>) ois.readObject();
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
