package netty.buffer.NIOByteBuffer;

import java.nio.ByteBuffer;

public class Wrap {

	public static void main(String[] args) {
		
		byte[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0};
		ByteBuffer byteBuffer = ByteBuffer.wrap(array);

		// java.nio.HeapByteBuffer[pos=0 lim=11 cap=11]
		System.out.print(byteBuffer);
		
		// false
		System.out.println(byteBuffer.isDirect());
		
	}

}
