package network.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 * ServerSocket03
 * 비연결형태.
 * 멀티쓰레드 서버.
 * OOM방지를 위한 쓰레드풀 생성. 20개 제한.
 * */
public class SocketServer03 {

	
	public static void main(String[] args) {

		ExecutorService pool = Executors.newFixedThreadPool(20);

		try(ServerSocket server = new ServerSocket()){
			// 서버소켓 생성
            server.bind(new InetSocketAddress(9999));

            while(true){
	            // 클라이언트 대기
	            try{
	            	Callable<Void> multiThread = new MultiThread(server.accept());
	            	pool.submit(multiThread);
	            } catch(IOException IOE){
	            	System.err.println(IOE.getMessage());
	            }
			}
        }catch(Throwable e){
            e.printStackTrace();
        }
	}
	
	public static class MultiThread implements Callable<Void>{
		private Socket client;
		
		MultiThread (Socket client){
			this.client = client;
		}
		
		@Override
		public Void call(){
			try(OutputStream sender = this.client.getOutputStream();
	            InputStream reciever = this.client.getInputStream();){

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
			return null;
		}
	}

}
