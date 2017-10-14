package netty.buffer.ByteBuf;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

public class DiffernceBoth {

	public static void main(String[] args) {
		
		ByteBuffer byteBuffer = ByteBuffer.allocate(13);
		// java.nio.HeapByteBuffer[pos=0 lim=13 cap=13]
		System.out.println(byteBuffer);
		
		byteBuffer = ByteBuffer.allocate(14);
		// java.nio.HeapByteBuffer[pos=0 lim=13 cap=14]
		System.out.println(byteBuffer);
		
//		BufferOverflowException
//		byteBuffer.put("012345678912341".getBytes());
		
		
		ByteBuf byteBuf = Unpooled.buffer(13);
		// (ridx: 0, widx: 0, cap: 13)
		System.out.println(byteBuf);
		
		byteBuf.capacity(14);
		// (ridx: 0, widx: 0, cap: 14)
		System.out.println(byteBuf);
		
		// write 59 bytes
		byteBuf.writeBytes("This is byte array longer than previous capacity of byteBuf".getBytes());
		// (ridx: 0, widx: 59, cap: 64)
		System.out.println(byteBuf);
		
		byteBuf.capacity(14);
		// This is byte a
		System.out.println(byteBuf.toString(Charset.defaultCharset()));
		// (ridx: 0, widx: 14, cap: 14)
		System.out.println(byteBuf);
		
		
	}

}
