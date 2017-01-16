/**
 * Content container for a file that consists only of numbers.
 */
package models;

import java.util.ArrayList;
import java.util.List;

import abstact.MapContentContainer;

public class NumberFileContent extends MapContentContainer<Integer, List<String>> {
	private static final String REGEX_SPACE = "\\s+";
	private static final String REGEX_NUMBERS = "[0-9]+";
	private static final String PREFIX_SPACE = "\u0020";
	private static final String PREFIX_TAB = "\u0009";

	public void addContentToContainer(String... content) {
		int mapKey = 1;
		for (String line : content) {
			validateLine(line);
			getContent().put(mapKey, new ArrayList<>());
			for (String value : splitLine(line)) {
				validateNumber(value);
				getContent().get(mapKey).add(value);
			}
			mapKey++;
		}
	}

	private String[] splitLine(String line) {
		return line.split(REGEX_SPACE);
	}

	/**
	 * Checks if the file line starts with a space or tab.
	 * 
	 * @param line
	 */
	private void validateLine(String line) {
		if (line.startsWith(PREFIX_SPACE) || line.startsWith(PREFIX_TAB)) {
			throw new IllegalArgumentException("Invalid File Content.Lines must not start with space or tab.");
		}
	}

	/**
	 * Checks a number consists only of digits from (0-9) and if it starts with '0'
	 * 
	 * @param number
	 */
	private void validateNumber(String number) {
		if (!number.matches(REGEX_NUMBERS) || number.charAt(0) == '0') {
			throw new IllegalArgumentException("Invalid number or file does not contain only numbers.");
		}
	}

}
