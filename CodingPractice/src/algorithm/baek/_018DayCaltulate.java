package algorithm.baek;

import java.util.Scanner;

public class _018DayCaltulate{
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int E = scanner.nextInt();
		int S = scanner.nextInt();
		int M = scanner.nextInt();
		if(E < 1 || E > 15){
			scanner.close();
			return;
		}
		if(S < 1 || S > 28){
			scanner.close();
			return;
		}
		if(M < 1 || M > 19){
			scanner.close();
			return;
		}
		
		int e = 1;
		int s = 1;
		int m = 1;
		int i = 1;
		while(true){
			if(e==E && s == S && m==M){
				System.out.println(i);
				break;
			}
			i++;
			e++;
			s++;
			m++;
			if(e==16){
				e=1;
			}
			if(s==29){
				s=1;
			}
			if(m==20){
				m=1;
			}
			
		}
		scanner.close();
	}
}