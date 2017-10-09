package programmingLanguage.regularExpression;

import java.util.Scanner;

public class RegularExpressionTest06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1. 규칙정의
		// 문자의 순서
//		String regex2 = "ab"; // a 다음 반드시 b
//		String regex2 = "ab?"; // a 다음 b는 선택
//		String regex2 = "(ab)?"; // ab를 한 그룹으로
//		String regex2 = "a|b"; // a or b
//		String regex2 = "(a|b)+"; // a or b 1 개 이상
//		String regex2 = "(\\d{2,4}-)?\\d{3,4}-\\d{4}";  // 연락처
//		String regex2 = "\\w+\\.*\\w*@\\w+\\.[a-zA-Z]{2,10}"; // 이메일
		String regex2 = "(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[!@?]).{4,8}"; 

		// 2. 사용자가 입력한 값 검사
		Scanner keyScan = new Scanner(System.in);
		String value = null;

		while (true) {
			System.out.print("입력 : ");
			value = keyScan.nextLine();
			if (value.equals("quit")) {
				break;
			}
			System.out.println(value.matches(regex2));
		}
		keyScan.close();
	}

}