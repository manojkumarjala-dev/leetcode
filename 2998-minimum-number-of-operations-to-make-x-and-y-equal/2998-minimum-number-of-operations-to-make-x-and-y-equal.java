class Solution {
    public int minimumOperationsToMakeEqual(int x, int y) {

        Queue<Integer> q = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        set.add(x);
        q.offer(x);
        int steps= 0;
        if(x==y){
            return 0;
        }
        if(x<y){
            return y-x;
        }

        while(q.size()>0){
            int size = q.size();
            while(size-->0){

                int value = q.poll();

                if(value==y){
                    return steps;
                }
                
                if(value%11==0 && value>y && !set.contains(value/11)){
                    set.add(value/11);
                    q.offer(value/11);
                }
                if(value%5==0 && value>y && !set.contains(value/5)){
                    set.add(value/5);
                    q.offer(value/5);
                }
                if(!set.contains(value-1)){
                    set.add(value-1);
                    q.offer(value-1);
                }
                if(!set.contains(value+1)){
                    set.add(value+1);
                    q.offer(value+1);
                }             

            }
                    steps++;
        }

            return steps;
    }


}