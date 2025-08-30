import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Solution621 {
    public int leastInterval(char[] tasks, int n) {
        // Count frequencies of tasks
        int[] freq = new int[26];
        for (char t : tasks) {
            freq[t - 'A']++;
        }

        // Max heap (store by frequency)
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int f : freq) {
            if (f > 0) maxHeap.add(f);
        }

        int time = 0;

        while (!maxHeap.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int cycle = n + 1;  // length of one cycle

            // try to run (n+1) different tasks in this cycle
            while (cycle > 0 && !maxHeap.isEmpty()) {
                int curr = maxHeap.poll();  // run the most frequent task
                if (curr - 1 > 0) {
                    temp.add(curr - 1);     // push back later if still left
                }
                time++;     // ✅ filled a slot with a task
                cycle--;
            }

            // put unfinished tasks back into heap
            for (int f : temp) {
                maxHeap.add(f);
            }

            if (!maxHeap.isEmpty()) {
                // ✅ HERE is where "idle" time comes in:
                // if we didn’t fully use (n+1) slots,
                // the remaining slots are idle.
                time += cycle;
            }
        }

        return time;
    }
}

//second way using formula
/*class Solution {
    public int leastInterval(char[] tasks, int n) {
     int[] c=new int[26];
     int x=tasks.length;
     for(int i =0;i<x;i++)
     {
         c[tasks[i]-'A']++;
     }
     int max=0;
     for(int i =0;i<26;i++)
     {
        max=Math.max(max,c[i]);
     }
     int count=0;
     for(int i: c)
     {
        if(i==max)count++;
     }
     int ans=(max-1)*(n+1) +count;
     return Math.max(x,ans);
     }
    }

 */