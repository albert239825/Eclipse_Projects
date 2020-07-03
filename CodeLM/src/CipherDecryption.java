import java.util.*;
public class CipherDecryption {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String plainText = in.nextLine();
		String Encrypted = in.nextLine();
		int[] gaps = getGaps(plainText, Encrypted);
		
		String key = convertString(gaps);
//		System.out.println(Arrays.toString(gaps));
//		System.out.println(key);
		int len = repLen(key);
//		System.out.println(len);
		System.out.println(key.substring(0,len));
	}

	static int[] getGaps (String original, String encrypted) {
		int[] gaps = new int[original.length()];
		for (int i = 0; i < original.length(); i++) {
			char oCur = original.charAt(i);
			char nCur = encrypted.charAt(i);
			if (oCur > nCur) {
				gaps[i] = (nCur - 'a' + 1) + ('z' - oCur);
				
			}
			else {
				gaps[i] = nCur - oCur;
			}
		}
		
		return gaps;
	}
	
	static String convertString(int[] gaps) {
		String output = "";
		for (int i = 0; i < gaps.length; i++) {
			output += (char) ('a' + gaps[i]);
		}
		
		return output;
	}
	
	public static int repLen(String key) {
		for (int i = 1; i < key.length() / 2 + 1; i++) {
			if (key.length() % i == 0) {
				//System.out.println("new Run");
				if (checkRep(key, i)) {
					return i;
				}
			}
		}
		return key.length();
	}

	static boolean checkRep(String key, int len ) {
		for (int i = 0 ; i < key.length() - len; i += len) {
			String first = key.substring(i, i+len);
			String second = key.substring(i+len, i +len*2);
			//System.out.println("new run");
			//System.out.println(first + " " + second);
			if (!(first.equals(second))) {
				//System.out.println("detection bad");
				return false;
			}
		}
		return true;
	}
}




/*
Input 

String plaintext: The word that is hidden using the cipher

String ciphertext: The encrypted word



Output 

A String value that contains the keyword used to 
encipher the plaintext. Keywords can be repeated 
any number times, and may not be the same length 
as the plaintext.

*/