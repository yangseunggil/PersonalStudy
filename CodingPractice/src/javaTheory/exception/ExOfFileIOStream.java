package javaTheory.exception;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.Buffer;

/**
 * FileIOStream의 예제.
 * 작성일		:	2017 - 02 - 26
 * 작성자		:	Lucrative
 * */
public class ExOfFileIOStream {

	public static void main(String args[]){
		
		// 파일이 있는 경로
		String directory = "resources/ExOfFileIOStream.txt";
		
		// directory에 있는 파일객체 생성
		File file = new File(directory);
		System.out.println("파일의 크기 : " + file.length() + " Bytes");
		
		// FileInputStream
		FileInputStream fileInputStream = null;
		
		// FileOutputStream
		FileOutputStream fileOutputStream = null;
		
		try {
			
			/* file을 이용하여 FileInputStream 객체 생성.
			 * directory를 이용해도 가능.(Constructor Overloading)
			 * 예외객체 : FileNotFoundException
			 */
			fileInputStream = new FileInputStream(file);
			
			
			/* 해당 파일의 있는 내용을 Byte Array에 담아두기 위한 변수.
			 * 아직 fileInputStream을 읽어들이기 전에는 
			 * fileInputStream.available()와 file.length()는 같은 값을 출력하므로
			 * available()은 읽어들이기에 남아있는 fileInputStream의 Byte를 반환한다.
			 * 정황적으로 사용한다.
			 * 
			 * byte 배열의 크기를 지정할 때 아래와 같이 available을 이용하면 한번에 읽어 낼 수 있어,
			 * 동작이 최소화 되지만, 큰 파일(Giga Byte이상의 경우)을 읽어낼 때, 메모리 영역의 낭비가 있다. 문제가 커지면 예외가 발생 될 수 있다.
			 * 따라서 1024 Bytes 단위로 하여금 배열을 생성하여 Buffer를 이용하는 것이 일반적이다.
			 */
			byte[] readBuffer = new byte[1024];
			
			/* 참고 : Buffer
			 * buffer의 사전적 의미는 완충을 말한다.
			 * 컴퓨터 시스템의 어떤 장치에서 다른 장치로 전송을 할 때에, 
			 * 일시적으로 그 데이터를 보관하는 일종의 메모리 영역이다.
			 * buffering이라 함은 buffer를 채우는 동작을 일컷는 말로서 유사어로 Queue가 있다.
			 */
			
			
			
			// 해당 파일에 있는 내용을 1 Byte씩 읽어내기 위한 변수.
			int i = 0;
			
			/* =============================================== 출력예시 시작. =============================================== */
			/* 
			 * 참고	:	확인하고자 하는 각 예제들중 하나를 제외한 나머지는 주석처리 할 것.
			 *			그렇지 아니하면 이전에 먼저 읽어낸 Buffer로 인하여 차후에 read()가
			 *			수행되지 않을 것이다.  		
			 * */
			
 			/* 출력 예제 하나.(1 Btye씩 출력.)
 			 * 
 			 * read() : 파일내용을 1 Byte마다 읽어낸 값을 ASCII Code로 출력.
 			 * 			ASCII Code에서 -1은 존재하지 아니한것을 뜻 한다.
 			 * 			따라서 아래 반복문의 의미는 read()가 더 이상 읽어낼 Byte가 없다면 -1(End Of File)을 반환한다는 의미다.
 			 * 			예외객체 - IOException
 			 * 
 			 * 파일을 1 Byte씩 읽어내는 방식으로서,
 			 * 파일의 용량이 커지면 읽어내는 시간도 물론이고 매우 비효율적인 논리다.
 			 */
//			while( (i = fileInputStream.read()) != -1){
//				System.out.println( i + "  ::  " + (char)i);
				/* 48  ::  0
				 * 49  ::  1
				 * 10  ::  
				 * 
				 * 84  ::  T
				 * 104  ::  h
				 * 105  ::  i
				 * 115  ::  s
				 * ... 
				*/
//			}
			
			/* ====================================================================================================== */
			
			/* 출력 예제 두울.(Btye Array에 담아서 출력.)
 			 * read(byte []) :	매개변수에 있는 Byte Array의 크기만큼의 파일내용을 잘라서 담아두는 방식.
 			 * 					예외객체 - IOException
 			 * 위의 예제보다 반복횟수가 상당히 줄었음을 확인할 수 있다.
 			 * readBuffer 변수 선언에 언급했듯이 파일의 크기만큼의 배열을 선언하기보다,
 			 * 일정 단위로 끊어내는 방식이 메모리 관리에 있어 효율적인 논리를 표현할 수 있다.
 			 */
			while( fileInputStream.read(readBuffer) != -1){
				System.out.println( new String(readBuffer));
				System.out.println("=====================");
				/* 01
				 * This is an example.
				 * So this file is meaningless.
				 * I am a developer.
				 * 02
				 * This is an example.
				 * So this file is meaningless.
				 * I am a developer.
				 * 
				 * ....
				 * 
				 * 15
				 * This is an example.
				 * So this file is meani
				 * =====================
				 * 
				*/
			}
			
			
			/* 출력 예제 세엣.(Byte Array 오차제거)
			 * read(byte [], n1 , n2) :	매개변수에 있는 Byte Array의 크기만큼의 파일내용을 잘라서 담아두는 방식.
			 * 							예외객체 - IOException
			 * 일정단위로 끊어내어 완충하지만, 일부가 마저 완충되지 못하는 오차가 발생할 수 있다.
			 * readBuffer 변수 선언에 언급했듯이 파일의 크기만큼의 배열을 선언하기보다,
			 * 일정 단위로 끊어내는 방식이 메모리 관리에 있어 효율적인 논리를 표현할 수 있다.
			 */
			
			
//			int bufferLength = readBuffer.length;
//			while( (i = fileInputStream.read(readBuffer, 0, readBuffer.length)) != -1){
//				System.out.println(new String(readBuffer));
//				if(fileInputStream.available() != 0){
//					bufferLength=(fileInputStream.available() / readBuffer.length != 0 ) ?  readBuffer.length : fileInputStream.available() % readBuffer.length;
//					readBuffer = new byte[bufferLength];
//				}
//			}
			
			/* =============================================== 출력예시 끄읕. =============================================== */
			
			
			
			/* @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ 복사예시 시작. @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ */
			
			/* file을 이용하여 FileInputStream 객체 생성.
			 * directory를 이용해도 가능.(Constructor Overloading)
			 * 예외객체 : FileNotFoundException
			 */
			File copyFile = new File("resources/copy.txt");
			
			/* FileOutputStream 객체가 생성되는 찰나, 생성자 매개변수에 따른 파일이 생성됨을 확인 할 수 있다.
			 * write()를 한 번도 사용하지 않는 한, 생성된 해당 파일은 빈 파일로 둔다.
			 */
			fileOutputStream = new FileOutputStream(copyFile);
			
			int bufferLength = readBuffer.length;
//			while( (i = fileInputStream.read(readBuffer, 0, readBuffer.length)) != -1){
				/* Buffer의 크기를 단위로 하여, 
				 * 해당 파일에 적재한다. */
//				fileOutputStream.write(readBuffer);
//				if(fileInputStream.available() != 0){
//					bufferLength=(fileInputStream.available() / readBuffer.length != 0 ) ?  readBuffer.length : fileInputStream.available() % readBuffer.length;
//					readBuffer = new byte[bufferLength];
//				}
//			}
			
			/* @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ 복사예시 끄읕. @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ */

			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				fileInputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	
}
