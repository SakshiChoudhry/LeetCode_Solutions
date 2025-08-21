import java.util.Stack;

class Solution {
    public int[] prevSmaller(int[]nums)
    {
        int n =nums.length;
        int res[]=new int [n];
        Stack<Integer> s=new Stack<>();
        for(int i =0;i<n;i++)
        {
            while(!s.empty() && nums[s.peek()]>=nums[i])
            {
                s.pop();
            }
            res[i]=s.empty()?-1:s.peek();
            s.push(i);
        }
        return res;
    }

    public int[] nextSmaller(int[] nums)
    {
        int n=nums.length;
        int []res=new int[n];
        Stack<Integer> s=new Stack<>();
        for(int i=n-1;i>=0;i--)
        {
            while(!s.empty() && nums[s.peek()]>nums[i])
            {
                s.pop();
            }
            res[i]=s.empty()?n:s.peek();
            s.push(i);
        }
        return res;
    }
    public int[] prevGreater(int[]nums)
    {
        int n =nums.length;
        int res[]=new int [n];
        Stack<Integer> s=new Stack<>();
        for(int i =0;i<n;i++)
        {
            while(!s.empty() && nums[s.peek()]<=nums[i])
            {
                s.pop();
            }
            res[i]=s.empty()?-1:s.peek();
            s.push(i);
        }
        return res;
    }
    public int[] nextGreater(int[] nums)
    {
        int n=nums.length;
        int[] res=new int[n];
        Stack<Integer> s=new Stack<>();
        for(int i=n-1;i>=0;i--)
        {
            while(!s.empty() && nums[s.peek()]<nums[i])
            {
                s.pop();
            }
            res[i]=s.empty()?n:s.peek();
            s.push(i);
        }
        return res;
    }
    //how many subarrays have nums[i] as the minimum element, we'll find that sum
    public long sumOfSubarrayMins(int []nums)
    {
        int n =nums.length;
        int[] a=prevSmaller(nums);
        int[] b =nextSmaller(nums);
        long total=0;
        for(int i =0;i<n;i++)
        {
            long l=i-a[i];
            long r=b[i]-i;
            total+=(l*r* (long) nums[i]);
        }
        return total;
    }
    //how many subarrays have the element nums[i] as their maximum element, we'll find that sum
    public long sumOfSubarrayMaxs(int[] nums)
    {
        int n =nums.length;
        int[] l=prevGreater(nums);
        int[] r=nextGreater(nums);
        long total =0;
        for(int i=0;i<n;i++)
        {
            long a=i-l[i];
            long b=r[i]-i;
            total+=(a*b *(long) nums[i]);
        }
        return total;
    }
 /* then instead of calculating the differenc of all min and max in a subarray
    we will find the  difference of sum of all max and mins
  */
    public long subArrayRanges(int[] nums) {
        long min=sumOfSubarrayMins(nums);
        long max=sumOfSubarrayMaxs(nums);
        return max-min;
    }
}