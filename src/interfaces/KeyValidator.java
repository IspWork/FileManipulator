package interfaces;

public interface KeyValidator {
	/**
	 * Method that validates the index of a certain key in a map.
	 * 
	 * @param index
	 */
	void validateIndex(int index);

	/**
	 * Method that validates if the two key indexes are the same.
	 * 
	 * @param lineIndex1
	 * @param lineIndex2
	 */
	void checkIndexesEqual(int lineIndex1, int lineIndex2);

	/**
	 * Method that checks if a key/line is empty
	 * 
	 * @param lineIndex
	 */
	void checkLineEmty(int lineIndex);

}
