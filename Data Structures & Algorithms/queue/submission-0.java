class Deque {
    private List<Integer> data;

    public Deque() {
        data = new ArrayList<>();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    public void append(int value) {
        data.add(0, value);
    }

    public void appendleft(int value) {
        data.add(value);
    }

    public int pop() {

        if(data.isEmpty()){
            return -1;
        }

        return data.remove(0);
    }

    public int popleft() {
        if(data.isEmpty()){
            return -1;
        }
        return data.remove(data.size()-1);
    }
}
