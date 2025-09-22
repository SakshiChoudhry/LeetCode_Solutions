class Solution1423 {
    public int maxScore(int[] cardPoints, int k) {
        int total=0;
        for(int z:cardPoints)
        {
            total+=z;
        }
        int n=cardPoints.length;
        int window=n-k;
        if(window==0)return total;
        int sum=0;
        int ans=Integer.MAX_VALUE;
        int l=0;
        for(int r=0;r<n;r++)
        {
            sum+=cardPoints[r];
            while((r-l+1)>window)
            {
                sum-=cardPoints[l];
                l++;
            }
            if(r-l+1==window)
            {
                ans=Math.min(ans,sum);
            }
        }
        return total-ans;
    }
}