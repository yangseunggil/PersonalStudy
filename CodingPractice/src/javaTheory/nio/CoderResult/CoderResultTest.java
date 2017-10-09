package javaTheory.nio.CoderResult;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;

public class CoderResultTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String charactorSet = "UTF-8";
		String string = "꽑한글과Alphabet조합";

		Charset charset = Charset.forName(charactorSet);
		CharsetEncoder charsetEncoder = charset.newEncoder();

		CharBuffer charBuffer = CharBuffer.allocate(64);
		charBuffer.put(string);
		charBuffer.flip();

		ByteBuffer byteBuffer = ByteBuffer.allocate(6);

		CoderResult coderResult = null;
		FileOutputStream fileOutputStream = null;
		FileChannel fileChannel = null;
		
		System.out.println("string			:	" + string);
		System.out.println("string.length()		:	" + string.length());
		System.out.println("=======================================================");
		System.out.println("charBuffer.length()	:	" + charBuffer.length());
		System.out.println("charBuffer.limit()	:	" + charBuffer.limit() );
		System.out.println("charBuffer.position()	:	" + charBuffer.position() );
		System.out.println("charBuffer.toString()	:	" + charBuffer.toString() );
		try {
			fileOutputStream = new FileOutputStream("temp.tmp");
			fileChannel = fileOutputStream.getChannel();

			while (true) {
				coderResult = charsetEncoder.encode(charBuffer, byteBuffer, true);
				byteBuffer.flip();
				fileChannel.write(byteBuffer);
				byteBuffer.clear();
				System.out.println("=======================================================");
				System.out.println("coderResult				: " + coderResult );
				System.out.println("\ncharBuffer.limit()			: " + charBuffer.limit() );
				System.out.println("charBuffer.position()			: " + charBuffer.position() );
				System.out.println("charBuffer.toString()			: " + charBuffer.toString() );
				System.out.println("\nbyteBuffer.toString()			: " + byteBuffer.toString() );
				System.out.println("byteBuffer.remaining()			: " + byteBuffer.remaining() );
				System.out.println("new String(byteBuffer.array())		: " + new String(byteBuffer.array()) );
				

				if (coderResult == CoderResult.UNDERFLOW) {
					if (charBuffer.position() == charBuffer.limit()) {
						break;
					}
				}
				System.out.println("=======================================================");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
