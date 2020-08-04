package server;

import sample.MemberInfo;

import java.io.*;
import java.util.List;
import java.util.Scanner;

import static server.ServerMain.hospitalInfoList;
import static server.ServerMain.memberInfoList;
import static server.ServerMain.requestListInfoList;

public class writingListToFileThread implements Runnable {
    Thread thread;

    writingListToFileThread(){
        thread = new Thread(this);
        thread.start();
    }
    @Override
    public void run() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter 1 to exit and save fie  :");
        int choice = -1 ;
        while (choice!= 1){
            try {
                choice = scanner.nextInt();
            }catch (Exception e){
                choice = -1 ;
            }

        }
        if (choice== 1){
            // Object serialization
            ObjectOutputStream oos = null;
            try {

                FileOutputStream fos = new FileOutputStream("PersonInfo");
                oos = new ObjectOutputStream(fos);
                oos.writeObject(memberInfoList);

            } catch (Exception e) {
                System.out.println("Exception during deserialization: " + e);
                System.exit(0);
            }finally {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


            //for request list
            ObjectOutputStream oos2 = null;
            try {

                FileOutputStream fos2 = new FileOutputStream("RequestListFile");
                oos2 = new ObjectOutputStream(fos2);
                oos2.writeObject(requestListInfoList);

            } catch (Exception e) {
                System.out.println("Exception during deserialization: " + e+"\n"+"In requestwriting");
                System.exit(0);
            }finally {
                try {
                    oos2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


            //for hospital list
            ObjectOutputStream oos3 = null;
            try {

                FileOutputStream fos3 = new FileOutputStream("hospitalInfo");
                oos3 = new ObjectOutputStream(fos3);
                oos3.writeObject(hospitalInfoList);

            } catch (Exception e) {
                System.out.println("Exception during deserialization: " + e+"\n"+"In hositalInfo_writing");
                System.exit(0);
            }finally {
                try {
                    oos3.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


        }






    }
}
