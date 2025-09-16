import java.util.HashMap;
import java.util.Map;

class Solution904 {
    public int totalFruit(int[] fruits) {
        Map<Integer,Integer> m=new HashMap<>();
        int l=0;
        int ans=0;
        int n=fruits.length;
        for(int r=0;r<n;r++)
        {
            m.put(fruits[r],m.getOrDefault(fruits[r],0)+1);
            if(m.size()>2)
            {
                m.put(fruits[l],m.get(fruits[l])-1);
                if(m.get(fruits[l])==0)
                {
                    m.remove(fruits[l]);
                }
                l++;
            }

            ans=Math.max(ans,r-l+1);

        }
        return ans;
    }
}