package bai5;

import java.util.HashMap;

public class Dictionary<K1, K2, Value> {
    private HashMap<Pair<K1, K2>, Value> map;

    public Dictionary() {
        this.map = new HashMap<>();
    }

    public void put(K1 key1, K2 key2, Value value) {
        map.put(new Pair<>(key1, key2), value);
    }

    public Value get(K1 key1, K2 key2) {
        return map.get(new Pair<>(key1, key2));
    }

    public boolean containKey(K1 key1, K2 key2) {
        return map.containsKey(new Pair<>(key1, key2));
    }

    private static class Pair<K1, K2> {
        private K1 key1;
        private K2 key2;

        public Pair(K1 key1, K2 key2) {
            this.key1 = key1;
            this.key2 = key2;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair<?, ?> pair = (Pair<?, ?>) o;
            return key1.equals(pair.key1) && key2.equals(pair.key2);
        }

        @Override
        public int hashCode() {
            int result = key1.hashCode();
            result = 31 * result + key2.hashCode();
            return result;
        }
    }
    public static void main(String[] args) {
        Dictionary<String, Integer, String> dictionary = new Dictionary<>();

        // Thêm các phần tử vào từ điển
        dictionary.put("key1", 1, "value1");
        dictionary.put("key2", 2, "value2");
        dictionary.put("key3", 3, "value3");

        // Kiểm tra xem một khóa có tồn tại trong từ điển hay không
        System.out.println("Contains key 'key2', 2: " + dictionary.containKey("key2", 2));

        // Lấy giá trị từ từ điển
        System.out.println("Value for key 'key1', 1: " + dictionary.get("key1", 1));
    }
}