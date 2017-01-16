/**
 * The file reader.
 */
package models;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import abstact.AbstractFileReader;

public class ReadFromFile extends AbstractFileReader {

	public ReadFromFile(String filePath) {
		super(filePath);
	}

	/**
	 * Reads the file.
	 * 
	 * @returns the file content as a String Array, where each element of the array
	 *          represents a line in the file.
	 */
	@Override
	public String[] read() {
		String line;
		StringBuilder sB = new StringBuilder();
		try (BufferedReader bR = new BufferedReader(new FileReader(getFilePath()))) {
			while ((line = bR.readLine()) != null) {
				if (!line.isEmpty()) {
					sB.append(line).append(".");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sB.toString().split("\\.");
	}
}
