package abstact;

import interfaces.MapContentWriter;

public abstract class AbstractMapFileWriter<K, V> implements MapContentWriter<K, V> {
	private String filePath;

	public AbstractMapFileWriter(String filePath) {
		this.setFilePath(filePath);
	}

	public String getFilePath() {
		return filePath;
	}

	private void setFilePath(String filePath) {
		this.filePath = filePath;
	}

}
