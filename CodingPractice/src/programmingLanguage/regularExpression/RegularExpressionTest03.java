package programmingLanguage.regularExpression;

import java.util.Scanner;

public class RegularExpressionTest03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1. 규칙정의
		// 문자 집합 정의
//		String regex = "[abc]"; //  a | b | c 문자중 하나
//		String regex = "[a-z]"; //  소문자 하나
//		String regex = "[a-zA-Z_]"; //  대소문자, underline 하나
//		String regex = "[^a-zA-Z_]"; //  해당 집합의 나머지
		String regex = "[a-dx-z]"; //   a | b | c | d | x | y | z | 문자중 하나
		
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