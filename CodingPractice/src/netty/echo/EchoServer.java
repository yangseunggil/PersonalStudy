package netty.echo;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.bytes.ByteArrayDecoder;
import io.netty.handler.codec.bytes.ByteArrayEncoder;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

public class EchoServer{
	
	public static final int PORT = 9865;
	
	public static void main(String[] args) {
		
		EventLoopGroup bossGroup = new NioEventLoopGroup();
		EventLoopGroup workerGroup = new NioEventLoopGroup();
		
		try{
			ServerBootstrap b = new ServerBootstrap();
			
			b.group(bossGroup, workerGroup)
			.channel(NioServerSocketChannel.class)
			.option(ChannelOption.SO_BACKLOG, 100)
			.handler(new LoggingHandler(LogLevel.INFO))
			.childHandler(new ChannelInitializer<SocketChannel>() {
				@Override
				protected void initChannel(SocketChannel paramC) throws Exception {
					paramC.pipeline().addLast(new ByteArrayDecoder());
					paramC.pipeline().addLast(new EchoServerHandler());
					paramC.pipeline().addLast(new ByteArrayEncoder());
				}
			})
			.childOption(ChannelOption.SO_KEEPALIVE, true);
			
			ChannelFuture f = b.bind(PORT).sync();
			f.channel().closeFuture().sync();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			bossGroup.shutdownGracefully();
			workerGroup.shutdownGracefully();
		}
		
		
	}


}