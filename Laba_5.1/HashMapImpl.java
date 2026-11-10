import java.util.ArrayList;
import java.util.LinkedList;

public class HashMapImpl<V> implements HashMap<String, V> {
    private static final int TABLE_SIZE = 300007;
    private static final int A = 31;
    private final ArrayList<LinkedList<PairImpl<String, V>>> map = new ArrayList<>();

    public HashMapImpl() {
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
        Integer index = (int) hashByString(key);
        LinkedList<PairImpl<String, V>> cell = map.get(index);
        if (cell == null) {
            cell = new LinkedList<>();
            map.set(index, cell);
        }
        PairImpl<String, V> pair = varInACell(key, cell);
        if (pair != null) {
            pair.setValue(value);
            return;
        }
        PairImpl<String, V> newc = new PairImpl<>(key, value);
        cell.addLast(newc);
    }

    @Override
    public V getValue(String key) {
        LinkedList<PairImpl<String, V>> cell = map.get((int) hashByString(key));
        PairImpl<String, V> pair = varInACell(key, cell);
        if (pair == null) {
            return null;
        }
        return pair.getValue();
    }

    @Override
    public V delete(String key) {
        LinkedList<PairImpl<String, V>> cell = map.get((int) hashByString(key));
        PairImpl<String, V> pair = varInACell(key, cell);
        if (pair != null) {
            V temp = pair.getValue();
            cell.remove(pair);
            if (cell.isEmpty()) {
                cell = null; //чутка уменьшаем расход памяти
            }
            return temp;
        }
        return null;
    }

    private PairImpl<String, V> varInACell(String key, LinkedList<PairImpl<String, V>> cell) {
        if (cell == null) {
            return null;
        }
        for (PairImpl<String, V> i : cell) {
            if (i.getKey().equals(key)) {
                return i;
            }
        }
        return null;
    }
} 