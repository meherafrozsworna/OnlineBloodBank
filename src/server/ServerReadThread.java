package server;

import sample.*;
import util.NetworkUtil;

import java.util.List;

import static server.ServerMain.hospitalInfoList;
import static server.ServerMain.memberInfoList;
import static server.ServerMain.requestListInfoList;


public class ServerReadThread implements Runnable {
    private Thread thr;
    private NetworkUtil nc;
    private List<NetworkUtil> clientMap;

    public ServerReadThread(NetworkUtil nc, List<NetworkUtil> clientMap) {
        this.clientMap = clientMap;
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
                        memberInfoList.add(m);
                        for (int i = 0; i < clientMap.size(); i++) {
                            try{
                                clientMap.get(i).write(m);
                            }catch (Exception e){
                                clientMap.remove(i);
                            }

                        }
                    }else if (o instanceof RequestListInfo) {
                        RequestListInfo r = (RequestListInfo) o;
                        requestListInfoList.add(r);
                        for (int i = 0; i < memberInfoList.size() ; i++) {
                            if (memberInfoList.get(i).getBloodGroup().equals(r.getBloodGroup())){
                                //from,password,to,subject,message
                                Mail.send("@gmail.com","",
                                        memberInfoList.get(i).getMail(),"Blood needed",
                                        r.getBloodGroup()+"Blood needed");
                                //change from, password and to
                            }
                        }
                        for (int i = 0; i < clientMap.size(); i++) {
                            try{
                                clientMap.get(i).write(r);
                            }catch (Exception e){
                                clientMap.remove(i);
                            }
                        }
                    }else if (o instanceof HospitalInfo) {
                        HospitalInfo h = (HospitalInfo) o;
                        hospitalInfoList.add(h);
                        for (int i = 0; i < clientMap.size(); i++) {
                            try{
                                clientMap.get(i).write(h);
                            }catch (Exception e){
                                clientMap.remove(i);
                            }
                        }
                    }else if (o instanceof DeleteRequest) {
                        DeleteRequest d = (DeleteRequest) o;
                        for (int i = 0; i < requestListInfoList.size(); i++) {

                            if (requestListInfoList.get(i).getName().equals(d.getName()) &&
                                    requestListInfoList.get(i).getMobile().equals(d.getMobile()) &&
                                    requestListInfoList.get(i).getAddress().equals(d.getAddress()) &&
                                    requestListInfoList.get(i).getBloodGroup().equals(d.getBloodGroup())&&
                                    requestListInfoList.get(i).getFromWhichIdRequestCome().
                                            equals(d.getFromWhichIdRequestCome())){
                                requestListInfoList.remove(i);
                            }
                        }

                        for (int i = 0; i < clientMap.size(); i++) {
                            try{
                                clientMap.get(i).write(d);
                            }catch (Exception e){
                                clientMap.remove(i);
                            }
                        }
                    }else if (o instanceof UptadeBloodInfoHospital) {
                        UptadeBloodInfoHospital u = (UptadeBloodInfoHospital) o;
                        for (int i = 0; i < hospitalInfoList.size(); i++) {
                            if (hospitalInfoList.get(i).getPhoneNumber_ID().equals(u.getId())){
                                hospitalInfoList.get(i).setDate(u.getDate());
                                hospitalInfoList.get(i).setBloodAvailable(u.getAvailable());
                                hospitalInfoList.get(i).setBloodneeded(u.getNeeded());
                            }
                        }
                        for (int i = 0; i < clientMap.size(); i++) {
                            try{
                                clientMap.get(i).write(u);
                            }catch (Exception e){
                                clientMap.remove(i);
                            }
                        }
                    }else if (o instanceof EditMyPersonInfo) {
                        EditMyPersonInfo e = (EditMyPersonInfo) o;
                        for (int i = 0; i < memberInfoList.size(); i++) {
                            if (memberInfoList.get(i).getPhoneNumber_ID().equals(e.getPhoneNumber_ID())){
                                memberInfoList.get(i).setPhoneNumber_ID(e.getPhoneNumber_ID());
                                memberInfoList.get(i).setAddress(e.getAddress());
                                memberInfoList.get(i).setName(e.getName());
                                memberInfoList.get(i).setBloodGroup(e.getBloodGroup());
                                memberInfoList.get(i).setWeight(e.getWeight());

                            }
                        }
                        for (int i = 0; i < clientMap.size(); i++) {
                            try{
                                clientMap.get(i).write(e);
                            }catch (Exception p){
                                clientMap.remove(i);
                            }
                        }
                    }


                }
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            nc.closeConnection();
        }
    }
}
