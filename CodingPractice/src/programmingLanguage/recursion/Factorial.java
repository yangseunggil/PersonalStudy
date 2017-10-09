package programmingLanguage.recursion;

public class Factorial {
	
	
	public static void main(String args[]){
		System.out.println(fac(5));
	}
	
	public static int fac(int i){
		if(i > 1){
			return i * fac(i-1);
		}else{
			return 1;
		}
	}
}
