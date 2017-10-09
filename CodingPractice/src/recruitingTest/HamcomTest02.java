package recruitingTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HamcomTest02 {

	public static boolean isOverlapped(Circle c1, Circle c2){
		double sumOfR = c1.getR() + c2.getR();
		double distance = Math.sqrt(Math.pow(c1.getX()-c2.getX(),2) + Math.pow(c1.getY() - c2.getY(), 2));
		
		if(distance < sumOfR){
			return true;
		}else{
			return false;
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		int theNumberOfCircle=-1;
		
		// set the number of circles
		while(theNumberOfCircle < 0){			
			System.out.println("Please input the number of circles.");
			theNumberOfCircle = scan.nextInt();
			
			if(theNumberOfCircle<0){
				System.out.print("Worng value. ");
			}
		}
		
		List<Circle> circles = new ArrayList<Circle>(theNumberOfCircle);
		List<Integer> circlesId = new ArrayList<Integer>(theNumberOfCircle);
		
		// input circles
		for(int i = 0 ; i < theNumberOfCircle ; i++){
			
			Circle tempCircle = new Circle(scan.nextInt(), scan.nextDouble(), scan.nextDouble(), scan.nextDouble());
			
			// validation check
			// range of circle
			if(
					(1 > tempCircle.getId() || tempCircle.getId() > 300) ||
					(-10000 > tempCircle.getX() || tempCircle.getX() > 10000) ||
					(-10000 > tempCircle.getY() | tempCircle.getY() > 10000) ||
					(0 >= tempCircle.getR() || tempCircle.getR() > 10000)
			  ){
				System.out.println("Worng value");
				i--;
				continue;
			}else if(i > 0){
				// ID duplication check
				if(circlesId.contains(tempCircle.getId())){
					System.out.println("Worng value");
					i--;
					continue;
				}
			}
			
			circles.add(tempCircle);
			circlesId.add(tempCircle.getId());
			
		}
		
		
		// printing overlapped circles
		for(int i = 0 ; i < circles.size() ; i ++){
			for(int j = i ; j < circles.size() ; j++){
				if(i==j){
					continue;
				}else{
					if(isOverlapped(circles.get(i), circles.get(j))){
						System.out.println(circles.get(i).getId() + ", " + circles.get(j).getId());											
					}
				}
			}
		}
		
		
	scan.close();	
	}

}

class Circle{
	
	private int    id;
	private double x;
	private double y;
	private double r;
	
	
	public Circle() {
		super();
	}

	public Circle(int id, double x, double y, double r) {
		super();
		this.id = id;
		this.x = x;
		this.y = y;
		this.r = r;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	public double getR() {
		return r;
	}
	public void setR(double r) {
		this.r = r;
	}
	
}