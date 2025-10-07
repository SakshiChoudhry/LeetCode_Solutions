import java.util.*;

class Solution547 {
    public void traverse(int node, boolean[] v, int[][] con)
    {
        Queue<Integer> q=new LinkedList<>();
        v[node]=true;
        q.offer(node);
        while(!q.isEmpty())
        {
            int x=q.poll();
            for(int i =0;i<con.length;i++)
            {
                if(con[x][i]==1 && !v[i])
                {
                    q.offer(i);
                    v[i]=true;
                }
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        boolean[] visited=new boolean[n];
        int count=0;
        for(int i =0;i<n;i++)
        {
            if(!visited[i])
            {
                count++;
                traverse(i,visited,isConnected);
            }
        }
        return count;
    }
}