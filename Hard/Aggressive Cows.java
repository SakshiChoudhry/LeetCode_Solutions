//this question is not available on LeetCode. can try gfg
import java.util.Arrays;
class AggressiveCows
{
    public static boolean canWePlace(int[] arr,int k,int mid) {
        int count = 1;
        int last = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - last >= mid) {
                count++;
                last = arr[i];
            }
        }
        if (count >= k) {
            return true;
        } else {
            return false;
        }
    }
    public static int cows(int[] stalls,int k)
    {
        Arrays.sort(stalls);
        int n=stalls.length;
        int l=1;
        int h=stalls[n-1]-stalls[0];

        while(l<=h)
        {
            int mid=l+(h-l)/2;
            if(canWePlace(stalls, k, mid))
            {
                l=mid+1;
            }
            else {
                h=mid-1;
            }
        }
        return h;
    }
    public static void main(String args[])
    {
        int[] c={0,3,4,7,10,9};
        int k =4;
        int ans=cows(c,k);
        System.out.print(ans);
    }
}