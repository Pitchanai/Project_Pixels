package utility;

public class NumberFormat {
	public static String toString(int number) {
		String format = number + "";
		String output = "";
		int n = format.length();
		int i = 0;
		while (i < n) {
			if (n > 3) {
				if (((n - i) % 3) == 0) {
					output = output + format.substring(i, i + 3);
					i += 3;
					if (i != n) {
						output = output + ",";
					}
				} else if (((n - i) % 3) > 0) {
					output = output + format.substring(i, i + ((n - i) % 3)) + ",";
					i += ((n - i) % 3);
				}
			} else if (n <= 3) {
				output = format;
				return output;
			}
		}
		return output;
	}
}
