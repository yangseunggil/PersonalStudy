package javaTheory.nio.Charset;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.IllegalCharsetNameException;
import java.nio.charset.UnsupportedCharsetException;

public class CharsetTEst2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String charactorSet = "UTF-16";
		FileChannel fileChannel = null;
		FileInputStream fileInputStream = null;
		
		try{
			Charset charset = Charset.forName(charactorSet);
			ByteBuffer byteBuffer = ByteBuffer.allocate(32);
			
			fileInputStream = new FileInputStream("temp.tmp");
			fileChannel = fileInputStream.getChannel();
			fileChannel.read(byteBuffer);
			byteBuffer.flip();
			CharBuffer charBuffer = charset.decode(byteBuffer);
			System.out.println(charBuffer.toString());
		}catch(IllegalCharsetNameException e){
			System.out.println("IllegalCharsetNameException");
		}catch (UnsupportedCharsetException  e) {
			System.out.println("UnsupportedCharsetException");
		}catch (IOException e) {
			System.out.println("IOException");
		}finally {
			if(fileChannel != null){
				try{
					fileChannel.close();
					fileInputStream.close();
				}catch(IOException e){
					System.out.println("IOException close");
				}
			}
		}

		
	}

}
