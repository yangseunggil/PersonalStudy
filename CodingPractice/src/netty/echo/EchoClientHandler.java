package netty.echo;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class EchoClientHandler extends SimpleChannelInboundHandler<byte[]> {

	public ByteBuf message;
	public String stringMessage;
	
	public EchoClientHandler() {
		this.stringMessage = "ThisIsMessageForEchoTest.";
		this.message = Unpooled.buffer(EchoClient.SIZE);
	}
	
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		message.writeBytes(stringMessage.getBytes());
		System.out.println("Client Send Data : " + stringMessage );
		ctx.writeAndFlush(message);
	}
	
	@Override
	protected void channelRead0(ChannelHandlerContext ctx, byte[] msg) throws Exception {
		System.out.println("Client Read Data : " + new String(msg));
	}


	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		ctx.flush().close();
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		cause.printStackTrace();
		ctx.close();
	}

}