public class GrayImage
{
	public static final int BLACK = 0;
	public static final int WHITE = 255;

	/** The 2-dimensional representation of this image.
	 *  Guaranteed not to be null.
	 *  All values in the array are within the range
	 *  [BLACK, WHITE], inclusive.
	 */
	private int[][] pixelValues;

	/** constructor that takes a 2D array */
	public GrayImage(int[][] theArray)
	{
		pixelValues = theArray;
	}

	/** @return the total number of white pixels in
	 *    this image.
	 * Postcondition: this image has not been changed.
	 */
	
	//Loops though all indicies and checks if 255. If yes then add one to the count
	public int countWhitePixels()
	{ /* to be implemented in part (a) */ 
		int count = 0;
		for (int r = 0; r < pixelValues.length; r++) {
			for (int c = 0; c < pixelValues[0].length; c++) {
				if (pixelValues[r][c] == 255) {
					count++;
				}
			}
		}
		return count;
	}
	
	/**    Processes this image in row-major order and
	    *  decreases the value of each pixel at position (row, col)
	    *  by the value of the pixel at position (row + 2, col + 2)
	    *  if it exists.
	    *  Resulting values that would be less than BLACK are replaced
	    *   by BLACK.
	    *  Pixels for which there is no pixel at
	    *   position (row + 2, col + 2) are unchanged.
	    */
	   public void processImage(){
		   for (int r = 0; r < pixelValues.length - 2; r++) {  //the - 2 in the loops is so that we will never go out of bounds
			   for (int c = 0; c < pixelValues[r].length - 2; c++ ) {
				   pixelValues[r][c] -= pixelValues[r+2][c+2]; //subtraction
				   if (pixelValues[r][c] < 0) { //Checks if value is less than 0 then make the value 0
					   pixelValues[r][c] = 0;
				   }
			   }
		   }
	   }
	   
	   // Also Part B
	   // Write a toString that prints out each row of Pixels on their own line
	   
	   
	   /** 
	    *  	Processes the Image so that the top left pixel is now in the bottom right.
	    *  	Each Pixel is flipped to the opposite side of the image both vertically and horizontally.
	    */
	   public void flip() {
		   int cur = 0;
		   for (int r = 0; r < pixelValues.length / 2; r++) { //In essence you only need to flip the top two rows to flip the entire thing or else you will just reflip yourself
			   for (int c = 0; c < pixelValues[r].length; c++) {
				   cur = pixelValues[r][c]; //Saves value so that we can assign the value we are switch it with
				   //System.out.println("" + r + " " + c);
				   //System.out.println(cur);
				   pixelValues[r][c] = pixelValues[pixelValues.length - r - 1][pixelValues[r].length - c - 1]; //assigns current with the value of the index opposite distance in the array vertically and horizontally
				   pixelValues[pixelValues.length - r - 1][pixelValues[r].length - c - 1] = cur; //Assigns the index opposite distance vertically and horizontally with the original value completing the swap
			   }
		   }
	   }
	   
	   //loops through each index and adds value to string, after each column add a \n to create a new line
	   public String toString() {
		   String s = "";
		   for (int r = 0; r < pixelValues.length; r++ ) {
			   for (int c = 0; c < pixelValues[0].length; c++) {
				   s += pixelValues[r][c] + " ";
			   }
			   s += "\n";
		   }
		   return s;
	   }
}