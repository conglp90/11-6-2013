import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

	public static int add(String input) {
		int kq=0;
		if(input==null||input.isEmpty())
			return 0;
		kq=toInt(input);
		return kq;
	}
	static int toInt(String input){
		return Integer.parseInt(input);
	}
}
