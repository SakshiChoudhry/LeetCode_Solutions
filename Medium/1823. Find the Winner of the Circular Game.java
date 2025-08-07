import java.util.ArrayList;
import java.util.List;

class Solution1823 {
    public int findTheWinner(int n, int k) {
        List<Integer> l=new ArrayList<>();
        for(int i =1;i<=n;i++)
        {
            l.add(i);
        }
        int start=0;
        while(l.size()>1)
        {
            int x=(start+k-1) %l.size();
            l.remove(x);
            start=x;
        }
        return l.getFirst();
    }
}