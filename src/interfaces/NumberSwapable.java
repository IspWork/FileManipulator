package interfaces;

public interface NumberSwapable {
	/**
	 * Method for swapping numbers.
	 * 
	 * @param lineIndex1 - the index of the first line that contains the first desired number
	 * @param lineIndex2 - the index of the second line that contains the second desired number
	 * @param valueIndex1 - the desired number index in the first line
	 * @param valueIndex2 - the desired number index in the second line
	 */
	void swapNumbers(int lineIndex1, int lineIndex2, int valueIndex1, int valueIndex2);

}
