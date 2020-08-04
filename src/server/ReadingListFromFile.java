package server;

import sample.MemberInfo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ReadingListFromFile {
    public static void main(String[] args) {
        // Object deserialization
        try {
            //for member info

            List<MemberInfo> listOfPerson = new ArrayList<>();
            MemberInfo object1 = new MemberInfo("01521259993","sworna",
                    "Jatrabari","O+","female",55,
                    "123","meherafroz6331@gmail.com");
            listOfPerson.add(object1);
            listOfPerson.add(new MemberInfo("01521259992","monica",
                    "Dhaka","O+","female",23,"123",
                    "sifatibna.amin9@gmail.com"));
            listOfPerson.add(new MemberInfo("01733573446","Benoy",
                    "Jatrabari","O+","male",23,"123",
                    "meherafroz6331@gmail.com"));

            FileOutputStream fos = new FileOutputStream("PersonInfo");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(listOfPerson);
            oos.close();
        } catch (Exception e) {
            System.out.println("Exception during serialization: " + e);
            System.exit(0);
        }
        // Object serialization
        try {
            List<MemberInfo> member = new ArrayList<>();
            FileInputStream fis = new FileInputStream("PersonInfo");
            ObjectInputStream ois = new ObjectInputStream(fis);
            member = (List<MemberInfo>) ois.readObject();
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
