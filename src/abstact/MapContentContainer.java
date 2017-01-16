/**
 * A container for any Map<K,V> map.
 */
package abstact;

import java.util.HashMap;
import java.util.Map;

public abstract class MapContentContainer<K, V> {
	/**
	 * The content of the map.
	 */
	private Map<K, V> content;

	public MapContentContainer() {
		this.setContent(new HashMap<>());
	}

	public Map<K, V> getContent() {
		return content;
	}

	protected void setContent(Map<K, V> content) {
		this.content = content;
	}

	/**
	 * Method that adds content to the container.
	 * 
	 * @param content
	 */
	public abstract void addContentToContainer(String... content);
}
