class MyStack {

    private Queue<Integer> main;
    


    public MyStack() {
         main = new LinkedList<>();
        
    }
    
    public void push(int x) {
        main.offer(x);
    }
    
    public int pop() {

        Queue<Integer> helper = new LinkedList<>();

        int temp[] = new int[main.size()];
        int i = 0;
        
        while(i< temp.length){
            temp[i]=main.poll();
            i++;
        }
        
        for(i = 0; i<temp.length-1;i++){
                helper.offer(temp[i]);
        }

        main=helper;

        return temp[temp.length-1];        
    }
    
    public int top() { 
        Queue<Integer> helper = new LinkedList<>();
        
        int temp=0;

        while(!main.isEmpty()){
            temp=main.poll();
            helper.offer(temp);
        }   
        
        main=helper;
        
        return temp;

    }
    
    public boolean empty() {
        return main.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */