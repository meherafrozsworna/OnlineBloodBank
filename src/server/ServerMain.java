package server;

import sample.HospitalInfo;
import sample.MemberInfo;
import sample.RequestListInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ServerMain {

    public static List<MemberInfo> memberInfoList = new ArrayList<>();
    public static List<RequestListInfo> requestListInfoList = new ArrayList<>();
    public static List<HospitalInfo> hospitalInfoList = new ArrayList<>();

    public static void main(String[] args) {
        FileReadMemberInfoThread infoThread = new FileReadMemberInfoThread();
        ReadingRequestFromFileThread request = new ReadingRequestFromFileThread();
        HospitalinfoListFromFileThread hospitalInfo = new HospitalinfoListFromFileThread();
        try {
            infoThread.thread.join();
            request.thread.join();
            hospitalInfo.thread.join();
            for (int i = 0; i <memberInfoList.size() ; i++) {
                System.out.println(memberInfoList.get(i));
            }
            for (int i = 0; i <requestListInfoList.size() ; i++) {
                System.out.println(requestListInfoList.get(i));
            }
            System.out.println(       "list size "+hospitalInfoList.size());
            for (int i = 0; i <hospitalInfoList.size() ; i++) {
                System.out.println(hospitalInfoList.get(i));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        writingListToFileThread toFileThread = new writingListToFileThread();
        Server server = new Server();







    }
}
