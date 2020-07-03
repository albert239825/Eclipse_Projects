import java.util.*;
import java.io.*;

public class Team1Problem4 {
  public static void main(String[] args) throws FileNotFoundException {
    Scanner in = new Scanner(System.in);
    
    String nums = "" + in.nextInt();
    int numWords = in.nextInt();
    String words = in.nextLine();
    in.close();
    if(words.charAt(0) == ' ') words = words.substring(1);
    String[] split = words.split(" ");
    
    String[] splitNums = new String[split.length];
    
    for(int i = 0; i < split.length;i++) {
    	String add = "";
    	for(int c = 0; c < split[i].length();c++) {
    		
    		if(split[i].charAt(c) == 'a' || split[i].charAt(c) == 'b' || split[i].charAt(c) == 'c') {
    			add += 2;
    		}
    		else if(split[i].charAt(c) == 'd' || split[i].charAt(c) == 'e' || split[i].charAt(c) == 'f') {
    			add += 3;
    		}
    		else if(split[i].charAt(c) == 'g' || split[i].charAt(c) == 'h' || split[i].charAt(c) == 'i') {
    			add += 4;
    		}
    		else if(split[i].charAt(c) == 'j' || split[i].charAt(c) == 'k' || split[i].charAt(c) == 'l') {
    			add += 5;
    		}
    		else if(split[i].charAt(c) == 'm' || split[i].charAt(c) == 'n' || split[i].charAt(c) == 'o') {
    			add += 6;
    		}
    		else if(split[i].charAt(c) == 'p' || split[i].charAt(c) == 'q' || split[i].charAt(c) == 'r' || split[i].charAt(c) == 's') {
    			add += 7;
    		}
    		else if(split[i].charAt(c) == 't' || split[i].charAt(c) == 'u' || split[i].charAt(c) == 'v') {
    			add += 8;
    		}
    		else if(split[i].charAt(c) == 'w' || split[i].charAt(c) == 'x' || split[i].charAt(c) == 'y' || split[i].charAt(c) == 'z') {
    			add += 9;
    		}
    	}
    	
    	splitNums[i] = add;
    }
    ArrayList<String> matches = new ArrayList<String>();
    for(int i = 0; i < splitNums.length; i++) {
    	if(splitNums[i].contains(nums)) {
    		matches.add(split[i]);
    	}
    }
    if(matches.size() > 1) {
    	System.out.print(matches.size() + " matches ");
    	for(int i = 0; i < matches.size(); i++) {
    		System.out.print(matches.get(i) + " ");
    	}
    }
    else if(matches.size() == 1) {
    	System.out.println(matches.get(0));
    }
    else {
    	System.out.println("No Matches");
    }
  }
}
