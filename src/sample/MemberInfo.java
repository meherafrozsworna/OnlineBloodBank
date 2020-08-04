package sample;

import java.io.Serializable;

public class MemberInfo implements Serializable{
    //public static List<MemberInfo> Infolist ;


    private String phoneNumber_ID ;
    private String name ="";
    private String address = "" ;
    private String bloodGroup ;
    private String gender;
    private int weight ;
    private String password ;
    private String mail ;

    public MemberInfo() {
    }

    public MemberInfo(String phoneNumber_ID, String name, String address,
                      String bloodGroup, String gender, int weight, String password, String mail) {
        this.phoneNumber_ID = phoneNumber_ID;
        this.name = name;
        this.address = address;
        this.bloodGroup = bloodGroup;
        this.gender = gender;
        this.weight = weight;
        this.password = password;
        this.mail = mail;
    }

    public MemberInfo(String phoneNumber_ID, String name, String address, String bloodGroup,
                      String gender, int weight, String password) {
        this.phoneNumber_ID = phoneNumber_ID;
        this.name = name;
        this.address = address;
        this.bloodGroup = bloodGroup;
        this.gender = gender;
        this.weight = weight;
        this.password = password;
    }

    public String getPhoneNumber_ID() {
        return phoneNumber_ID;
    }

    public void setPhoneNumber_ID(String phoneNumber_ID) {
        this.phoneNumber_ID = phoneNumber_ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public String toString() {
        return "MemberInfo{" +
                "phoneNumber_ID='" + phoneNumber_ID + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", bloodGroup='" + bloodGroup + '\'' +
                ", gender='" + gender + '\'' +
                ", weight=" + weight +
                ", password='" + password + '\'' +
                ", mail='" + mail + '\'' +
                '}';
    }

    public String info(){
        return (phoneNumber_ID+","+name+","+address+","+bloodGroup+","+gender+","+weight+","+password);
    }

}
