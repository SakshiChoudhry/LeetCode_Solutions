import java.util.Stack;

class Solution84 {
    public int [] nse(int[] h)
    {
        int n =h.length;
        int res[]=new int[n];
        Stack<Integer> s=new Stack<>();
        for(int i =n-1;i>=0;i--)
        {
            while(!s.empty() && h[s.peek()]>=h[i])
            {
                s.pop();
            }
            res[i]=s.empty()?n:s.peek();
            s.push(i);
        }
        return res;
    }
    public int[] pse(int[] h)
    {
        int n =h.length;
        int res[]=new int[n];
        Stack<Integer> s=new Stack<>();
        for(int i =0;i<n;i++)
        {
            while(!s.empty() && h[s.peek()]>h[i])
            {
                s.pop();
            }
            res[i]=s.empty()?-1:s.peek();
            s.push(i);
        }
        return res;
    }
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        int ans=0;
        int[] nextsmall=nse(heights);
        int [] prevsmall=pse(heights);
        for(int i =0;i<n;i++)
        {
            int width=nextsmall[i]-prevsmall[i]-1;
            ans=Math.max(ans,width * heights[i]);

        }
        return ans;
    }
}