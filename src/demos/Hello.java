package demos;

import java.util.Calendar;

public class Hello {
public static void main(String[]argv){
	System.out.println(String.format("Local Time: %tT",
			Calendar.getInstance()));
}
}
