import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution1331 {
    public int[] arrayRankTransform(int[] arr) {
        int n=arr.length;
        int[] sec=new int[n];
        int rank=1;
        Map<Integer,Integer> m=new HashMap<>();
        for(int i=0;i<n;i++)
        {
            sec[i]=arr[i];
        }
        Arrays.sort(sec);
        for(int i =0;i<n;i++)
        {
            if(m.get(sec[i])==null)
            {
                m.put(sec[i],rank);
                rank++;
            }
        }
        for(int i =0;i<n;i++)
        {
            arr[i]=m.get(arr[i]);
        }
        return arr;
    }
}