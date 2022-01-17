package resource;

import interfaces.IMacAddrres;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

public class networkInterface implements IMacAddrres{

    @Override
    public String macAdress() {
        
        // Var
        String MacAddress = "";
        
        try {
            NetworkInterface network = NetworkInterface.getByInetAddress(this.ipAddress());
            byte[] MAC = network.getHardwareAddress();
            
            for (int i = 0; i < MAC.length; i++) {
                MacAddress += String.format("%02X%s", MAC[i], (i < MAC.length - 1) ? "-" : "");
            }
        } catch (SocketException ex) {
            ex.printStackTrace(System.out);
            System.exit(1);
        }
        return MacAddress;
    }

    @Override
    public InetAddress ipAddress() {
        
        // Var
        InetAddress IP = null;
        
        try {
            IP = InetAddress.getLocalHost();
        } catch (UnknownHostException ex) {
            ex.printStackTrace(System.out);
            System.exit(1);
        }
        return IP;
    }
}
