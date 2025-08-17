import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
//using monotonic stack
class Solution496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n =nums1.length;
        int m=nums2.length;
        Stack<Integer> s=new Stack<>();
        Map<Integer,Integer> map=new HashMap<>();
        for(int i =m-1;i>=0;i--)
        {
            int x=nums2[i];
            while( !s.isEmpty()&& s.peek()<=x)
            {
                s.pop();
            }
            if(s.isEmpty())
            {
                map.put(x,-1);

            }
            else
            {
                map.put(x,s.peek());
            }
            s.push(x);
        }

        int []arr =new int[n];

        for(int i =0;i<n;i++)
        {
            arr[i]=map.get(nums1[i]);
        }
        return arr;
    }
}