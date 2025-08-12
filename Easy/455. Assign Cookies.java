import java.util.Arrays;

class Solution455 {
    public int findContentChildren(int[] g, int[] s) {
        int l=g.length;
        int m=s.length;
        Arrays.sort(g);
        Arrays.sort(s);
        int i=0;int j =0;
        while(i<l && j<m)
        {
            if(g[i]<=s[j])
            {
                i++;
            }
            j++;
        }
        return i;
    }
}