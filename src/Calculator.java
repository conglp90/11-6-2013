import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

	public static int add(String input) {
		int kq=0;
		if(input==null||input.isEmpty())
			return 0;
		ArrayList< Integer> numbers = toArrayListNumbers(input);
		checkNegatives(numbers);
		return sum(numbers);
	}
	
	private static void checkNegatives(ArrayList<Integer> numbers) {
		String negatives="negatives not allowed:";
		boolean isNegatives=false;
		for (int integer : numbers) {
			if (integer<0) {
				negatives+= isNegatives ? ", "+integer : " "+integer;
				isNegatives=true;
			}
		}
		if(isNegatives)
			throw new RuntimeException(negatives);
	}
	
	private static int sum(ArrayList<Integer> numbers) {
		int kq=0;
		for (Integer temp : numbers) {
			kq+=temp;
		}
		return kq;
	}
	
	private static ArrayList<Integer> toArrayListNumbers(String input) {
		ArrayList< Integer> numbers =new ArrayList<Integer>();
		Matcher matcher=Pattern.compile("-?[0-9]+").matcher(input);
		while (matcher.find()) {
			int temp=toInt(matcher.group(0));
			numbers.add(temp);
		}
		return numbers;
	}
	
	private static int toInt(String input){
		return Integer.parseInt(input);
	}
}
