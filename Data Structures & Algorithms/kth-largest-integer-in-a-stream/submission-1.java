class KthLargest {
    private List<Integer> heap;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.heap = new ArrayList<>();
        this.heap.add(0);

        for (int n : nums) {
            push(n);
        }
        System.out.println("before : " + this.heap);

        while(this.heap.size()>k+1){
            pop();
        }

        System.out.println("after : " + this.heap);


        this.k = k;
    }

    private void push(int val) {
        this.heap.add(val);

        int i = this.heap.size() - 1;

        while (i > 1 && heap.get(i) < heap.get(i / 2)) {
            // swap
            int temp = heap.get(i);
            heap.set(i, heap.get(i / 2));
            heap.set(i / 2, temp);
            i = i / 2;
        }

    }

    public int add(int val) {
        push(val);
        if(this.heap.size()>this.k+1){
            pop();
        }
        System.out.println(this.heap);
        return this.heap.get(this.heap.size() - k);
    }

    private Integer pop() {
        if (this.heap.size() == 1) {
            return null;
        }

        if (this.heap.size() == 2) {
            return this.heap.remove(this.heap.size() - 1);
        }

        int rootVal = this.heap.get(1);
        //
        this.heap.set(1, this.heap.remove(this.heap.size() - 1));

        int i = 1;

        while (2 * i < this.heap.size()) {
            if (2 * i + 1 < heap.size() && heap.get(2 * i + 1) < heap.get(2 * i)
                && heap.get(i) > heap.get(2 * i + 1)) {
                int temp = heap.get(i);
                heap.set(i, heap.get(2 * i + 1));
                heap.set(2 * i + 1, temp);
                i = 2 * i + 1;

            } else if (heap.get(i) > heap.get(2 * i)) {
                int tmp = heap.get(i);
                heap.set(i, heap.get(2 * i));
                heap.set(2 * i, tmp);
                i = 2 * i;
            } else {
                break;
            }
        }

        return rootVal;
    }
}
