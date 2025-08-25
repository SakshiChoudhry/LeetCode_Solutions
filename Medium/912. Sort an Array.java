class Solution912 {
    public int parent(int i )
    {
        return (i-1)/2;
    }
    public int left(int i)
    {
        return (2*i)+1;
    }
    public int right(int i)
    {
        return (2*i)+2;
    }
    public void swap(int[] nums,int a,int b)
    {
        int temp=nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
    }
    public void heapify(int[]nums, int i,int n)
    {
        int largest=i;
        int l=left(i);
        int r=right(i);
        if(l<n && nums[l]>nums[largest]) largest=l;
        if(r<n && nums[r]>nums[largest]) largest=r;
        if(largest!=i)
        {
            swap(nums,i,largest);
            heapify(nums,largest,n);
        }
    }
    public int[] sortArray(int[] nums) {
        int n=nums.length;
        for(int i=(n/2)-1;i>=0;i--)
        {
            heapify(nums,i,n);
        }
        //to actually sort, swapping the root(max) with last element
        //so that the last position has its final value and then call heapify on the root.
        for(int i=n-1;i>0;i--)
        {
            swap(nums,0,i);
            heapify(nums,0,i);
        }
        return nums;
    }
}