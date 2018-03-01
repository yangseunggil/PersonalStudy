package network.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
/**
 * ServerSocket01
 * 비연결형태.
 * 단일쓰레드 서버.
 * */
public class SocketServer01 {

	public static void main(String[] args) {

		try(ServerSocket server = new ServerSocket()){
			// 서버소켓 생성
            server.bind(new InetSocketAddress(9999));

            while(true){
	            // 클라이언트 대기
	             
	            try(Socket client = server.accept();
	            	OutputStream sender = client.getOutputStream();
	                InputStream reciever = client.getInputStream();){
	
	            	// 수신
	            	byte[] data = new byte[7];
	            	reciever.read(data);
	            	System.out.println(new String(data));
	
	            	// 송신
	            	data = "response".getBytes();
	            	sender.write(data, 0, data.length);
	                 
	            } catch(IOException IOE){
	            	System.err.println(IOE.getMessage());
	            }
			}
        }catch(Throwable e){
            e.printStackTrace();
        }
	}

}
