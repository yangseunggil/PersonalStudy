	package programmingLanguage.regularExpression;

import java.util.Scanner;

public class RegularExpressionTest05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1. 규칙정의
//		String regex = "."; //  a | b | c 문자중 하나
//		String regex2= "a?"; // a : 0 or 1
//		String regex2= "a*"; // a 0 이상
//		String regex2= "a+"; // a 0 or 1
//		String regex2= "a{3}"; // a 3개
//		String regex2= "a{3,}"; // a 3 이상
		String regex2= "a{3,4}"; // a 3~4
		
		// 2. 사용자가 입력한 값 검사
		Scanner keyScan = new Scanner(System.in);
		String value = null;
		
		while(true){
			System.out.println("입력 : ");
			value = keyScan.nextLine();
			if(value.equals("quit")){
				break;
			}
			System.out.println(value.matches(regex2));
		}
		keyScan.close();
	}

}