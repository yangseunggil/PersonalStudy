package programmingLanguage.regularExpression;

import java.util.Scanner;

public class RegularExpressionTest02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1. 규칙정의
//		String regex = "a"; // a 문자 한 개 
//		String regex = "abc"; // a 문자 한 개 
		String regex = "\\\\"; // 역슬래시 문자 한 개 
		
		// 2. 사용자가 입력한 값 검사
		Scanner keyScan = new Scanner(System.in);
		String value = null;
		
		while(true){
			System.out.print("입력 : ");
			value = keyScan.nextLine();
			if(value.equals("quit")){
				break;
			}
			System.out.println(value.matches(regex));
		}
		keyScan.close();
	}

}