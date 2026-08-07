

class MyLinkedList {
    class NodeList {
        public NodeList next;
        public int val;

        public NodeList(int val) {
            this.val = val;
        }
    }

    private NodeList head;
    private NodeList tail;

    public MyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public int get(int index) {
        if (index < 0) {
            return -1;
        }

        int i = 0;
        NodeList temp = this.head;

        while (temp != null) {
            if (i == index) {
                return temp.val;
            }
            temp = temp.next;
            i++;
        }

        return -1;
    }

    public void addAtHead(int val) {
        NodeList newHead = new NodeList(val);

        if (this.head == null) {
            this.head = newHead;
            this.tail = newHead;
        } else {
            newHead.next = this.head;
            this.head = newHead;
        }
    }

    public void addAtTail(int val) {
        NodeList newTail = new NodeList(val);
        if (this.tail == null) {
            this.head = newTail;
            this.tail = newTail;
        } else {
            this.tail.next = newTail;
            this.tail = newTail;
        }
    }

    public void addAtIndex(int index, int val) {
        if (index == 0) {
            addAtHead(val);
            return;
        } else {
            NodeList temp = this.head;

            int i = 0;
            while (temp != null && i < index - 1) {
                temp = temp.next;
                i++;
            }

            if (temp == null) {
                return;
            }

            NodeList newNode = new NodeList(val);
            newNode.next = temp.next;
            temp.next = newNode;

            if (newNode.next == null) {
                this.tail = newNode;
            }
        }
    }

    public void deleteAtIndex(int index) {
        if (index == 0) {
            this.head = this.head.next;

            if (this.head == null) {
                this.tail = null;
            }
            return;

        } else {
            NodeList temp = this.head;
            int i = 0;
            while (temp != null && i < index - 1) {
                temp = temp.next;
                i++;
            }

            if (temp == null || temp.next == null) {
                return;
            }

            if (temp.next == this.tail) {
                this.tail = temp;
            }

            temp.next = temp.next.next;
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */