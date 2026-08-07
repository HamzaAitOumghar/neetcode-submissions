class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int min = 1;
        int hight = 1000000000;


        while(min<= hight){
            
            int mid = (min+hight)/2;

            if(totalHours(mid,piles) <= h ){
               hight  = mid-1;
            } else {
               min  = mid+1;
            }

        }

        return min;
        
    }

    private int totalHours(int k,int[] piles){
       int calculatedH=0;
       for(int i=0;i<piles.length;i++){
          calculatedH += Math.ceil((double) piles[i]/k);
        }
        return calculatedH ;
    }
}
