import java.util.HashMap;
import java.util.Map;

class Solution205 {
    public boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length())return false;
        Map<Character,Character> e= new HashMap<>();
        Map<Character,Character> d= new HashMap<>();
        for(int i =0;i<s.length();i++)
        {
            char c1=s.charAt(i);
            char c2=t.charAt(i);
            if(e.containsKey(c1))
            {
                if(e.get(c1)!=c2){return false;
                }
            }
            else
            {
                e.put(c1,c2);
            }

            if(d.containsKey(c2))
            {
                if(d.get(c2)!=c1){return false;
                }
            }
            else{
                d.put(c2,c1);
            }
        }
        return true;

    }
}