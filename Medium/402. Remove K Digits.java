import java.util.Stack;

class Solution {
    public String removeKdigits(String num, int k) {
        int n =num.length();
        Stack<Character> s=new Stack<>();
        for(int i =0;i<n;i++)
        {
            while(!s.empty() && s.peek()>num.charAt(i) &&k>0)
            {
                s.pop();
                k--;
            }
            s.push(num.charAt(i));
        }
        while(k>0 && !s.empty())
        {
            s.pop();
            k--;
        }
        StringBuilder st=new StringBuilder();
        while(!s.empty())
        {
            st.append(s.pop());
        }
        st.reverse();
        while(st.length()>0 && st.charAt(0)=='0')
        {
            st.deleteCharAt(0);
        }
        return st.length()>0?st.toString(): "0";
    }
}