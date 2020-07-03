import java.util.*;
import java.io.*;

public class Team1Problem2 {
  public static void main(String[] args) throws FileNotFoundException {
    Scanner in = new Scanner(System.in);
    String input = in.nextLine();
    in.close();
    int result = 0;
    input = "9780921418" + input;
    for (int i = 0; i < 13; i++) {
    	int cur = Integer.parseInt(input.substring(i, i+1));
    	if (i % 2 == 0) {
    		result += cur * 1;
    	}
    	else {
    		result += cur * 3;
    	}
    }
    
    if (result % 10 == 0) {
    	System.out.print(result);
    	System.out.println(" YES");
    }
    else {
    	System.out.print(result);
    	System.out.println(" NO");
    }

  }
}
