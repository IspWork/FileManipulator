package interfaces;

import java.util.Map;

public interface MapContentWriter<K, V> {
	/**
	 * Method that writes map content.
	 * 
	 * @param content - the Map<K,V> content
	 */
	void write(Map<K, V> content);
}
