package MayCookOff2020;


import java.util.*;
import java.io.*;
class CHEFSHIP {
	public static void main(String[] args) {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			int t = Integer.parseInt(reader.readLine());
			//System.out.println(t);
			PrintWriter w = new PrintWriter(System.out);
			String[] words = new String[t];
			String out = "";
			for (int i = 0; i < t; i++) {
				words[i] = reader.readLine();

				int pos = 0;

				for (int j = 2; j <= words[i].length() - 2; j += 2) {
					//System.out.println();
					//System.out.println("here");
					String front = words[i].substring(0,j);
					String end = words[i].substring(j, words[i].length());
//					System.out.println(front);
//					System.out.println(end);
					int front1 = front.substring(0, front.length() / 2).hashCode();
					int front2 = front.substring(front.length() / 2, front.length()).hashCode();
					int end1 = end.substring(0, (end.length()/2)).hashCode();
					int end2 = end.substring(end.length() / 2, end.length()).hashCode();
					System.out.println("check");
					if (front1 == front2 && end1 == end2) {
						pos++;
					}
				}
				out += pos + "\n";
			}
			w.print(out);
			w.close();
		}
		catch (Exception e) {
			
		}
	}
}
