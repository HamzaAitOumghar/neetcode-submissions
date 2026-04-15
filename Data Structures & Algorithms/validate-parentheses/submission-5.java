class Solution {
    public boolean isValid(String s) {

        Stack<Character> myStack = new Stack();

        char[] chars = s.toCharArray();

        for(char c : chars){
            
            if(c=='{' || c=='[' || c=='(' ){
                myStack.push(c);
            } else{

               if(myStack.isEmpty()) {
                return false ;
               }
                  char temp =  myStack.pop();
                
                    if(!(temp=='(' && c ==')' || temp=='[' && c ==']' || temp=='{' && c =='}')){
                        return false ;
                    }
               
                
               
            }


        }
        return myStack.isEmpty();
        
    }
}
