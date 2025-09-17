class Solution930 {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return atmost(nums,goal)-atmost(nums,goal-1);
    }
    private int atmost(int[] nums, int goal)
    {
        if(goal<0)return 0;
        int n =nums.length;
        int l=0;
        int sum=0;
        int count=0;
        for(int r=0;r<n;r++)
        {
            sum+=nums[r];
            while(sum> goal )
            {
                sum-=nums[l++];

            }

            count+=r-l+1;
        }
        return count;
    }
}

