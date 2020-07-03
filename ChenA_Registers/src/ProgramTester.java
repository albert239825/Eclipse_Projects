import java.util.*;
import java.io.*;
public class ProgramTester {

	public static void main(String[] args) {
		int length = 32;
		Registers testRes = new Registers(length);
		for(int i = 0; i < length; i++) {
			testRes.set(i, length-i);
		}

		//Creates file for instructions
		File f = new File("Instructions");
		Scanner sc = null;
		try {
			sc = new Scanner(f);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(testRes);
		ArrayList<Instruction> Instructions = new ArrayList<>();
		//While the text file has lines, execute each line
		while (sc.hasNext()) {
			Instructions.add(new Instruction(sc.nextLine()));
		}
		for (Instruction test : Instructions) {
			test.execute(testRes);
		}
		
		sc.close();
		
		//Print out final results
		System.out.println(testRes);

	}

}
