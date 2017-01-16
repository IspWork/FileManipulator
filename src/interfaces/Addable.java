package interfaces;

public interface Addable {
	/**
	 * Add a value to a certain line.
	 * 
	 * @param lineIndex - the index of the line
	 * @param valueIndex - on what index of the line do you wish to add the value
	 * @param value - the value to be added
	 */
	void add(int lineIndex, int valueIndex, String value);

}
