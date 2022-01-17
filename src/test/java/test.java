
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.URL;
import resource.networkInterface;

public class test
{

	private static String publicIP = null;
 
	public static void main(String args[]){
            System.out.println(new networkInterface().macAdress());
	}
 
} 

