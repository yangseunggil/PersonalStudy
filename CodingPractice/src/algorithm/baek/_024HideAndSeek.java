package algorithm.baek;

import java.util.*;

public class _024HideAndSeek {
	public static final int MAX = 1000000;
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.close();
        boolean[] isLocated = new boolean[MAX];
        int[] time = new int[MAX];
        isLocated[n] = true;
        time[n] = 0;
        
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(n);
        
        while(!queue.isEmpty()){
        	int now = queue.remove();
        	int back = now - 1;
        	if( back >= 0 ){
        		if(!isLocated[back]) {
        			isLocated[back] = true;
        			time[back] = time[now] + 1;
        			queue.add(back);
        		}
        	}
        	int forward = now + 1;
        	if( forward < MAX ){
        		if(!isLocated[forward]) {
        			isLocated[forward] = true;
        			time[forward] = time[now] + 1;
        			queue.add(forward);
        		}
        	}
        	int teleport = now * 2;
        	if( teleport < MAX ){
        		if(!isLocated[teleport]) {
        			isLocated[teleport] = true;
        			time[teleport] = time[now] + 1;
        			queue.add(teleport);
        		}
        	}
        }
        System.out.println(time[m]);
    }
}