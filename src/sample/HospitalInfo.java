package sample;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;

public class HospitalInfo implements Serializable {
    private String name ;
    private String PhoneNumber_ID;
    private String address ;
    private String password ;
    private int[] bloodneeded = new int[8];
    //a+ ,a- ,b+ ,b- ,ab+ ,ab- ,o+ ,o-
    private int[] bloodAvailable =new int[8];
    private LocalDate date ;
    public HospitalInfo() {
    }

    public HospitalInfo(String name, String phoneNumber_ID, String address, String password) {
        this.name = name;
        PhoneNumber_ID = phoneNumber_ID;
        this.address = address;
        this.password = password;
        this.date = LocalDate.of(2000, Month.JANUARY, 1);
    }

    public HospitalInfo(String name, String phoneNumber_ID, String address,
                        String password, int[] bloodneeded, int[] bloodAvailable, LocalDate date) {
        this.name = name;
        PhoneNumber_ID = phoneNumber_ID;
        this.address = address;
        this.password = password;
        this.bloodneeded = bloodneeded;
        this.bloodAvailable = bloodAvailable;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber_ID() {
        return PhoneNumber_ID;
    }

    public void setPhoneNumber_ID(String phoneNumber_ID) {
        PhoneNumber_ID = phoneNumber_ID;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int[] getBloodneeded() {
        return bloodneeded;
    }

    public void setBloodneeded(int[] bloodneeded) {
        this.bloodneeded = bloodneeded;
    }

    public int[] getBloodAvailable() {
        return bloodAvailable;
    }

    public void setBloodAvailable(int[] bloodAvailable) {
        this.bloodAvailable = bloodAvailable;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "HospitalInfo{" +
                "name='" + name + '\'' +
                ", PhoneNumber_ID='" + PhoneNumber_ID + '\'' +
                ", address='" + address + '\'' +
                ", password='" + password + '\'' +
                ", bloodneeded=" + Arrays.toString(bloodneeded) +
                ", bloodAvailable=" + Arrays.toString(bloodAvailable) +
                ", date=" + date +
                '}';
    }

    public String hospitalInfo(){
        return (name+","+PhoneNumber_ID+","+address+","+password);
    }
}
