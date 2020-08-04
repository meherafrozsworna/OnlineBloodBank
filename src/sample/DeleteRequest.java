package sample;

import java.io.Serializable;

public class DeleteRequest implements Serializable {
    private String name ;
    private String mobile;
    private String address ;
    private String bloodGroup;
    private String fromWhichIdRequestCome ;

    public DeleteRequest(String name, String mobile,
                         String address, String bloodGroup, String fromWhichIdRequestCome) {
        this.name = name;
        this.mobile = mobile;
        this.address = address;
        this.bloodGroup = bloodGroup;
        this.fromWhichIdRequestCome = fromWhichIdRequestCome;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
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

    public String getFromWhichIdRequestCome() {
        return fromWhichIdRequestCome;
    }

    public void setFromWhichIdRequestCome(String fromWhichIdRequestCome) {
        this.fromWhichIdRequestCome = fromWhichIdRequestCome;
    }

    @Override
    public String toString() {
        return "DeleteRequest{" +
                "name='" + name + '\'' +
                ", mobile='" + mobile + '\'' +
                ", address='" + address + '\'' +
                ", bloodGroup='" + bloodGroup + '\'' +
                ", fromWhichIdRequestCome='" + fromWhichIdRequestCome + '\'' +
                '}';
    }
}
