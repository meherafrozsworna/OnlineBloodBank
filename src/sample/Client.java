package sample;

import util.NetworkUtil;

public class Client {
    public static NetworkUtil nc;
    public Client(String serverAddress, int serverPort) {
        try {
            nc = new NetworkUtil(serverAddress, serverPort);
            new ReaderThread(nc);
            //new WriteThreadClient(nc);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
