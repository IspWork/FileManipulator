package interfaces;

public interface Modifiable {
	/**
	 * Method that modifies a value.
	 * 
	 * @param lineIndex - index of the line that contains the desired value
	 * @param valueIndex - the index of the value in that line
	 * @param newValue - the modified value
	 */
	void modify(int lineIndex, int valueIndex, String newValue);
}
