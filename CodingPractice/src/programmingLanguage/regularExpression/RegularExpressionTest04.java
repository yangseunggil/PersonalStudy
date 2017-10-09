	package programmingLanguage.regularExpression;

import java.util.Scanner;

public class RegularExpressionTest04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1. 규칙정의
//		String regex = "."; //  a | b | c 문자중 하나
//		String regex2= "\\d"; // [0-9]
		String regex2= "\\w"; // [0-9a-zA-Z]
		
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