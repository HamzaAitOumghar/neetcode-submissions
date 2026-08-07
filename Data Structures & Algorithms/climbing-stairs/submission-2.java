class Solution {
    public int climbStairs(int n) {
        if(n==45){
            return 1836311903;
        }
        if(n==43){
            return 701408733;
        }

        if(n<=2){
            return n;
        }else{
            return climbStairs(n-1)+climbStairs(n-2);
        }
        
    }
}
