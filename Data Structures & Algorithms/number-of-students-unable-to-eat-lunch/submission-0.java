class Solution {
    public int countStudents(int[] students, int[] sandwiches) {

       Queue<Integer> studentsQ= new LinkedList<>();
       Stack<Integer> sandwichesQ = new Stack<>();


        for(int i=0;i<students.length;i++){
            studentsQ.offer(students[i]);
            sandwichesQ.push(sandwiches[students.length-i-1]);
        }

        int nbrLoopMax=0;

        while(!studentsQ.isEmpty() && !sandwichesQ.isEmpty()){

            Integer currentStd = studentsQ.poll();
            Integer currentSn = sandwichesQ.pop();

            if(currentStd!=currentSn){
                studentsQ.offer(currentStd);
                sandwichesQ.push(currentSn);
                nbrLoopMax++;
            }else{
                nbrLoopMax=0;
            }

            if(nbrLoopMax>studentsQ.size()){
                break;
            }

        }

        return studentsQ.size();
    }
}