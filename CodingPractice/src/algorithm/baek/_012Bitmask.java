package algorithm.baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _012Bitmask {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder stringBuilder = new StringBuilder();
		String cmd = null;
		String oper = null;
		int operCnt = Integer.parseInt(in.readLine());
		int x = 0;
		int S = 0;
		for(int i = 0 ; i < operCnt ; i ++){
			cmd = in.readLine();
			oper = cmd.split(" ")[0];
			if("add".equals(oper)){
				x = Integer.parseInt(cmd.split(" ")[1]);
				S = (S | (1<<x));
			}else if("remove".equals(oper)){
				x = Integer.parseInt(cmd.split(" ")[1]);
				S = (S & ~(1<<x));
			}else if("check".equals(oper)){
				x = Integer.parseInt(cmd.split(" ")[1]);
				stringBuilder.append( (( (S & (1 << x)) != 0 ) ? 1 : 0) + "\n");
			}else if("toggle".equals(oper)){
				x = Integer.parseInt(cmd.split(" ")[1]);
				S = (S ^ (1 << x));
			}else if("all".equals(oper)){
				S =  ((1<<21)-2);
			}else if("empty".equals(oper)){
				S = 0;
			}
		}
		System.out.println( stringBuilder.toString() );
		in.close();
	}
}

