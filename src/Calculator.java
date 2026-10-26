import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

	// Pre-compiled regex pattern for searching custom delimiter declarations like [delimiter]
	private static final Pattern BRACKET_DELIMITER_PATTERN = Pattern.compile("\\[([^\\[]+)\\]");

	// Pre-compiled regex pattern for extracting integers (including negative numbers)
	private static final Pattern NUMBER_PATTERN = Pattern.compile("-?[0-9]+");

	/**
	 * Adds numbers contained within the input string.
	 * Optimized to reduce object allocation and avoid costly string re-parsing operations.
	 */
	public static int add(String input) {
		if (input == null || input.isEmpty()) {
			return 0;
		}

		if (input.startsWith("//")) {
			input = processDelimiter(input);
		}

		Matcher matcher = NUMBER_PATTERN.matcher(input);
		int sum = 0;
		StringBuilder negatives = null;

		// Extract numbers and accumulate sum and negative numbers in a single pass
		while (matcher.find()) {
			int temp = Integer.parseInt(matcher.group());
			if (temp < 0) {
				if (negatives == null) {
					negatives = new StringBuilder("negatives not allowed: ").append(temp);
				} else {
					negatives.append(", ").append(temp);
				}
			} else if (temp <= 1000) {
				sum += temp;
			}
		}

		if (negatives != null) {
			throw new RuntimeException(negatives.toString());
		}

		return sum;
	}

	private static String processDelimiter(String input) {
		int newLineIdx = input.indexOf('\n');
		if (newLineIdx == -1) {
			return input;
		}

		String header = input.substring(0, newLineIdx);
		String body = input.substring(newLineIdx);

		Matcher matcher = BRACKET_DELIMITER_PATTERN.matcher(header);
		boolean foundDelimiter = false;

		while (matcher.find()) {
			String delimiter = matcher.group(1);
			body = body.replaceAll(Pattern.quote(delimiter), ",");
			foundDelimiter = true;
		}

		// If no bracketed delimiter was found, check if there's a single char delimiter specified after //
		if (!foundDelimiter && header.length() > 2) {
			String delimiter = header.substring(2);
			body = body.replaceAll(Pattern.quote(delimiter), ",");
		}

		return body;
	}
}
