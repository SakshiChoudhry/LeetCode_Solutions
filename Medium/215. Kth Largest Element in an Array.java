import java.util.Collections;
import java.util.PriorityQueue;

class Solution215 {
    public int findKthLargest(int[] nums, int k) {
        int n =nums.length;
        PriorityQueue<Integer> p= new PriorityQueue<>(Collections.reverseOrder());
        for(int i =0;i<n;i++)
        {
            p.add(nums[i]);
        }
        while(k>1)
        {
            p.remove();
            k--;
        }
        return p.peek();

    }
}