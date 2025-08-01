import java.util.*;

class Solution451 {
    public String frequencySort(String s) {
        Map<Character,Integer> m=new HashMap<>();
        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            m.put(c,m.getOrDefault(c,0)+1);
        }
        List<Map.Entry<Character, Integer>> list=new ArrayList<>(m.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> e1, Map.Entry<Character, Integer> e2) {
                return e2.getValue() - e1.getValue();
            }
        });
        StringBuilder sb=new StringBuilder();
        for(Map.Entry<Character,Integer> entry:list)
        {
            char ch=entry.getKey();
            int fre=entry.getValue();
            for(int i =0;i<fre;i++)
            {
                sb.append(ch);
            }
        }
        return sb.toString();
    }


}