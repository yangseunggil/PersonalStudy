package programmingLanguage.regularExpression;

public class RegularExpressionTest01 {
	public static void main(String ar[]) throws java.io.IOException {

		// 정규표현식 적용 a로 시작하며, a다음 아무문자1개만, 마지막은c로 끝남
//		final String regex = "^a.c$";
//		String useStr = "a1c";
//		System.out.println(useStr.matches(regex));

		final String regex2 = "\\p{Alnum}+@\\p{Alnum}+\\.\\p{Alnum}+";
		String[] useStr2 = { "pupustory@gmail.com", "pupu한글@gmail.net", "pupu@gmail.net.net", "@.net" };
		for (int i = 0; i < useStr2.length; i++) {
			System.out.println(useStr2[i].matches(regex2));
		}

	}
}
