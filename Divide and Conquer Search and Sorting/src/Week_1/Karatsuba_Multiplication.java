package Week_1;

import java.math.BigInteger;
import java.util.*;

public class Karatsuba_Multiplication {
	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		System.out.println("input a");
		String num1 = in.nextLine();
		System.out.println("input b");
		String num2 = in.nextLine();
		//System.out.println(num1 + " " + num2);
		//padding if length odd;
		if (num1.length() % 2 == 1) {
			num1 = "0" + num1;
		}
		if (num2.length() % 2 == 1) {
			num2 = "0" + num2;
		}
		System.out.println(kara_multiply(num1, num2));
	}

	public static long kara_multiply(String num1, String num2) {
		//System.out.println("new call: " + num1 + " " + num2);
		if (num1.length() == 1 && num2.length() == 1) {
			//System.out.println("base");
			return Integer.parseInt(num1) * Integer.parseInt(num2);
		}

		num1 = pad(num1,num2);
		num2 = pad(num2,num1);
		//if ("".equals(num1) || "".equals(num2))
			//return 0;

		System.out.println("padded: " + num1 + " " + num2);
		int n = Math.max(num1.length(), num2.length());
		//gets maximum length divided by 2 rounded up
		n = (n/2) + (n%2);
		//System.out.println(n);
		//get 10 to the power of maximum length
		long m = (long)Math.pow(10, n);
		//gets abcd
		String a,b,c,d;

		a = num1.substring(0,n);
		b = num1.substring(n);
		c = num2 .substring(0,n);
		d = num2.substring(n);

		if (d.length() == 0) {
			d = "0";
		}
		if(b.length() == 0) {
			b = "0";
		}
		System.out.println("a: " + a + " b: " + b + " c: " + c + " d: " + d);

		//ac
		//System.out.println("ac");
		long ac = kara_multiply(a,c);
		//System.out.println("cd");
		//bd
		long bd = kara_multiply(b,d);
		//System.out.println("part3");
		//(ab+cd)
		System.out.println("ab: " + (Long.parseLong(a) + Long.parseLong(b)) + " cd: " + (Long.parseLong(c) + Long.parseLong(d)));
		long part2 = kara_multiply((Long.parseLong(a) + Long.parseLong(b)) + "", (Long.parseLong(c) + Long.parseLong(d)) + "" )  - ac - bd;

		System.out.println("ending " + ac + " " + bd + "  " + part2);
		return (ac * (long)Math.pow(10, n * 2))+ part2 * m + bd; 

	}

	public static String pad(String num1, String num2) {
		int dif = Math.abs(num1.length() - num2.length());
		if (num1.length() < num2.length()) {
			num1 = "0".repeat(dif) + num1;
		}
		return num1;
	}

	public static int getSize(long num)
	{
		int ctr = 0;
		while (num != 0)
		{
			ctr++;
			num /= 10;
		}
		return ctr;
	}
}
