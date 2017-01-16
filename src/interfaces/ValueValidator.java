package interfaces;

public interface ValueValidator {
	/**
	 * Method that validates if the index of the given value is correct.
	 * 
	 * @param valueIndex
	 *            - the index of the value.
	 * @param maxValueIndex
	 *            - the max value index of the Collection that the value is in.
	 */
	void validateIndex(int valueIndex, int maxValueIndex);

	/**
	 * Method that validates if the value is correctly entered.
	 * 
	 * @param value
	 *            - the entered value.
	 */
	void validateValue(String value);

}
