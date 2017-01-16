/**
 * Class that writes the map content to a file.
 */
package models;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import abstact.AbstractMapFileWriter;

public class WriteMapToFile extends AbstractMapFileWriter<Integer, List<String>> {

	public WriteMapToFile(String filePath) {
		super(filePath);
	}

	@Override
	public void write(Map<Integer, List<String>> content) {
		try (PrintWriter pW = new PrintWriter(getFilePath())) {
			int keyValue = 1;
			while (keyValue <= content.size()) {
				for (int i = 0; i < content.get(keyValue).size(); i++) {
					pW.print(content.get(keyValue).get(i) + " ");
				}
				pW.println();
				keyValue++;
			}
			System.out.println("Changes: saved.");
			System.out.println();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

}
