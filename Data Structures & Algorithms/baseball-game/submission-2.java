class Solution {
    public int calPoints(String[] operations) {

        Stack<Integer> myStack = new Stack<>();

        for(int i = 0; i< operations.length ; i++ ){

            if( ! "+".equals(operations[i]) && ! "C".equals(operations[i]) && ! "D".equals(operations[i])  ){
                myStack.push(Integer.valueOf(operations[i]));
            }

            else if ("+".equals(operations[i])){
              int top = myStack.pop();
              int beforeTop = myStack.peek();
   
              myStack.push(top);
              myStack.push(beforeTop+top);


            }
            else if ("C".equals(operations[i])){
                myStack.pop();
            } 
            else if ("D".equals(operations[i])){
                int lastScore= myStack.peek();
                myStack.push(lastScore*2);
            }    

        }
        int somme = 0;

        while(!myStack.isEmpty()){
            somme+=myStack.pop();
        }

        return somme;
        
    }
}