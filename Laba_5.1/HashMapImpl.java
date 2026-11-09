import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map.Entry;

public class HashMapImpl<V> implements HashMap<String, V> {
    private static final int TABLE_SIZE = 300007;
    private static final int A = 31;
    private final ArrayList<LinkedList<PairImpl<String, V>>> map = new ArrayList<>();

    public void HashMapImpl() {
        for (int i = 0; i < TABLE_SIZE; i++) {
            map.add(null);
        }
    }

    private long hashByString(String value) {
        long hash = 0;
        for (Character ch : value.toCharArray()) {
            hash = (hash * A + ch) % TABLE_SIZE;
        }
        return hash;
    }

    @Override
    public void put(String key, V value) {
        LinkedList<Pair<String, V>> cell = map.get(hashByString(key));
        Pair<String, V> c = varInACell(key, cell);
        if (varInACell(c != null) {
            c.setValue(value);
            return;
        }
        Pair newc = Map.entry(key, value);

    }

    @Override
    public V getValue(String key) {
	// TODO
        return null;
    }

    @Override
    public V delete(String key) {
	// TODO
        return null;
    }

    private Pair varInACell(String key, LinkedList<Pair> cell) {
        for (Pair i : cell) {
            if (i.getKey() == key) {
                return i;
            }
        }
        return null;
    }
} 