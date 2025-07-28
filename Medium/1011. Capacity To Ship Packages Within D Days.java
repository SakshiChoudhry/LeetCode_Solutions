class Solution1011 {
    public int calculateCap(int[] arr, int mid)
    {
        int c=1;
        int cap=0;
        for(int a:arr)
        {
            if(cap+a>mid)
            {
                c++;
                cap=0;
            }
            cap+=a;
        }

        return c;
    }
    public int shipWithinDays(int[] weights, int days) {
        int n=weights.length;
        int l=Integer.MIN_VALUE;
        int h=0;
        for(int w:weights)
        {
            l=Math.max(l,w);
            h+=w;
        }
        int ans=0;
        while(l<=h)
        {
            int mid=l+(h-l)/2;
            int d=calculateCap(weights,mid);
            if(d<=days)
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