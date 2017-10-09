package netty.echo;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * 해당 채널측으로 데이터가 들어가는 이벤트가 발생 될 때 처리되는 Bean.
 * SimpleChannelInboundHandler는 ChannelInboundHander를 구현받는다.
 * (가장 추상적인 Bean은 ChannelHandler다.)
 * 실제로 분석하면 꽤나 많이 상속받고 구현받지만 가장 유심히 볼 것은 ChannelInboundHander다.
 * ChannelInboundHander를 이용하여 Override함으로서, 이벤트를 처리하기 때문이다.
 * 
 * 주로 사용되는 Methode들
 * channelActive, channelRead, channelReadComplete, exceptionCaught 등 있고
 * https://netty.io/4.0/api/io/netty/channel/ChannelInboundHandler.html
 * 에서 기능을 보면된다.
 * 
 * 특히 channelRead0는 SimpleChannelInboundHandler에서만 Override한 것이다.
 * 보통 ChannelInboundHandler의 ChannelRead를 사용하면, 
 * argument로 받은 msg 해제도 직접 해야된다.
 * 그렇지 않으면 msg는 누수된다.(로그에 WARN으로 찍힌다.)
 * 
 * SimpleChannelInboundHandler는 msg의 해제를 내부적으로 처리되도록 구현되어있음은 물론이고,
 * msg의 유형을 Generic으로 직접 지정할 수 있다.
 * 
 * */

public class EchoServerHandler extends SimpleChannelInboundHandler<byte[]> {

	
	@Override
	protected void channelRead0(ChannelHandlerContext ctx, byte[] msg) throws Exception {
		/**
		 * ByteBuf는 Java NIO에서 제공하는 ByteBuffer보다 빠르고 쉽고 유연성이 있다.
		 * Java NIO의 ByteBuffer는 flip()을 사용해서,
		 * 버퍼의 읽고 쓰는 포지션 포인터를 지정해야된다.
		 * https://gs.saro.me/#!m=elec&jn=537
		 * 하지만 ByteBuf는 굳이 이런 작업이 필요없이 ...........
		 * 
		 * 또 하나의 특징은 버퍼의 크기가 동적으로 변한다는 것이다.
		 * capacity를 변형할 경우 기존의 byte의 내용은 보존하면서 변한다.
		 * http://aoruqjfu.fun25.co.kr/index.php/post/567
		 * 
		 * */
		ByteBuf b = Unpooled.buffer(msg.length);
		b.writeBytes(msg);
		System.out.println("Server Read Data : " + new String(msg));
		System.out.println("Server Send Data : " + new String(msg));
		ctx.writeAndFlush(b);
	}
	
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		cause.printStackTrace();
		ctx.close();
	}

}