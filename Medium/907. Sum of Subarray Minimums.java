import java.util.Stack;

class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n =arr.length;
        int MOD=1000000007;
        long total=0;
        Stack<Integer> s=new Stack<>();
        int[] PSE=new int[n];
        int[] NSE=new int[n];
        //PSE calc
        for(int i =0;i<n;i++)
        {
            while(!s.isEmpty() && arr[s.peek()]>arr[i])
            {
                s.pop();
            }
            PSE[i]=s.isEmpty()?-1:s.peek();
            s.push(i);
        }
        s.clear();
        //NSE (next smaller element)
        for(int i =n-1;i>=0;i--)
        {
            while(!s.isEmpty()&& arr[s.peek()]>=arr[i])
            {
                s.pop();
            }
            NSE[i]=s.isEmpty()?n:s.peek();
            s.push(i);
        }

        for (int i = 0; i < n; i++) {
            long left = i - PSE[i];
            long right = NSE[i] - i;
            total = (total + (arr[i] * left * right) % MOD) % MOD;
        }
        return (int) total;
    }
}