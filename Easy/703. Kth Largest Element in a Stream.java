class KthLargest {
    int k;
    PriorityQueue<Integer>p;
    public KthLargest(int k, int[] nums) {
        this.k=k;
        p=new PriorityQueue<>(k);
        for(int i:nums)
        {
            add(i);
        }
    }

    public int add(int val) {
        if(p.size()<k)
        {
            p.offer(val);
        }
        else if(val>p.peek())
        {
            p.offer(val);
            p.poll();
        }
        return p.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */