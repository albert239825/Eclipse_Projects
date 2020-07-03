import java.util.*;

public class Registers {
	private int[] registers;
	
	//Default constructor
	public Registers() {
		registers = new int[32];
	}
	//given size
	public Registers (int i) {
		registers = new int[i];
	}
	
	//get register
	public int get (int i ) {
		return registers[i];
	}
	
	//set a register
	public void set (int index, int value) {
		registers[index] = value;
	}
	
	public String toString() {
		String print = "";
		for (int i = 0; i < registers.length; i++) {
			print += "R" + i + ": " + registers[i] + " \n";
		}
		
		//print for debug
//		for (int i = 0; i < registers.length; i++) {
//			print += registers[i] + "	";
//		}
		return print;
	}
}
