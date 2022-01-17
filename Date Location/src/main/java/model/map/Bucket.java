package model.map;

import java.util.ArrayList;
import java.util.List;

public class Bucket<K, V> {
    final private List<Pair<K, V>> pairs;

    public Bucket() {
        this.pairs = new ArrayList<>();
    }

    public void add(K key, V value) {
        if (contains(key))
            return;
        pairs.add(new Pair<>(key, value));
    }

    public boolean contains(K key) {
        for (var pair : pairs)
            if (pair.getKey().equals(key))
                return true;
        return false;
    }

    public V get(K key) {
        for (var pair : pairs)
            if (pair.getKey().equals(key))
                return pair.getValue();
        return null;
    }

    public void remove(K key) {
        var iterator = pairs.iterator();
        while (iterator.hasNext()) {
            var pair = iterator.next();
            if (pair.getKey().equals(key)) {
                iterator.remove();
                break;
            }
        }
    }

    public void clear() {
        pairs.clear();
    }

    public ArrayList<Pair<K, V>> getPairs() {
        return new ArrayList<>(pairs);
    }

    @Override
    public String toString() {
        return "Bucket{" +
                "pairs=" + pairs +
                '}';
    }
}
