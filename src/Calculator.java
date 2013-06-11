import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

	public static int add(String input) {
		int kq=0;
		ArrayList< Integer> numbers =new ArrayList<Integer>();
		if(input==null||input.isEmpty())
			return 0;
		Matcher matcher=Pattern.compile("-?[0-9]+").matcher(input);
		while (matcher.find()) {
			int temp=toInt(matcher.group(0));
			numbers.add(temp);
		}
		for (Integer temp : numbers) {
			kq+=temp;
		}
		
		return kq;
	}
	static int toInt(String input){
		return Integer.parseInt(input);
	}
}
