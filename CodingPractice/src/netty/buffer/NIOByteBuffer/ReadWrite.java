package netty.buffer.NIOByteBuffer;

import java.nio.ByteBuffer;

public class ReadWrite {

	public static void main(String[] args) {
		
	    ByteBuffer byteBuffer = ByteBuffer.allocate(11);

	    // java.nio.HeapByteBuffer[pos=0 lim=11 cap=11]
	    System.out.println(byteBuffer);
	    
	    
	    
	    byteBuffer.put((byte) 1);
	    System.out.println("write 1 Byte");
	    
	    // java.nio.HeapByteBuffer[pos=1 lim=11 cap=11]
	    System.out.println(byteBuffer);
	    
	    
	    
	    byteBuffer.get();			
	    System.out.println("read 1 Byte");
	    
	    // java.nio.HeapByteBuffer[pos=2 lim=11 cap=11]
	    System.out.println(byteBuffer);
	    
	}

}
