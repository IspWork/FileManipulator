/**
 * Abstract class for a file reader.
 */
package abstact;

import interfaces.Readable;

public abstract class AbstractFileReader implements Readable {
	/**
	 * Path to the file.
	 */
	private String filePath;

	public AbstractFileReader(String filePath) {
		this.setFilePath(filePath);
	}

	public String getFilePath() {
		return filePath;
	}

	private void setFilePath(String filePath) {
		this.filePath = filePath;
	}

}
