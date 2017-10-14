package netty.buffer.NIOByteBuffer;

import java.nio.ByteBuffer;

public class AllocateDirect {

	public static void main(String[] args) {
		
		ByteBuffer byteBuffer = ByteBuffer.allocateDirect(11);
		
		// java.nio.DirectByteBuffer[pos=0 lim=11 cap=11]
		System.out.println(byteBuffer);
		
		// true
		System.out.println(byteBuffer.isDirect());

	}

}
