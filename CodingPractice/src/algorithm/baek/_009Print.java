package algorithm.baek;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _009Print {
	public static void main(String[] args) {
		final int LINE = 100;
		int count = 0;
		Scanner scanner = new Scanner(System.in);
		String temp = null;
		List<String> strings = new ArrayList<String>();
		
		while(scanner.hasNext()){
			temp = scanner.nextLine();
			if(temp == null){
				break;
			}else if(!temp.matches("^[ a-zA-Z0-9]*$")){
				break;
			}else if((temp.getBytes()).length >= 100){
				break;
			}else if(temp.startsWith(" ") || temp.endsWith(" ") || " ".equals(temp)){
				break;
			}else{
				count++;
				if(count > LINE){
					break;
				}
				strings.add(temp);
			}
		}
		for(String print : strings){
			System.out.println(print);
		}
		
		scanner.close();
	}
}