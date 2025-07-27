class Solution1482 {
    public boolean canMakeBouquet(int[]arr, int mid,int k ,int m)
    {
        int count=0;
        int bouquet=0;
        for(int bl:arr)
        {
            if(bl<=mid)
            {
                count++;
                if(count==k)
                {
                    bouquet++;
                    count=0;
                }
            }
            else
            {
                count=0;
            }
        }
        return bouquet>=m;
    }

    public int minDays(int[] bloomDay, int m, int k) {
        int n=bloomDay.length;
        if(n<m*k)
        {
            return -1;
        }
        int l=Integer.MAX_VALUE;
        int h=Integer.MIN_VALUE;
        int count=0;
        int nb=0;

        for(int bloom:bloomDay)
        {
            l=Math.min(l,bloom);
            h=Math.max(h,bloom);
        }
        int ans=-1;
        while(l<=h)
        {
            int mid=l+(h-l)/2;
            if(canMakeBouquet(bloomDay,mid,k,m))
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
