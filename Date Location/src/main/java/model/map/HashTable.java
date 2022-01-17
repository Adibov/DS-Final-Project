package model.map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class HashTable<K, V> {
    final private HashFunction hashFunction;
    private Bucket<K, V>[] buckets;
    private int currentSize;
    private int keyCount;

    final private int INITIAL_SIZE = 16;
    final private double EXTENDING_COEFFICIENT = 0.75;
    final private double SHRINKING_COEFFICIENT = 0.25;

    public HashTable(HashFunction hashFunction) {
        this.hashFunction = hashFunction;
        this.buckets = (Bucket<K, V>[]) new Bucket[INITIAL_SIZE];
        this.currentSize = INITIAL_SIZE;
        this.keyCount = 0;
        initializeBuckets();
    }

    public HashTable(HashMap<K, V> map, HashFunction hashFunction) {
        this.hashFunction = hashFunction;
        this.buckets = (Bucket<K, V>[]) new Bucket[INITIAL_SIZE];
        this.currentSize = INITIAL_SIZE;
        this.keyCount = 0;
        initializeBuckets();

        for (var pair : map.entrySet())
            put(pair.getKey(), pair.getValue());
    }

    private void initializeBuckets() {
        for (var i = 0; i < buckets.length; i++)
            buckets[i] = new Bucket<>();
    }

    public void put(K key, V value) {
        var hashedKey = hashFunction.computeHash(key.toString(), currentSize);
//        System.out.println("hashedKey: " + hashedKey);
        if (!buckets[hashedKey].contains(key))
            keyCount++;
        buckets[hashedKey].add(key, value);
        checkResizing();
    }

    public V get(K key) {
        var hashedKey = hashFunction.computeHash(key.toString(), currentSize);
        return buckets[hashedKey].get(key);
    }

    public void remove(K key) {
        var hashedKey = hashFunction.computeHash(key.toString(), currentSize);
        if (buckets[hashedKey].contains(key))
            keyCount--;
        buckets[hashedKey].remove(key);
        checkResizing();
    }

    private void checkResizing() {
        if ((int)(EXTENDING_COEFFICIENT * currentSize) < keyCount) {
            currentSize *= 2;
            reAddPairs();
        }
        else if ((int)(SHRINKING_COEFFICIENT * currentSize) > keyCount && currentSize > INITIAL_SIZE) {
            currentSize /= 2;
            reAddPairs();
        }
    }

    private void reAddPairs() {
        ArrayList<Pair<K, V>> pairs = new ArrayList<>();
        for (var bucket : buckets) {
            pairs.addAll(bucket.getPairs());
            bucket.clear();
        }
        buckets = (Bucket<K, V>[]) new Bucket[currentSize];
        initializeBuckets();

        for (var pair : pairs) {
            var hashedKey = hashFunction.computeHash(pair.getKey().toString(), currentSize);
            buckets[hashedKey].add(pair.getKey(), pair.getValue());
        }
    }

    @Override
    public String toString() {
        return "HashTable{" +
                "buckets=" + Arrays.toString(buckets) +
                ", currentSize=" + currentSize +
                ", keyCount=" + keyCount +
                '}';
    }
}
