package netty.buffer;

import java.nio.ByteBuffer;

public class BufferTest {

	public static void main(String[] args) {
		
		
		System.out.println("direct------------------------------------------------------");
		ByteBuffer directBuffer = ByteBuffer.allocateDirect(11);
		// 11 : true
		System.out.print(directBuffer.capacity());
		System.out.println(" : " + directBuffer.isDirect());
		System.out.println("------------------------------------------------------------\n");


		
		System.out.println("wrap--------------------------------------------------------");
		byte[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0};
		ByteBuffer warpBuffer = ByteBuffer.wrap(array);
		// 11 : false
		System.out.print(warpBuffer.capacity());
		System.out.println(" : " + warpBuffer.isDirect());
		System.out.println("------------------------------------------------------------\n");
		
		
		
		
		
		System.out.println("allocate----------------------------------------------------");
		ByteBuffer allocateBuffer = ByteBuffer.allocate(11);
		// 11 : 11 : 0
		System.out.print(allocateBuffer.capacity());
		System.out.print(" : " + allocateBuffer.limit());
		System.out.println(" : " + allocateBuffer.position());
		System.out.println("11 Bytes put");
		// 11Bytes
	    byte[] source = "Hello world".getBytes(); 
	    allocateBuffer.put(source);
	    // 11 : 11 : 11
	    System.out.print(allocateBuffer.capacity());
		System.out.print(" : " + allocateBuffer.limit());
		System.out.println(" : " + allocateBuffer.position());
	    System.out.println("------------------------------------------------------------\n");
	    
	    
	    
	    
	    
	    System.out.println("readWrite01-------------------------------------------------");
	    ByteBuffer readWriteBuffer01 = ByteBuffer.allocate(11);

	    System.out.println(readWriteBuffer01.position());			//	0
	    
	    readWriteBuffer01.put((byte) 1);							//	[write]
	    System.out.println("write 1 Byte");
		//	1	    
	    System.out.println(readWriteBuffer01.position());
	    
	    //	0[read]
	    readWriteBuffer01.get();			
	    System.out.println("read 1 Byte");
	    System.out.println(readWriteBuffer01.position());			//	2
	    System.out.println("------------------------------------------------------------\n");

	    
	    
	    
	    
	    System.out.println("readWrite02-------------------------------------------------");
	    ByteBuffer readWriteBuffer02 = ByteBuffer.allocate(11);

	    readWriteBuffer02.put((byte) 10);
	    System.out.println("write 1 Byte");
		//	1
	    System.out.println(readWriteBuffer02.position());
	    
	    readWriteBuffer02.put((byte) 20);							
	    System.out.println("write 1 Byte");
		//	2
	    System.out.println(readWriteBuffer02.position());
	    
	    readWriteBuffer02.rewind();
	    System.out.println("rewind");
	    // 0
	    System.out.println(readWriteBuffer02.position());
	    readWriteBuffer02.get();
	    System.out.println("read 1 Byte");
	    // 1
	    System.out.println(readWriteBuffer02.position());
	    System.out.println("------------------------------------------------------------\n");
	    
	    
	    
	    
	    
	    System.out.println("readWrite03-------------------------------------------------");
	    ByteBuffer readWriteBuffer03 = ByteBuffer.allocateDirect(11);

	    // 11 : 11 : 0
	    System.out.print(readWriteBuffer03.capacity());
		System.out.print(" : " + readWriteBuffer03.limit());
		System.out.println(" : " + readWriteBuffer03.position());

	    readWriteBuffer03.put((byte) 10);	//	position : 1
	    readWriteBuffer03.put((byte) 20);	//	position : 2
	    readWriteBuffer03.put((byte) 30);	//	position : 3
	    readWriteBuffer03.put((byte) 40);	//	position : 4
	    System.out.println("write 4 Bytes");
	    
	    // 11: 4 : 11
	    System.out.print(readWriteBuffer03.capacity());
	    System.out.print(" : " + readWriteBuffer03.position());
	    System.out.println(" : " + readWriteBuffer03.limit());

	    readWriteBuffer03.flip();

	    System.out.println("flip");
	    // 11 : 0 : 4
	    System.out.print(readWriteBuffer03.capacity());
	    System.out.print(" : " + readWriteBuffer03.position());
	    System.out.println(" : " + readWriteBuffer03.limit());
	    System.out.println("------------------------------------------------------------");
	}

}
