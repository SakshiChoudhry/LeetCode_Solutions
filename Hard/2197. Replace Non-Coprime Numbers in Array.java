import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

class Solution2197 {
    public int gcd(int a,int b)
    {
        while(b != 0){
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public int lcm(int a, int b)
    {
        int g = gcd(a,b);
        return (int)((1L * a * b) / g);
    }

    public List<Integer> replaceNonCoprimes(int[] nums) {
        Stack<Integer> s=new Stack<>();
        List<Integer> ans=new ArrayList<>();
        int n =nums.length;
        int i =0;

        while(i<n)
        {
            // keep merging as long as gcd > 1
            int curr = nums[i];
            while(!s.isEmpty() && gcd(s.peek(), curr) > 1){
                int x = s.pop();
                curr = lcm(x, curr);
            }
            s.push(curr);
            i++;
        }

        while(!s.isEmpty())
        {
            ans.add(s.pop());
        }
        Collections.reverse(ans);
        return ans;
    }
}
