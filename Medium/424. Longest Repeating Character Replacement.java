class Solution424 {
    public int characterReplacement(String s, int k) {
        int[] freq=new int[26];
        int n =s.length();
        int l=0;
        int max=0;
        int ans=0;
        for(int r=0;r<n;r++)
        {
            freq[s.charAt(r)-'A']++;
            max=Math.max(max,freq[s.charAt(r)-'A']);
            int window=r-l+1;
            while(window-max>k)
            {
                freq[s.charAt(l)-'A']--;
                l++;
                window=r-l+1;

            }
            ans=Math.max(ans,r-l+1);

        }
        return ans;
    }
}