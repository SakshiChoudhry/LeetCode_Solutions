import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution347 {
    public int[] topKFrequent(int[] nums, int k) {
        int[] ans=new int[k];
        Map<Integer,Integer> m=new HashMap<>();
        for(int i:nums)
        {
            m.put(i,m.getOrDefault(i,0)+1);
        }
        PriorityQueue<Integer> p=new PriorityQueue<>((a, b)->m.get(b)-m.get(a));
        p.addAll(m.keySet());
        for(int i =0;i<k;i++)
        {
            ans[i]=p.poll();
        }
        return ans;
    }
}