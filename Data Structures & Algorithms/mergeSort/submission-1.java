// Definition for a pair.
// class Pair {
//     public int key;
//     public String value;
//
//     public Pair(int key, String value) {
//         this.key = key;
//         this.value = value;
//     }
// }
class Solution {
    public List<Pair> mergeSort(List<Pair> pairs) {
        
        int length = pairs.size();

        if(length<=1){
            return pairs;
        }

        int mid = length/2;


        List<Pair> left = splitList(pairs,0,mid);
        List<Pair> right = splitList(pairs,mid,length);

        System.out.println("Starting merging left");

        left = mergeSort(left);

        System.out.println("Starting merging right");
        right = mergeSort(right);

        return fusionMerge(left,right);

    }


    private List<Pair> splitList(List<Pair> original,int from , int to){
        List<Pair> newList = new ArrayList<>();
        for(int i =from ; i < to;i++){
            newList.add(original.get(i));
        }
        return newList;
    }



    private List<Pair> fusionMerge(List<Pair> left , List<Pair> right){
        
        List<Pair> result = new ArrayList<>();
        
        int i = 0;
        int j = 0;


        while(i<left.size() && j<right.size()){
            if(left.get(i).key <= right.get(j).key){
                result.add(left.get(i));
                i++;

            }else{
                result.add(right.get(j));
                j++;
            }

        }

        while(i<left.size()){
            result.add(left.get(i));
            i++;
        }

         while(j<right.size()){
            result.add(right.get(j));
            j++;
        }


        result.forEach(e->System.out.println(e.key + "|" + e.value));


        return result;
    }


}
