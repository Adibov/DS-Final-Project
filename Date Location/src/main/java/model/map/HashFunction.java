package model.map;

public class HashFunction {
    final private int BASE = 31;

    public int computeHash(String key, int mod) {
        var resultHash = 0;
        for (var c : key.toCharArray())
            resultHash = (resultHash * BASE % mod + c) % mod;
        return resultHash;
    }
}
