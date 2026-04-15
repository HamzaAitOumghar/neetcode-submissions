class DynamicArray {

    private int[] dynamicArray;
    private int capacity;
    private int size;

    public DynamicArray(int capacity) {
        if(capacity<0){
            throw new RuntimeException("Error");
        }
        this.capacity = capacity;
        this.size = 0;
        this.dynamicArray = new int[capacity];
    }

    public int get(int i) {
        return dynamicArray[i];
    }

    public void set(int i, int n) {
        dynamicArray[i] = n;
    }

    public void pushback(int n) {
        if (size == capacity) {
            resize();
        }
        dynamicArray[size] = n;
        size++;
    }

    public int popback() {
       size--;
       return dynamicArray[size];
    }

    public void resize() {
        this.capacity = 2 * this.capacity;
        int[] newArray = new int[this.capacity];
        for (int i = 0; i < size; i++) {
            newArray[i] = dynamicArray[i];
        }
        dynamicArray = newArray;
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }
}
