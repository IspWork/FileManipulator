package models;

import java.util.List;
import java.util.Map;

import abstact.MapContentManipulator;

public class FileContentManipulator extends MapContentManipulator<Integer, List<String>>{

	public FileContentManipulator(Map<Integer, List<String>> content) {
		super(content);
	}

	@Override
	public void add(int lineIndex, int valueIndex, String value) {
		getContent().get(lineIndex).add(valueIndex, value);
	}

	@Override
	public void swapLines(int lineIndex1, int lineIndex2) {
		List<String> tmp = getContent().get(lineIndex1);
		getContent().replace(lineIndex1, getContent().get(lineIndex2));
		getContent().replace(lineIndex2, tmp);
		
	}

	@Override
	public void readNumber(int lineIndex, int valueIndex) {
		System.out.println("Your number is: " + getContent().get(lineIndex).get(valueIndex));
		
	}

	@Override
	public void swapNumbers(int lineIndex1, int lineIndex2, int valueIndex1, int valueIndex2) {
		String tmpNumber = getContent().get(lineIndex1).get(valueIndex1);
		getContent().get(lineIndex1).set(valueIndex1, getContent().get(lineIndex2).get(valueIndex2));
		getContent().get(lineIndex2).set(valueIndex2, tmpNumber);
		
	}

	@Override
	public void remove(int lineIndex, int valueIndex) {
		getContent().get(lineIndex).remove(valueIndex);
		
	}

	@Override
	public void modify(int lineIndex, int valueIndex, String newValue) {
		getContent().get(lineIndex).set(valueIndex, newValue);
		
	}

}
