package server;

import util.NetworkUtil;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import static server.ServerMain.hospitalInfoList;
import static server.ServerMain.memberInfoList;
import static server.ServerMain.requestListInfoList;

public class Server {
    private ServerSocket serverSocket;
    public int i = 1;
    //public HashMap<String, NetworkUtil> clientMap;
    public List<NetworkUtil> clientMap;

    Server() {
        clientMap = new ArrayList<>();
        try {
            serverSocket = new ServerSocket(33333);
            //new WriteThreadServer(clientMap, "Server");
            while (true) {
                Socket clientSocket = serverSocket.accept();
                serve(clientSocket);
            }
        } catch (Exception e) {
            System.out.println("Server starts:" + e);
        }
    }

    public void serve(Socket clientSocket) {
        NetworkUtil nc = new NetworkUtil(clientSocket);
        clientMap.add(nc);
        for (int j = 0; j < memberInfoList.size(); j++) {
            nc.write(memberInfoList.get(j));
        }

        for (int j = 0; j < requestListInfoList.size(); j++) {
            nc.write(requestListInfoList.get(j));
        }
        for (int j = 0; j < hospitalInfoList.size(); j++) {
            nc.write(hospitalInfoList.get(j));
        }
        //clientMap.put(clientName, nc);
        new ServerReadThread(nc,clientMap);
    }
}
