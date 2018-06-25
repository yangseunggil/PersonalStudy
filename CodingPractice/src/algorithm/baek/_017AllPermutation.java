package algorithm.baek;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _017AllPermutation{
	
	public static void k_permutation(int n, long k) throws IOException {
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		long[] facto = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800, 39916800, 479001600, 
				6227020800L, 87178291200L, 1307674368000L, 20922789888000L, 355687428096000L, 
				6402373705728000L, 121645100408832000L, 2432902008176640000L};
		boolean[] check = new boolean[n];
		Arrays.fill(check, false);
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (check[j - 1] == true) continue;
				if (k > facto[n - i]) {
					k -= facto[n - i];
				} else {
					sb.append(j + " ");
					check[j - 1] = true;
					break;
				}
			}
		}
		
		bw.write(sb.toString());
		bw.flush();
	}
	
	public static void display_permutation(int[] ary) {
		long[] facto = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800, 39916800, 479001600, 
				6227020800L, 87178291200L, 1307674368000L, 20922789888000L, 355687428096000L, 
				6402373705728000L, 121645100408832000L, 2432902008176640000L};
		int n = ary.length;
		boolean[] check = new boolean[n];
		Arrays.fill(check, false);
		long k = 0;
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (check[j - 1] == true) continue;
				if (ary[i - 1] > j)
					k += facto[n - i];
				else {
					check[j - 1] = true;
					break;
				}
					
			}
		}
		System.out.println(k + 1);
	}
	
	public static void main(String[] args) throws IOException {
		
		int n;
		long k;
		int type;
		int[] ary;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		type = Integer.valueOf(st.nextToken());
		
		if (type == 1) {
			k = Long.valueOf(st.nextToken());
			k_permutation(n, k);
		} else if (type == 2) {
			ary = new int[n];
			for (int i = 0; st.hasMoreTokens(); i++) {
				ary[i] = Integer.valueOf(st.nextToken());
			}
			display_permutation(ary);
		} else
			System.exit(1);
	}

}