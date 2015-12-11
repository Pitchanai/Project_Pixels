package utility;

public class RandomUtility {
	public static int integer(int a, int b) {
		int output = (int) (Math.random() * (b + 1)) + a;
		return output;
	}
	
	public static int[] shape(int b) {
		int[] output = new int[4];
		for (int i = 0; i < output.length; i++) {
			output[i] = (int) (Math.random() * b);
		}
		return output;
	}
	
}
