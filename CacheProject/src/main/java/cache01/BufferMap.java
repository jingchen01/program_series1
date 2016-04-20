package cache01;

import java.util.ArrayList;
import java.util.HashMap;

/*--------------------------------------------------------- * 
Problem Description:
java FIFO cache
 *---------------------------------------------------------*/
public class BufferMap<K, V> {
	private static final int QUEUE_LEN = 4;
	ArrayList<HashMap<K, V>> queue = new ArrayList<>();
	private final int buffersize;// size of BufferMap

	public BufferMap(int buffersize) {
		this.buffersize = buffersize;
		for (int i = 0; i < QUEUE_LEN; i++) {
			queue.add(new HashMap<K, V>());
		}
	}

	public void put(K key, V value) {
		if (queue.get(queue.size() - 1).size() >= buffersize / QUEUE_LEN
				&& !queue.get(queue.size() - 1).containsKey(key)) {
			HashMap<K, V> oldestMap = queue.remove(0);// remove the oldest map
			oldestMap.clear();// remove all items in the oldest map
			queue.add(oldestMap);// add clean oldestMap to queue
		}
		queue.get(queue.size() - 1).put(key, value);
	}

	public V get(K key) {
		for (HashMap<K, V> hm : queue) {
			if (hm.containsKey(key)) {
				return hm.get(key);
			}
		}
		return null;
	}
}
