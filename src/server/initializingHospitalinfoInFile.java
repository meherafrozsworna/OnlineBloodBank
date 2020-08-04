package server;

import sample.HospitalInfo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class initializingHospitalinfoInFile {
    public static void main(String[] args) {
        // Object deserialization
        try {
            //for member info


            List<HospitalInfo> listofReqest = new ArrayList<>();
            HospitalInfo object1 = new HospitalInfo("Bangladesh-Clinic","01521259994",
                    "Jatrabari","123");

            listofReqest.add(object1);
            int[] bloodneeded = {1,2,3,4,5,6,7,8};
            int[] bloodavilable = {8,7,6,5,4,3,2,1};
            LocalDate date = LocalDate.of(2018, Month.JANUARY, 1);
            listofReqest.add(new HospitalInfo("Medinova","123546534167",
                    "Dhaka","123",bloodneeded,bloodavilable,date));
            listofReqest.add(new HospitalInfo("abc","12345",
                    "Comilla","123",bloodneeded,bloodavilable,date));

            FileOutputStream fos = new FileOutputStream("HospitalInfo");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(listofReqest);
            oos.close();
        } catch (Exception e) {
            System.out.println("Exception during serialization: " + e);
            System.exit(0);
        }
        // Object serialization
        try {
            List<HospitalInfo> member = new ArrayList<>();
            FileInputStream fis = new FileInputStream("HospitalInfo");
            ObjectInputStream ois = new ObjectInputStream(fis);
            member = (List<HospitalInfo>) ois.readObject();
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
