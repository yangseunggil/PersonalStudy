package netty.buffer.ByteBuf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

public class ReadWrite {

	public static void main(String[] args) {
		
		ByteBuf byteBuf = Unpooled.buffer(12);
		// read : 0, write : 12
		System.out.print("read : " + byteBuf.readableBytes());
		System.out.println(", write : " + byteBuf.writableBytes());

		System.out.println("write 11 bytes");
		byteBuf.writeBytes("Hello world".getBytes());
		// read : 11, write : 1
		System.out.print("read : " + byteBuf.readableBytes());
		System.out.println(", write : " + byteBuf.writableBytes());
		
		System.out.println("read 4 bytes");
		byteBuf.readInt();
		// read : 7, write : 1
		System.out.print("read : " + byteBuf.readableBytes());
		System.out.println(", write : " +byteBuf.writableBytes());
		
		System.out.println("clear");
		byteBuf.clear();
		// read : 0, write : 12
		System.out.print("read : " + byteBuf.readableBytes());
		System.out.println(", write : " +byteBuf.writableBytes());		
		
		
	}

}
