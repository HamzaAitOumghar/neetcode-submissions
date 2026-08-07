class Solution {
    public int lastStoneWeight(int[] stones) {

        if(stones.length==1){
            return stones[0];
        }
        sortArray(stones);

        if(stones.length==2){
            return stones[0]-stones[1];
        }
        // sorting

            System.out.println(Arrays.toString(stones));

        int length = stones.length;

        for (int j = 0; j < length; j++) {
            // if (stones[0] == stones[1]) {
            //     stones[0] = -1;
            //     stones[1] = -1;
            // } else if (stones[0] < stones[1]) {
            //     stones[1] = stones[1] - stones[0];
            //     stones[0] = -1;
            // } else {
            //     stones[0] = stones[0] - stones[1];
            //     stones[1] = -1;
            // }
             stones[0] = stones[0] - stones[1];
                stones[1] = -1;
            sortArray(stones);

            if(stones[1]==-1){
                break;
            }
            System.out.println(Arrays.toString(stones));
        }

        for (int i = 0; i < length - 1; i++) {
            if (stones[i] != -1) {
                return stones[i];
            }
        }
        return -1;
    }

    private void sortArray(int[] stones) {
        for (int i = 0; i < stones.length; i++) {
            for (int j = i + 1; j < stones.length; j++) {
                if (stones[i] < stones[j]) {
                    int temp = stones[i];
                    stones[i] = stones[j];
                    stones[j] = temp;
                }
            }
        }
    }
}
