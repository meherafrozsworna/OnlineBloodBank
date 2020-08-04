package sample;

import java.io.Serializable;

public class EditMyPersonInfo implements Serializable {

    private String phoneNumber_ID ;
    private String name ="";
    private String address = "" ;
    private String bloodGroup ;
    private int weight ;

    public EditMyPersonInfo(String phoneNumber_ID, String name,
                            String address, String bloodGroup, int weight) {
        this.phoneNumber_ID = phoneNumber_ID;
        this.name = name;
        this.address = address;
        this.bloodGroup = bloodGroup;
        this.weight = weight;
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

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "EditMyPersonInfo{" +
                "phoneNumber_ID='" + phoneNumber_ID + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", bloodGroup='" + bloodGroup + '\'' +
                ", weight=" + weight +
                '}';
    }
}
