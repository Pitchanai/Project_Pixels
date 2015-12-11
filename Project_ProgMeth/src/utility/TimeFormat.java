package utility;

public class TimeFormat {
	public static String minutes (int time) {
		String output = "";
		output = (time / 60) + "";
		return output;
	}
	
	public static String seconds (int time) {
		String output = "";
		if ((time % 60) < 10) {
			output = output + "0" + (time % 60);
		} else {
			output = output + (time % 60);
		}
		return output;
	}

}
