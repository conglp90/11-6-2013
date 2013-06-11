import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

	public static int add(String input) {
		int kq=0;
		if(input==null||input.isEmpty())
			return 0;
		
		if(input.contains("//")){
			String input1=input.substring(0,input.indexOf("\n"));
			Matcher matcher=Pattern.compile("\\[([^\\[]+)\\]").matcher(input1);
			ArrayList<String> delimiters=new ArrayList<String>();
			while (matcher.find()) {
				delimiters.add(matcher.group(1));
				System.out.println(matcher.group(1));
			}
			input=input.substring(input.indexOf("\n"));
			for (String string : delimiters) {
				input=input.replaceAll(Pattern.quote(string),",");
			}
		}
		
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
			if(temp>1000)
				temp=0;
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
