class Solution1614 {
    public int maxDepth(String s) {
        int n =s.length();
        int count=0;
        int max=0;
        for(int i=0;i<n;i++)
        {
            if(s.charAt(i)=='(')
            {
                count++;
            }
            else if(s.charAt(i)==')')
            {
                count--;
            }
            max=Math.max(max,count);
        }
        return max;
    }
}