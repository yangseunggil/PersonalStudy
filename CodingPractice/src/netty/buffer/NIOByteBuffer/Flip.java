package netty.buffer.NIOByteBuffer;

import java.nio.ByteBuffer;

public class Flip {

	public static void main(String[] args) {
	    ByteBuffer byteBuffer = ByteBuffer.allocateDirect(11);

		System.out.println(byteBuffer);

	    byteBuffer.put((byte) 10);
	    byteBuffer.put((byte) 20);
	    byteBuffer.put((byte) 30);
	    byteBuffer.put((byte) 40);
	    System.out.println("write 4 Bytes");
	    
	    System.out.println(byteBuffer);

	    System.out.println("flip");
	    byteBuffer.flip();

	    // 11 : 0 : 4
	    System.out.println(byteBuffer);
	}

}
