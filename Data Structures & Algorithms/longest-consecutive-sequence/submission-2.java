class Solution {
    public int longestConsecutive(int[] nums) {

        if(nums.length==0){
            return 0;
        }

        Set<Integer> sortedArray = new TreeSet<>();
        TreeSet<Integer> longestConsecutive = new TreeSet<>();

        for(int i = 0 ; i< nums.length ; i++){
            sortedArray.add(nums[i]);
        }


        System.out.println("sortedArray : "+ sortedArray);

        int k =0;
        longestConsecutive.add(k);
        List<Integer> tempList = new ArrayList<>(sortedArray);
        for(int i=0; i<tempList.size()-1;i++){
            if(tempList.get(i+1)-tempList.get(i)==1){
                k++;
                longestConsecutive.add(k);
            }
            else{
                k=0;
            }
        }

        System.out.println(longestConsecutive);

        return longestConsecutive.last()+1;

        
    }
}
