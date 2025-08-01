import java.util.HashMap;
import java.util.Map;

class Solution13 {
    public int romanToInt(String s) {
        int n =s.length();
        int sum=0;
        Map<Character, Integer> m=new HashMap<>();
        m.put('I',1);
        m.put('V',5);
        m.put('X',10);
        m.put('L',50);
        m.put('C',100);
        m.put('D',500);
        m.put('M',1000);
        for(int c=0;c<n;c++)
        {
            int x=m.get(s.charAt(c));
            if(c<n-1 && x<m.get(s.charAt(c+1)))
            {sum-=x;
            }
            else
            {
                sum+=x;
            }   }
        return sum;
    }
}