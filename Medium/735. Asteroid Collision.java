import java.util.Stack;

class Solution735 {
    public int[] asteroidCollision(int[] asteroids) {
        int n =asteroids.length;
        Stack<Integer> s=new Stack<>();
        for(int i =0;i<n;i++)
        {
            if(asteroids[i]<0)
            {
                while(!s.empty() && s.peek()>0 && s.peek()<-asteroids[i])
                {
                    s.pop();

                }
                if(!s.isEmpty() && s.peek()==-asteroids[i])
                {
                    s.pop();

                }
                else if(s.empty() || s.peek()<0)
                {
                    s.push(asteroids[i]);
                }

            }
            else
            {
                s.push(asteroids[i]);
            }
        }
        int [] res=new int[s.size()];
        for(int i =res.length-1;i>=0;i--)
        {
            res[i]=s.pop();
        }
        return res;
    }
}