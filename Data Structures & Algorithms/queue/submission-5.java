class Deque {
    public Node head;
    public Node tail;
    public int size;

    class Node {
        public Node next;
        public Node prev;

        public int value;
        public Node(int value) {
            this.value = value;
        }
    }

    public Deque() {
        this.tail = null;
        this.head = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void append(int value) {
        Node newVal = new Node(value);

        if (this.tail == null) {
            this.head = newVal;
            this.tail = newVal;
        } else {
            newVal.prev = this.tail;

            this.tail.next = newVal;
            this.tail = newVal;
        }

        this.size++;
    }

    public void appendleft(int value) {
        Node newVal = new Node(value);

        if (this.head == null) {
            this.head = newVal;
            this.tail = newVal;
        } else {
            newVal.next = this.head;

            this.head.prev = newVal;
            this.head = newVal;
        }

        this.size++;
    }

    public int pop() {
        if (this.size == 0) {
            return -1;
        }

        int lastVal = this.tail.value;

        Node newTail = this.tail.prev;

        if (newTail != null) {
            newTail.next = null;
            this.tail = newTail;
        } else {
            this.tail = null;
            this.head = null;
        }
        size--;

        return lastVal;
    }

    public int popleft() {
        if (this.size == 0) {
            return -1;
        }
        int lastVal = this.head.value;

        Node newhead = this.head.next;

        if (newhead != null) {
            newhead.prev = null;
            this.head = newhead;

        } else {
            this.head = null;
            this.tail = null;
        }

        size--;
        return lastVal;
    }
}
