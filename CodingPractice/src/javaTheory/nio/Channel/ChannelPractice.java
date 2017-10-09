package javaTheory.nio.Channel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ChannelPractice {
	public static void main(String[] args) {

		FileChannel inputChannel = null;
		FileChannel outputChannel = null;
		FileInputStream fileInputStream = null;
		FileOutputStream fileOutputStream = null;

		try {
			fileInputStream = new FileInputStream("resources/ExOfFileIOStream.txt");
			fileOutputStream = new FileOutputStream("resources/copy.txt");
			inputChannel = fileInputStream.getChannel();
			outputChannel = fileOutputStream.getChannel();

			ByteBuffer buffer = ByteBuffer.allocateDirect(512);
			int length = -1;
			while ((length = inputChannel.read(buffer)) != -1) {
				if (length == 512) {
					buffer.position(0);
				} else {
					buffer.flip();
				}
				outputChannel.write(buffer);
				if (length == 512) {
					buffer.rewind();
				} else {
					buffer.clear();
				}
			}

		} catch (IOException ex) {
		} finally {
			try {
				fileInputStream.close();
				fileOutputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
