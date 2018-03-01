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
            	byte[] data = "request".getBytes();
            	sender.write(data);
            	
            	// 수신
            	int bufferLength = data.length;
                while(receiver.read(data, 0 , bufferLength) != -1){
                	System.out.println(new String(data));
    				if(receiver.available() != 0){
    					bufferLength=(receiver.available() / data.length != 0 ) ?  data.length : receiver.available() % bufferLength;
    					data = new byte[bufferLength];
    				}
                }
            }catch (IOException IOE) {
            	System.err.println(IOE.getMessage());
			}
        }catch(Throwable e){
            e.printStackTrace();
        }
	}

}
