class Solution {
    public int lastStoneWeight(int[] stones) {
        List<Integer> temp = heapify(stones);

        if (temp.size() == 2) {
            return temp.get(1);
        }

        while (true) {
            System.out.println("temp" + temp);

            if(temp.size()<=2){
                break;
            }

            int first = remove(temp);
            int second = remove(temp);

            if(temp.size()==1 || first != second){
                add(temp,Math.abs(first-second));
            }

            System.out.println("after traitement : " + temp);
        }


        return temp.get(1);
    }

    public Integer remove(List<Integer> maxHeap) {
        if (maxHeap.size() == 1) {
            return -1;
        }

        if (maxHeap.size() == 2) {
            return maxHeap.remove(maxHeap.size() - 1);
        }

        int maxElt = maxHeap.get(1);
        maxHeap.set(1, maxHeap.remove(maxHeap.size() - 1));

        int i = 1;

        while (2 * i < maxHeap.size()) {
            if (2 * i + 1 < maxHeap.size() && maxHeap.get(2 * i + 1) > maxHeap.get(2 * i)
                && maxHeap.get(2 * i + 1) > maxHeap.get(i)) {
                int temp = maxHeap.get(2 * i + 1);
                maxHeap.set(2 * i + 1, maxHeap.get(i));
                maxHeap.set(i, temp);
                i = 2 * i + 1;
            } else if (maxHeap.get(2 * i) > maxHeap.get(i)) {
                int temp = maxHeap.get(2 * i);
                maxHeap.set(2 * i, maxHeap.get(i));
                maxHeap.set(i, temp);
                i = 2 * i;
            } else {
                break;
            }
        }

        return maxElt;
    }

    public List<Integer> heapify(int[] stones) {
        List<Integer> maxHeap = new ArrayList<>();
        maxHeap.add(0);

        for (int s : stones) {
            maxHeap.add(s);
        }

        int cur = (maxHeap.size() - 1) / 2;

        while (cur > 0) {
            int i = cur;
            while (2 * i < maxHeap.size()) {
                if (2 * i + 1 < maxHeap.size() && maxHeap.get(2 * i + 1) > maxHeap.get(2 * i)
                    && maxHeap.get(2 * i + 1) > maxHeap.get(i)) {
                    int temp = maxHeap.get(2 * i + 1);
                    maxHeap.set(2 * i + 1, maxHeap.get(i));
                    maxHeap.set(i, temp);
                    i = 2 * i + 1;
                } else if (maxHeap.get(2 * i) > maxHeap.get(i)) {
                    int temp = maxHeap.get(2 * i);
                    maxHeap.set(2 * i, maxHeap.get(i));
                    maxHeap.set(i, temp);
                    i = 2 * i;
                } else {
                    break;
                }
            }

            cur--;
        }

        return maxHeap;
    }

    public void add(List<Integer> maxHeap, int value) {
        maxHeap.add(value);

        int i = maxHeap.size() - 1;

        while (i > 1 && maxHeap.get(i) > maxHeap.get(i / 2)) {
            int temp = maxHeap.get(i);
            maxHeap.set(i, maxHeap.get(i / 2));
            maxHeap.set(i/2, temp);
            i = i/2;
        }
    }
}
