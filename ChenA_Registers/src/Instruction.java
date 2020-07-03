
public class Instruction {
	String binary;
	String operation;
	String destination;
	String src1;
	String src2;
	String shift;
	
	public Instruction (String bin) {
		binary = bin;
		operation = binary.substring(0, 5);
		destination = binary.substring(5, 11);
		src1 = binary.substring(11, 17);
		src2 = binary.substring(17, 23);
		shift = binary.substring(binary.length() - 9);
		
	}
	
	//converts from binary to int
	public int convertBin (String bin) {
		int dec = 0;
		//System.out.println(bin);
		for (int i = bin.length(); i > 0; i--) {
			//System.out.println(i);
			//Multiplying value at that point to the power of 2 that space represents
			dec += Integer.parseInt(bin.substring(i - 1, i)) * Math.pow(2, (bin.length() - i));
			//Debug
			//System.out.println("value: " + bin.substring(i - 1, i));
			//System.out.println("power: " + Math.pow(2, (bin.length() - i)));
			//System.out.println(dec);
		}
		
		//System.out.println(dec);
		return dec;
	}
	
	//converts int to binary
	public String convertInt(int n) { 
		//If 0, this following code doesn't work
		if (n == 0) {
			return "0";
		}
        // array to store binary number 
        int[] binary = new int[100]; 
        String bin = "";
        // counter for binary array 
        int i = 0; 
        while (n > 0)  { 
            // storing remainder in binary array 
            binary[i] = n % 2; 
            n = n / 2; 
            i++; 
        } 
   
        // printing binary array in reverse order for proper binary placing
        for (int j = i - 1; j >= 0; j--) {
            bin += "" + binary[j]; 
        }
        return bin;
    } 
	
	public void execute (Registers reg) {
		//int value of binary
		int DecOp = convertBin(operation);
		int DecDes = convertBin(destination);
		int DecSrc1 = convertBin(src1);
		int DecSrc2 = convertBin(src2);
		int DecShift = convertBin(shift);
		//Debug
//		System.out.println(DecOp);
//		System.out.println(operation);
//		System.out.println(DecDes);
//		System.out.println(destination);
//		System.out.println(DecSrc1);
//		System.out.println(src1);
//		System.out.println(DecSrc2);
//		System.out.println(src2);
//		System.out.println(DecShift);
//		System.out.println(shift);
		
		//add
		if (DecOp == 1) {
			System.out.println("R" + DecDes + " = " + "R" + DecSrc1 + " + R" + DecSrc2);
			reg.set(DecDes, reg.get(DecSrc1) + reg.get(DecSrc2));
		}
		//sub
		if (DecOp == 2) {
			int value = reg.get(DecSrc1) - reg.get(DecSrc2);
			//if the difference is negative, then get absolute value
			if (value < 0) {
				System.out.println("negative value wrapped back to positive");
				value = Math.abs(value);
			}
			System.out.println("R" + DecDes + " = " + "R" + DecSrc1 + " - R" + DecSrc2);
			reg.set(DecDes, value);
		}
		//mult
		if (DecOp == 3) {
			System.out.println("R" + DecDes + " = " + "R" + DecSrc1 + " * R" + DecSrc2);
			int result = reg.get(DecSrc1) * reg.get(DecSrc2);
			//Debug
			//reg.set(DecDes, result);
			//Checks if either is 0
			if (result == 0) {
				reg.set(DecDes, 0);
			}
			//checks for integer overflow
			else if (reg.get(DecSrc1) == (result / reg.get(DecSrc2))) {
		    	reg.set(DecDes, result);
		    }
		    else {
		    	System.out.println(reg.get(DecSrc1));
		    	System.out.println(reg.get(DecSrc2));
		        System.out.println("multiplication Integer Overflow"); 
		    }
		}
		//div
		if (DecOp == 4) {
			//If the denominator is 0, stop the division
			if (reg.get(DecSrc2) == 0) {
				System.out.println("setting destination to 0; division by 0");
				reg.set(DecDes, 0);
			}
			else {
				
				reg.set(DecDes, reg.get(DecSrc1) / reg.get(DecSrc2));
			}
			System.out.println("R" + DecDes + " = " + "R" + DecSrc1 + " / R" + DecSrc2);
		}
		//left shift
		if (DecOp == 5) {
			System.out.println("R" + DecDes + " = " + "R" + DecSrc1 + " << " + DecShift);
			int value = reg.get(DecSrc1);
			String cur = convertInt(value);
			//If the left shift exceeds the bit amount of an integer, stop the shift
			if (DecShift + cur.length() > 32) {
				System.out.println("cannot shift");
			}
			//adds x number of 0 at the end
			else {
				System.out.print(cur + " << " + DecShift + " -> ");
				for (int i = 0; i < DecShift; i++) {
					cur += "0";
				}
				System.out.println(cur);
			}
			value = convertBin(cur);
			reg.set(DecDes, value);
			
		}
		//right shift
		if (DecOp == 6) {
			System.out.println("R" + DecDes + " = " + "R" + DecSrc1 + " >> " + DecShift);
			int value = reg.get(DecSrc1);
			String cur = convertInt(value);
			System.out.print(cur + " >> " + DecShift + " -> ");
			//If the right shift is greater than the length of the binary, set to 0
			if (DecShift >= cur.length()) {
				cur = "0";
			}
			//removes the last x digits of the binary
			else {
				cur = cur.substring(0, cur.length() - DecShift);
			}
			System.out.println(cur);
			value = convertBin(cur);
			reg.set(DecDes, value);
		}
		
		//Rot
		if (DecOp == 7) {
			System.out.println("R" + DecDes + " = " + "R" + DecSrc1 + " ROT " + DecShift);
			int value = reg.get(DecSrc1);
			String cur = convertInt(value);
			//print out
			System.out.print(cur + " ROT " + DecShift + " -> ");
			//Checks that there is something to rotate so that % works
			if (cur.length() != 0) {
				//Shifts last character to the front
				for (int i = 0 ; i < (DecShift % cur.length()); i++) {
					String last = cur.substring(cur.length()-1);
					cur = last + cur.substring(0, cur.length()-1);
				}
			}
			System.out.println(cur);
			value = convertBin(cur);
			reg.set(DecDes, value);
			
		}
		
		//Load
		if (DecOp == 8) {
			System.out.println("Register " + DecDes + " increased by " + DecShift+ " and is now " + (reg.get(DecDes) + DecShift));
			System.out.println("LD R" + DecDes + " " + DecShift);
			//Adds shift to Destination
			reg.set(DecDes, (reg.get(DecDes) + DecShift));
		}
		
		//Jump (not doing)
		if (DecOp == 9) {
			System.out.println("JMP" + DecDes + " " + DecSrc1 + " " + DecSrc2 + " " + DecShift);
		}
	}
	
}
