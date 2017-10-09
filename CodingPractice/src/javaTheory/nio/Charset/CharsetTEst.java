package javaTheory.nio.Charset;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.IllegalCharsetNameException;
import java.nio.charset.UnsupportedCharsetException;

public class CharsetTEst {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String charactorSet = "UTF-16";
		String string = "한글과Alphabet조합";
		
		FileChannel fileChannel = null;
		FileOutputStream fileOutputStream = null;
		
		try{
			Charset charset = Charset.forName(charactorSet);
			ByteBuffer byteBuffer = charset.encode(string);
			fileOutputStream = new FileOutputStream("temp.tmp");
			fileChannel = fileOutputStream.getChannel();
			fileChannel.write(byteBuffer);
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
					fileOutputStream.close();
				}catch(IOException e){
					System.out.println("IOException close");
				}
			}
		}

		
	}

}
