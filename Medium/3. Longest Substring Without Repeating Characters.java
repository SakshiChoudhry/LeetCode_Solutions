import java.util.HashSet;
import java.util.Set;

class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        int max=0;
        int n=s.length();
        Set<Character> set=new HashSet<>();
        int l=0;
        for(int r=0;r<n;r++)
        {
            if(set.contains(s.charAt(r)))
            {
                while(l<r && set.contains(s.charAt(r)))
                {
                    set.remove(s.charAt(l));
                    l++;
                }
            }
            set.add(s.charAt(r));
            max=Math.max(max,r-l+1);
        }
        return max;
    }
}