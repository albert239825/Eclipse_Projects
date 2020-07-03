import java.util.Scanner;
import java.util.*;
public class Driver {
	
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Employee ep01 = new Employee();
		
		Employee ep02 = new Employee("Letts", 9001, 28);
		System.out.println(ep02.getSalary());
		
		System.out.println(ep02);
		
		String s = "Uh oh, Stinky.";
		String t = "Super Smash";
		
		System.out.println("I am comparing " + ep01.compareTo(ep02));
		
//		Employee[] workers = {ep01, ep02};
//		double sum = getSalary(workers);
//		System.out.println(sum);
		
		Supplies uno = new Supplies("Pencils", 39.95);
		Supplies duo = new Supplies("Tables", 305.95);
		
		Expenses[] e = {ep01,ep02,uno,duo};
		double sum = getCost(e);
		System.out.println(sum);
		
		
	}
	
	public static double getCost(Expenses[] Exp) {
		double sum = 0;
		for (Expenses e: Exp) {
			sum += e.getExpenses();
		}
		
		return sum;
	}

}


