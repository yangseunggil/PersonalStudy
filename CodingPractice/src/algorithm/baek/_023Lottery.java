package algorithm.baek;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class _023Lottery {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		while (true) {
			int n = scanner.nextInt();
			if (n == 0) {
				break;
			}

			int[] a = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = scanner.nextInt();
			}

			int[] d = new int[n];
			for (int i = 0; i < n - 6; i++) {
				d[i] = 0;
			}
			for (int i = n - 6; i < n; i++) {
				d[i] = 1;
			}

			List<int[]> ans = new ArrayList<>();

			do {
				int[] current = new int[6];
				int idx = 0;
				for (int i = 0; i < n; i++) {
					if (d[i] == 1) {
						current[idx++] = a[i];
					}
				}
				ans.add(current);
			} while (hasNextPermutation(d));

			Collections.sort(ans, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					return Integer.compare(o1[0], o2[1]);
				}
			});

			for (int[] v : ans) {
				for (int i = 0; i < v.length; i++) {
					System.out.print(v[i] + " ");
				}
				System.out.println();
			}
			System.out.println();
		}
		scanner.close();
	}

	/**
	 * 다음번째의 순열이 있는가 확인.
	 * 다음번째의 순열이 있으면 true, 아니면 false
	 * 
	 * 1. 해당 순열이 마지막 순열인지 확인.
	 * 1-1. 다음 순열을 변경하기 위한 기준점 탐색.(control point)
	 *      
	 * 
	 * 
	 * 
	 */
	public static boolean hasNextPermutation(int[] inputArray) {
		
		// 마지막 순열인인지 확인.
		int front_reverse = inputArray.length - 1;
		while (front_reverse > 0 && inputArray[front_reverse - 1] >= inputArray[front_reverse]) {
			/**
			 * ex1) : 7 6 5 4 3 2 1 일 때,
			 * 마지막 while 회차이면
			 * inputArray[i-1] : 7
			 * inputArray[i] : 6
			 * i : 1
			 * i는 0으로 while문 종료.
			 * 
			 * ex2) : 1 7 6 5 4 3 2 일 때,
			 * 마지막 while 회차이면
			 * inputArray[i-1] : 1
			 * inputArray[i] : 7
			 * i : 1
			 * i는 1로 while문 종료.
			 */
			front_reverse--;
		}

		// 마지막 순열이면 거짓 반환.
		if (front_reverse <= 0) {
			return false;
		}
		int control_point = front_reverse-1;

		// 순서변경을 위해, 변경하는 두 요소 선택.
		/**
		 * ex2) : 1 7 6 5 4 3 2 일 때,
		 * 마지막 while 회차이면
		 * i : 1
		 * inputArray[i-1] : 1
		 * inputArray[i] : 7
		 * i는 1로 while문 종료.
		 * i는 다음 순열로 변경하기 위한 index로 사용.
		 */
		int end_reverse = inputArray.length - 1;
		while (inputArray[end_reverse] <= inputArray[control_point]) {
			end_reverse -= 1;
		}

		// 순서 변경
		int temp = inputArray[control_point];
		inputArray[front_reverse - 1] = inputArray[end_reverse];
		inputArray[end_reverse] = temp;
		
		
		/**
		 * flag앞에 있는 모든 원소들 순서를 뒤집어놓음.
		 */
		end_reverse = inputArray.length - 1;
		while (front_reverse < end_reverse) {
			temp = inputArray[front_reverse];
			inputArray[front_reverse] = inputArray[end_reverse];
			inputArray[end_reverse] = temp;
			front_reverse += 1;
			end_reverse -= 1;
		}
		return true;
	}

}