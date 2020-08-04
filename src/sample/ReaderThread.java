package sample;

import util.NetworkUtil;

import static sample.Main.hospitalList;
import static sample.Main.personInfoList;
import static sample.Main.requestList;


public class ReaderThread implements Runnable{
    private Thread thr;
    private NetworkUtil nc;

    public ReaderThread(NetworkUtil nc) {
        this.nc = nc;
        this.thr = new Thread(this);
        thr.start();
    }

    public void run() {
        try {
            while (true) {
                Object o = nc.read();
                if (o != null) {
                    if (o instanceof MemberInfo) {
                        MemberInfo m = (MemberInfo) o;
                        System.out.println("Server send :" + m);
                        personInfoList.add(m);
                    } else if (o instanceof RequestListInfo) {
                        RequestListInfo r = (RequestListInfo) o;
                        System.out.println("Server send req :" + r);
                        requestList.add(r);
                    } else if (o instanceof HospitalInfo) {
                        HospitalInfo h = (HospitalInfo) o;
                        System.out.println("Server send :" + h);
                        hospitalList.add(h);
                    } else if (o instanceof DeleteRequest) {
                        DeleteRequest d = (DeleteRequest) o;
                        for (int i = 0; i < requestList.size(); i++) {

                            if (requestList.get(i).getName().equals(d.getName()) &&
                                    requestList.get(i).getMobile().equals(d.getMobile()) &&
                                    requestList.get(i).getAddress().equals(d.getAddress()) &&
                                    requestList.get(i).getBloodGroup().equals(d.getBloodGroup())&&
                                    requestList.get(i).getFromWhichIdRequestCome().
                                            equals(d.getFromWhichIdRequestCome())){
                                requestList.remove(i);
                            }
                        }

                    }else if (o instanceof UptadeBloodInfoHospital) {
                        UptadeBloodInfoHospital u = (UptadeBloodInfoHospital) o;
                        System.out.println("server send : "+ u);
                        for (int i = 0; i < hospitalList.size(); i++) {
                            if (hospitalList.get(i).getPhoneNumber_ID().equals(u.getId())){
                                hospitalList.get(i).setDate(u.getDate());
                                hospitalList.get(i).setBloodAvailable(u.getAvailable());
                                hospitalList.get(i).setBloodneeded(u.getNeeded());
                            }
                        }
                    }else if (o instanceof EditMyPersonInfo) {
                        EditMyPersonInfo e = (EditMyPersonInfo) o;
                        System.out.println("Server send "+ e);
                        for (int i = 0; i < personInfoList.size(); i++) {
                            if (personInfoList.get(i).getPhoneNumber_ID().equals(e.getPhoneNumber_ID())){
                                personInfoList.get(i).setPhoneNumber_ID(e.getPhoneNumber_ID());
                                personInfoList.get(i).setAddress(e.getAddress());
                                personInfoList.get(i).setName(e.getName());
                                personInfoList.get(i).setBloodGroup(e.getBloodGroup());
                                personInfoList.get(i).setWeight(e.getWeight());

                            }
                        }
                    }
                }
            }
        }catch (Exception e) {
            System.out.println(e);
        } finally {
            nc.closeConnection();
        }
    }
}
