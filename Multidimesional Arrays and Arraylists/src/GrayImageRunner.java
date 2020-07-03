public class GrayImageRunner {

	public static void main(String[] args) {


		int[][] values = { 	{255, 184, 178, 84, 129},
				{84, 255, 255, 130, 94},
				{78, 255, 0, 0, 78},
				{84, 130, 255, 130, 84}};

		GrayImage image = new GrayImage(values);

		// Part A
		System.out.println("count white should be 5 and is " +
				image.countWhitePixels());

		// Part B
		System.out.println(image);
		image.processImage();
		System.out.println("after process image");
		System.out.println(image);		

		// Part C

		System.out.println(image);
		image.flip();
		System.out.println("after flip image");
		System.out.println(image);		
	}

}