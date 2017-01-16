package models;

import interfaces.KeyValidator;

public class MapKeyValidator implements KeyValidator {
	private int keySize;

	public MapKeyValidator(int keySize) {
		this.keySize = keySize;
	}

	@Override
	public void validateIndex(int index) {
		if(index > keySize){
			throw new IllegalArgumentException("Invalid Line Index.");
		}
	}

	@Override
	public void checkIndexesEqual(int lineIndex1, int lineIndex2) {
		if(lineIndex1 == lineIndex2){
			throw new IllegalArgumentException("Line indexes are the same.");
		}
		
	}

	@Override
	public void checkLineEmty(int lineIndex) {
		if(lineIndex == 0){
			throw new IllegalArgumentException("Line is empty");
		}
		
	}

	

}
