class LinkedList {

    public class Node {
        int value;
        Node next;

        public Node (int value , Node next){
            this.value = value;
            this.next = next;
        }
    }

    private Node head;
    private Node tail;
    private int size;



    public LinkedList() {
        this.head=null;
        this.tail=null;
        this.size = 0;
    }

    public int get(int index) {
        int i = 0 ;

        Node temp = this.head;
        
        while(temp!=null){
            if(i==index){
                return temp.value;
            }
            temp = temp.next;
            i++;
        }

        return -1 ;

    }

    public void insertHead(int val) {
        Node newNode = new Node(val, this.head);
        this.head = newNode;
        if (this.tail == null) {
            this.tail = newNode;
        }
        this.size++;

    }

    public void insertTail(int val) {
        Node newNode = new Node(val,null);
        if (this.tail == null) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.tail.next = newNode;
            this.tail = newNode;
        }
        
        this.size ++ ;

    }

    public boolean remove(int index) {
    
    if (index < 0 || index >= this.size) {
        return false;
    }

    if (index == 0) {
        this.head = this.head.next;
        this.size--;
        if (this.head == null) {
            this.tail = null;
        }
        return true;
    }
    
    Node temp = this.head;
    Node prev = null;
    int i = 0;

    while (i < index) {
        prev = temp;
        temp = temp.next;
        i++;
    }
       
   prev.next = temp.next;

    if (temp == this.tail) {
        this.tail = prev;
    }

    this.size--;
    return true;
        

    }

    public ArrayList getValues(){

        ArrayList<Integer> list = new ArrayList<>();
        Node temp = this.head;
        while(temp!=null){
            list.add(temp.value);
            temp= temp.next;
        }

        return list;
    }





}


