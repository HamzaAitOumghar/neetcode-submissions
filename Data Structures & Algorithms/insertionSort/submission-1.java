// Definition for a pair
// class Pair {
//     int key;
//     String value;

//     Pair(int key, String value) {
//         this.key = key;
//         this.value = value;
//     }
// }

public class Solution {
    public List<List<Pair>> insertionSort(List<Pair> pairs) {
        
        if(pairs.size()==0){
            return List.of();
        }

        List<List<Pair>> steps = new ArrayList<>();


        steps.add(new ArrayList<>(pairs));

        for(int i = 1; i< pairs.size(); i++ ){

            int j = i-1;

            Pair pKey = pairs.get(i);

            while(j>=0 && pairs.get(j).key> pKey.key ){
                pairs.set(j+1 , pairs.get(j));
                j--;
            }

            pairs.set(j+1,pKey);

          steps.add(new ArrayList<>(pairs));



        }

        return steps;
    }
}
