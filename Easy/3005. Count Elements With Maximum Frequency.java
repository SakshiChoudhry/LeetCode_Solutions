class Solution3005 {
    public int maxFrequencyElements(int[] nums) {
        int[] freq= new int[101];
        int n=nums.length;
        int max=0;
        for(int i=0;i<n;i++)
        {
            freq[nums[i]]++;
        }
        for(int x:freq)
        {
            max=Math.max(max,x);
        }
        int count=0;
        for(int j:freq)
        {
            if(j==max)
            {
                count+=j;
            }
        }
        return count;
    }
}