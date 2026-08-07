// Definition for a pair.
// class Pair {
//     int key;
//     String value;
//
//     public Pair(int key, String value) {
//         this.key = key;
//         this.value = value;
//     }
// }
class Solution {
    public List<Pair> quickSort(List<Pair> pairs) {
        int length = pairs.size();
        return quickSrt(pairs,0,length-1);
    }


    public static List<Pair> quickSrt(List<Pair> list , int i , int j){

        if(j-i+1<=1){
            return list ;
        }

        Pair pivot = list.get(j);
        int left = i;


        for(int k = i ; k < j; k++){

            if(list.get(k).key < pivot.key){
                Pair temp = list.set(left,list.get(k));
                list.set(k,temp);
                left++;
            }

        }

      list.set(j,list.get(left));
      list.set(left,pivot);

    
    quickSrt(list,i,left-1);

    quickSrt(list,left+1,j);

    return list;


    }



}
