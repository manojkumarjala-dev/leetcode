class Solution {
    public long maxWeight(int[] pizzas) {
        Arrays.sort(pizzas);
        int n = pizzas.length;
        int count = n/4;
        int step = 1;
        long total = 0;
        int startAt = n-1;
        while(count-->0){
            if(step%2==1){
                total+=pizzas[startAt];
                startAt-=2;
                step++;
            }
            else{
                total+=pizzas[startAt];
                startAt-=1;
                step++;
            }
        }

        return total;
    }
} 
