package netty.echo;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.bytes.ByteArrayDecoder;
import io.netty.handler.codec.bytes.ByteArrayEncoder;

public class EchoClient{
	
	public static final String HOST = "localhost";
	public static final int PORT = 9865;
	public static final int SIZE = 256;
	
	public static void main(String[] args) {
		
		EventLoopGroup group = new NioEventLoopGroup();
		
		try{
			Bootstrap b = new Bootstrap();
			
			b.group(group)
			.channel(NioSocketChannel.class)
			.option(ChannelOption.TCP_NODELAY, true)
			.handler(new ChannelInitializer<SocketChannel>() {
				@Override
				protected void initChannel(SocketChannel paramC) throws Exception {
					paramC.pipeline().addLast(new ByteArrayDecoder());
					paramC.pipeline().addLast(new EchoClientHandler());
					paramC.pipeline().addLast(new ByteArrayEncoder());
				};
			});
			
			ChannelFuture f = b.connect(HOST,PORT).sync();
			f.channel().closeFuture().sync();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			group.shutdownGracefully();
		}
		
		
	}


}