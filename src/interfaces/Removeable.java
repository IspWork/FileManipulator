package interfaces;

public interface Removeable {
	/**
	 * Method for value removal.
	 * 
	 * @param lineIndex - index of the line that contains the desired value
	 * @param valueIndex - value index in the line
	 */
	void remove(int lineIndex, int valueIndex);
}
