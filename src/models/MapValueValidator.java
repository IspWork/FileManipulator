package models;

import interfaces.ValueValidator;

public class MapValueValidator implements ValueValidator {
	private static final String REGEX_NUMBERS = "[0-9]+";

	@Override
	public void validateIndex(int valueIndex, int maxValueIndex) {
		if (valueIndex >= maxValueIndex && valueIndex != 0) {
			throw new IllegalArgumentException("Incorrect value index.");
		}

	}

	@Override
	public void validateValue(String value) {
		if (!value.matches(REGEX_NUMBERS) || value.charAt(0) == '0') {
			throw new IllegalArgumentException("Invalid number.");
		}
	}
}
