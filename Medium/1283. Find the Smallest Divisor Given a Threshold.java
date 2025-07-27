class Solution1283 {
    public int divide(int []arr, int mid)
    {
        int r=0;
        for(int a:arr){

            r+=Math.ceil((double)(a)/(double)(mid));
        }
        return r;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int n =nums.length;
        int l=1;
        int h=Integer.MIN_VALUE;
        for(int num:nums)
        {
            h=Math.max(h,num);
        }
        int ans=0;
        while(l<=h)
        {
            int mid=l+(h-l)/2;
            int res=divide(nums,mid);
            if(res<=threshold)
            {
                ans=mid;
                h=mid-1;
            }
            else
            {
                l=mid+1;
            }
        }
        return ans;

    }
}