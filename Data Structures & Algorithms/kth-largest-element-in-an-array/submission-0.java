class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        List<Integer> temp = new ArrayList<>();

        for(int i : nums){
            temp.add(i);
        }

        heapify(temp);

        int j = 0;
        int sol = 0;
        while(j<k){
            sol = remove(temp);
            j++;
        }

        return sol;


    }

    public void heapify(List<Integer> heap) {
        heap.add(heap.get(0));

        int curr = (heap.size() - 1) / 2;

        while (curr >= 1) {
            int i = curr;

            while (heap.size() > 2 * i) {
                if (heap.size() > 2 * i + 1 && heap.get(2 * i + 1) > heap.get(2 * i)
                    && heap.get(i) < heap.get(2 * i + 1)) {
                    swap(heap, i, 2 * i + 1);
                    i = 2 * i + 1;
                } else if (heap.get(i) < heap.get(2 * i)) {
                    swap(heap, i, 2 * i);
                    i = 2 * i;
                } else {
                    break;
                }
            }

            curr--;
        }
    }

    public Integer remove(List<Integer> heap) {
        if (heap.size() <= 1) {
            return -1;
        }

        if (heap.size() == 2) {
            return heap.remove(1);
        }

        Integer max = heap.get(1);
        heap.set(1, heap.remove(heap.size() - 1));

        int i = 1;

        while (heap.size() > 2 * i) {
            if (heap.size() > 2 * i + 1 && heap.get(2 * i + 1) > heap.get(2 * i)
                && heap.get(i) < heap.get(2 * i + 1)) {
                swap(heap, i, 2 * i + 1);
                i = 2 * i + 1;
            } else if (heap.get(i) < heap.get(2 * i)) {
                swap(heap, i, 2 * i);
                i = 2 * i;
            } else {
                break;
            }
        }

        return max;
    }

    public void swap(List<Integer> heap, int a, int b) {
        int temp = heap.get(a);
        heap.set(a, heap.get(b));
        heap.set(b, temp);
    }
}
