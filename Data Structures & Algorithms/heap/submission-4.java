class MinHeap {
    private List<Integer> heap;

    public MinHeap() {
        this.heap = new ArrayList<>();
        this.heap.add(0);
    }

    public void push(int val) {
        this.heap.add(val);

        int i = this.heap.size() - 1;

        while (i > 1 && this.heap.get(i / 2) > this.heap.get(i)) {
            int temp = this.heap.get(i);
            this.heap.set(i, this.heap.get(i / 2));
            this.heap.set(i / 2, temp);
            i = i / 2;
        }
    }

    public Integer pop() {
        if (this.heap.size() <= 1) {
            return -1;
        }

        if (this.heap.size() == 2) {
            return this.heap.remove(1);
        }

        int first = this.heap.get(1);

        this.heap.set(1, this.heap.remove(this.heap.size() - 1));

        int i = 1;

        while (i * 2 < this.heap.size()) {
            if ((2 * i + 1 < this.heap.size()) && this.heap.get(2 * i + 1) < this.heap.get(2 * i)
                && this.heap.get(2 * i + 1) < this.heap.get(i)) {
                int temp = this.heap.get(i);
                this.heap.set(i, this.heap.get(2 * i + 1));
                this.heap.set(2 * i + 1, temp);
                i = 2 * i + 1;

            } else if (this.heap.get(2 * i) < this.heap.get(i)) {
                int temp = this.heap.get(i);
                this.heap.set(i, this.heap.get(2 * i));
                this.heap.set(2 * i, temp);
                i = 2 * i;
            } else {
                return first;
            }
        }

        return first;
    }

    public Integer top() {
        if (this.heap.size() <= 1) {
            return -1;
        }
        return this.heap.get(1);
    }

    public void heapify(List<Integer> nums) {
        if(nums.isEmpty()){
            return;
        }


        nums.add(nums.get(0));

        heap = nums;

        int cur = (heap.size() - 1) / 2;

        while (cur > 0) {
            int i = cur;

            while (i * 2 < this.heap.size()) {
                if ((2 * i + 1 < this.heap.size())
                    && this.heap.get(2 * i + 1) < this.heap.get(2 * i)
                    && this.heap.get(2 * i + 1) < this.heap.get(i)) {
                    int temp = this.heap.get(i);
                    this.heap.set(i, this.heap.get(2 * i + 1));
                    this.heap.set(2 * i + 1, temp);
                    i = 2 * i + 1;

                } else if (this.heap.get(2 * i) < this.heap.get(i)) {
                    int temp = this.heap.get(i);
                    this.heap.set(i, this.heap.get(2 * i));
                    this.heap.set(2 * i, temp);
                    i = 2 * i;
                } else {
                    break;
                }
            }
            cur--;
        }
    }
}
