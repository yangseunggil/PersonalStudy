package network.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class SocketClient {
	
	public static void main(String[] args){
        try(Socket client = new Socket()){
            InetSocketAddress ipep = new InetSocketAddress("127.0.0.1", 9999);
            client.connect(ipep);
             
            try(OutputStream sender = client.getOutputStream();
                InputStream receiver = client.getInputStream();){

            	// 송신
            	byte[] data = new byte[2];
            	sender.write(data);
            	
            	// 수신
            	int bufferLength = data.length;

            	String string = "";
            	while(receiver.read(data, 0 , bufferLength) != -1){
            		string += new String(data);
    				if(receiver.available() != 0){
    					data = new byte[bufferLength];
    				}
                }
            	string = string.trim();
            	System.out.println(string);
            	
            }catch (IOException IOE) {
            	System.err.println(IOE.getMessage());
			}
        }catch(Throwable e){
            e.printStackTrace();
        }
	}

}
