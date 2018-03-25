package kr.co.direa.practice.edi;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static final int LENGTH = 1024;
	public static final int PORT = 9020;
	

	public static void main(String[] args) {
		
		
			
		try(ServerSocket serverSocket = new ServerSocket(PORT);) {
			while(true){
				Socket socket = serverSocket.accept();
				
				try(InputStream inputStream = socket.getInputStream();
					OutputStream outputStream = new FileOutputStream("resources/copy.txt")){
					
					byte[] buffer = new byte[LENGTH];
					int bufferLength = buffer.length;
					
					while(inputStream.read(buffer, 0, bufferLength) != -1){
						System.out.println("receiving");
						String data = new String(buffer).trim();
						outputStream.write(data.getBytes());
						if(inputStream.available() != 0 ){
							buffer = new byte[LENGTH];
						}
						Thread.sleep(5000);
					}
					System.out.println("end");
					
				}catch (IOException | InterruptedException e) {
					System.err.println(e.getMessage());
				}
			
			}
			
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
		

	}

}
