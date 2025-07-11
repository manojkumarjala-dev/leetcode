class MedianFinder {

    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;

    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((a,b)->b-a);
    }
    
    public void addNum(int num) {
        if(minHeap.size()==0 || maxHeap.size()==0){
            minHeap.offer(num);
        }
        else{
            if(minHeap.peek()<num) minHeap.offer(num);
            else maxHeap.offer(num);
        }


        if(minHeap.size()>maxHeap.size() && minHeap.size()-maxHeap.size()>1){
            maxHeap.offer(minHeap.poll());
        }
        else if(maxHeap.size()>minHeap.size() && maxHeap.size()-minHeap.size()>1){
            minHeap.offer(maxHeap.poll());
        }
        else{
            return;
        }
    }
    
    public double findMedian() {
        if(minHeap.size()==maxHeap.size() && minHeap.size()>0){
            double mid1 = maxHeap.peek();
            double mid2 = minHeap.peek();

            return (mid1+mid2)/2;
        }
        else{
            if(maxHeap.size()>minHeap.size()) return (double)maxHeap.peek();
            else return (double)minHeap.peek(); 
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */