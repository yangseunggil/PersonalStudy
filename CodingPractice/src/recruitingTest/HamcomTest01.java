package recruitingTest;

public class HamcomTest01 {

	// 주어진 정수를 뒤집어서 출력
	// Ex : 46312 => 21364
	public static int getReversedInteger(int val) {
		StringBuffer returnVal = new StringBuffer();
		int length = String.valueOf(val).length();

		for (int i = 0; i < length; i++) {
			returnVal.append(val % 10);
			val /= 10;
		}

		return Integer.parseInt(returnVal.toString());
	}

	// 배열을 오름차순으로 정렬하고 중간값 출력
	// 입력받은 수들의 개수가 짝수면 두 개의 중간값의 평균을 출력
	// Ex : 10, 2, 101, 90 => 50
	public static double getMedian(int[] val) {
		int indexMin, temp;

		// Selection sort
		for (int i = 0; i < val.length; i++) {
			indexMin = 0;
			for (int j = i; j < val.length; j++) {
				if (val[indexMin] > val[j]) {
					indexMin = j;
				}
			}
			temp = val[indexMin];
			val[indexMin] = val[i];
			val[i] = temp;
		}

		if (val.length % 2 == 0) {
			return (val[val.length / 2] + val[val.length / 2 + 1]) / 2;
		} else {
			return val[val.length / 2 + 1];
		}

	}

	// 해당 순번의 피보나치의 값 출력
	// Ex : 2 => 1, 8 => 21
	// no recursive
	public static int getFibonacciNumber(int val) {

		int prePre = 0;
		int pre = 1;
		int in = 0;

		if (val <= 0) {
			return prePre;
		} else if (val == 1) {
			return pre;
		} else {
			for (int i = 0; i < val - 1; i++) {
				in = prePre + pre;
				prePre = pre;
				pre = in;
			}
			return pre;
		}

	}

	public static void main(String args[]) {
		// System.out.println(getReversedInteger(46312));
		// // 21364
		//
		// int arrayInt[] = {10, 2, 101, 90};
		// System.out.println(getMedian(arrayInt));
		// // 50.0
		//
		// System.out.println(getFibonacciNumber(8));
		// // 21
		int total = 0;

		for (int i = 1; i <= 5; i++) {

			for (int j = 1; j <= i; i++) {

				total++;
				System.out.println(j);

			}

		}

		System.out.println(total);

	}

}
