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
			// 서버 부트스트랩 생성
			ServerBootstrap b = new ServerBootstrap();
			
			// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ 서버 회선 설정 시작. @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
		
			// 이벤트루프 설정
			b.group(bossGroup, workerGroup)
			// 채널입출력방식 설정
			.channel(NioServerSocketChannel.class)
			
			// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!! 서버부트스트랩의 초기화가 진행될때. 시작 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
			// 최초 클라이언트로부터의 연결이 들어오는 큐에 대하여 100개까지 지정.
			.option(ChannelOption.SO_BACKLOG, 100)
			// 이벤트 핸들러 설정 - 로그핸들러로 지정.
			.handler(new LoggingHandler(LogLevel.INFO))
			// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!! 서버부트스트랩의 초기화가 진행될때. 끄읕 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
			
			
			// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 클라이언트로부터 연결이 완료된 후. 시작 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
			// 새로 연결된 채널과 이벤트 핸들러 설정
			.childHandler(new ChannelInitializer<SocketChannel>() {
				@Override
				protected void initChannel(SocketChannel paramC) throws Exception {
					paramC.pipeline().addLast("1", new ByteArrayDecoder());
					paramC.pipeline().addLast("2", new EchoServerHandler());
					paramC.pipeline().addLast("3", new ByteArrayEncoder());
				}
			})
			// 세션 해제 여부 감지.
			.childOption(ChannelOption.SO_KEEPALIVE, true);
			// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 클라이언트로부터 연결이 완료된 후. 끄읕 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
			
			// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ 서버 회선 설정 끄읕. @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
			
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