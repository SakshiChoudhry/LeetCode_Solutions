class Solution14 {
    public String longestCommonPrefix(String[] strs) {
        int n =strs.length;
        String m=strs[0];
        for(int i =1;i<n;i++)
        {
            while(strs[i].indexOf(m)!=0)
            {
                m=m.substring(0,m.length()-1);
            }
        }
        return m;
    }
}