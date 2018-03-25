package kr.co.direa.practice.edi;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {

	public static void main(String[] args) {
		
		try(Socket socket = new Socket("localhost",Server.PORT);) {
			
			try(InputStream inputStream = new FileInputStream("resources/ExOfFileIOStream.txt");
				OutputStream outputStream = socket.getOutputStream();){
				
				byte[] buffer = new byte[Server.LENGTH];
				int bufferLength = buffer.length;
				while(inputStream.read(buffer, 0, bufferLength) != -1){
					String data = new String(buffer).trim();
					outputStream.write(data.getBytes());
					if(inputStream.available() != 0 ){
						buffer = new byte[Server.LENGTH];
					}
				}
				
			}catch(IOException e){
				System.err.println(e.getMessage());
			}
			
			
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
		
	}

}
