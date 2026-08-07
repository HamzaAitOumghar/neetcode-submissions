class BrowserHistory {
    Node head;
    Node tail;
    int size;

    int currentIndex = 0;

    class Node {
        Node next;
        Node prev;
        String val;

        public Node(String val) {
            this.val = val;
        }
    }

    public BrowserHistory(String homepage) {
        Node first = new Node(homepage);
        this.head = first;
        this.tail = first;
        size++;
        currentIndex = size;
    }

    public void visit(String url) {
        Node newNode = new Node(url);

        if (this.currentIndex == this.size) {
            newNode.prev = this.tail;
            this.tail.next = newNode;
            this.tail = newNode;
            size++;
            this.currentIndex++;

        } else {
            Node temp = this.head;

            for (int i = 0; i < this.currentIndex - 1; i++) {
                System.out.println("currentIndex : " + temp.val);
                temp = temp.next;
            }

            temp.next = null;

            newNode.prev = temp;
            temp.next = newNode;
            this.tail = newNode;
            this.size = ++this.currentIndex;

            temp = this.head;
            System.out.println("------------------ : ");
            System.out.println("currentIndex : " + this.currentIndex + "size : " + this.size);

            while (temp != null) {
                System.out.println("currentIndex : " + temp.val);
                temp = temp.next;
            }
        }
    }

    public String back(int steps) {

        if (currentIndex - steps <= 0) {
            return this.head.val;
        }

        currentIndex -= steps;


        Node temp = this.head;

        for (int i = 0; i < currentIndex - 1; i++) {
            temp = temp.next;
        }

        return temp.val;
    }

    public String forward(int steps) {
        if (currentIndex + steps >= this.size) {
            return this.tail.val;
        }
        currentIndex += steps;

        Node temp = this.head;

        for (int i = 0; i < currentIndex - 1; i++) {
            temp = temp.next;
        }

        return temp.val;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */