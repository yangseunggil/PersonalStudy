package javaTheory.exception;

public class ExceptionTest {
	public static void ex(){
		try{
			System.out.println("ㅎㅎㅎㅎㅎ");
			throw new Exception();
		}catch(Exception e) {
			System.out.println("ㅋㅋㅋㅋㅋ");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			 ex();
		}catch(Exception e){
			System.out.println("ㄴㄴㄴㄴㄴ");
		}finally{
			System.out.println("ㅇㅇㅇㅇㅇ");
		}
		

	}
}

// 출력 결과
// ㅎㅎㅎㅎㅎ
// ㅋㅋㅋㅋㅋ
// ㅇㅇㅇㅇㅇ