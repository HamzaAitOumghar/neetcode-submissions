class MinStack {

    private int[] data;
    private int topIndex;

    public MinStack() {
        this.data = new int[1000];
        this.topIndex = 0;
    }
    
    public void push(int val) {
       this.data[this.topIndex++]=val;
    }
    
    public void pop() {
        this.data[--this.topIndex] = 0;
    }
    
    public int top() {
        return this.data[this.topIndex-1];
    }
    
    public int getMin() {
        int min = data[0];
        for(int i = 0 ;i < topIndex ; i++){
            if(data[i]<min){
                min = data[i] ;
            }
        }
       return min;
    }
}
