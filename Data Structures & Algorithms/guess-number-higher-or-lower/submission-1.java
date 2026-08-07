/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {

        int min = 0;
        int hight = n;

        while(min<=hight){
            
            int mid = hight+  (min -hight)/2;

            if(guess(mid)==-1){
              hight = mid-1;
            }else if(guess(mid)==1){
                min = mid+1;
            }else{
                return mid;
            }
        }

        return -1;
    }
}