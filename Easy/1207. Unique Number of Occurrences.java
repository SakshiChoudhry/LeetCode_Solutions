import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution1207 {
    public boolean uniqueOccurrences(int[] arr) {
        int n =arr.length;
        Map<Integer, Integer> m=new HashMap<>();
        for(int x:arr)
        {
            m.put(x,m.getOrDefault(x,0)+1);
        }
        Set<Integer> s=new HashSet<>();
        for(Map.Entry<Integer,Integer> i:m.entrySet())
        {
            if(s.contains(i.getValue())){
                return false;
            }
            else
            {
                s.add(i.getValue());
            }
        }
        return true;

    }
}