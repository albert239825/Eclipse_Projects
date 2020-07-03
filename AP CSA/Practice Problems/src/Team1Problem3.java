import java.util.*;
import java.io.*;

public class Team1Problem3 {
  public static void main(String[] args) throws FileNotFoundException {
    Scanner in = new Scanner(System.in);
    int extract = in.nextInt();
    double balance = in.nextDouble();
    in.close();
    
    if (!(extract % 5 == 0)) {
    	System.out.println("ERROR");
    }
    else if (balance - extract < .5) {
    	System.out.println("ERROR");
    }
    else {
    	balance -= (.5 + extract);
        String result = "" + balance;
        if (result.contains(".")) {
        	result += "0";
        }
        else {
        	result += ".00";
        }
        System.out.println(result);
        	
    }
    
  }
}
