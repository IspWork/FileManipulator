package abstact;

import java.util.Map;

import interfaces.Manipulator;

public abstract class MapContentManipulator<K,V> implements Manipulator {
	/**
	 * A container, from which the manipulator will operate over the data.
	 */
	private Map<K, V> content;

	public MapContentManipulator(Map<K, V> content) {
		this.setContent(content);
	}
	public int size(){
		return content.size();
	}

	public Map<K, V> getContent() {
		return content;
	}

	private void setContent(Map<K, V> content) {
		this.content = content;
	}
}
