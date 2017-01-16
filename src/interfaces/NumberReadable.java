package interfaces;

public interface NumberReadable {
	/**
	 * Method for reading numbers.
	 * 
	 * @param lineIndex
	 *            - the index of the line that contains the desired number
	 * @param valueIndex
	 *            - the index of the desired number in that line
	 */
	void readNumber(int lineIndex, int valueIndex);
}
