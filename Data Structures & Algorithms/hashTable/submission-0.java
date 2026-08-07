class HashTable {
    public class Pair {
        public Integer key;
        public Integer value;

        public Pair(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }
    }

    private Pair[] bucket;
    private int capacity;
    private int size;

    public HashTable(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        bucket = new Pair[capacity];
    }

    private int hash(Integer key) {
        return key % this.capacity;
    }

    public void insert(int key, int value) {
        int index = hash(key);

        while (true) {
            if (this.bucket[index] == null) {
                this.bucket[index] = new Pair(key, value);
                this.size++;
                if (this.size >= this.capacity / 2) {
                    this.rehash();
                }
                return;
            } else if (this.bucket[index].key == key) {
                this.bucket[index].value = value;
                return;
            }
            index += 1;
            index = index % this.capacity;
        }
    }

    private void rehash() {
        this.capacity = 2 * this.capacity;
        Pair[] newBucket = new Pair[this.capacity];
        Pair[] oldBucket = this.bucket;

        this.bucket = newBucket;
        this.size = 0;

        for (Pair p : oldBucket) {
            if (p != null) {
                this.insert(p.key, p.value);
            }
        }
    }

    public int get(int key) {
        int index = hash(key);

        while (this.bucket[index] != null) {
            if (this.bucket[index].key == key) {
                return this.bucket[index].value;
            }
            index += 1;
            index = index % this.capacity;
        }

        return -1;
    }

    public boolean remove(int key) {
        if (this.get(key) == -1) {
            return false;
        }

        int index = hash(key);

        while (this.bucket[index] != null) {
            if (this.bucket[index].key == key) {
                this.bucket[index] = null;
                this.size -= 1;
                return true;
            }
            index += 1;
            index = index % this.capacity;
        }

        return false;
    }

    public int getSize() {
        return this.size;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public void resize() {
        rehash();
    }
}
