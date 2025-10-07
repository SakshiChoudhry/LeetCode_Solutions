import java.util.LinkedList;
import java.util.Queue;

class Solution994 {
    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m =grid[0].length;
        Queue<int[]> q=new LinkedList<>();
        int minutes=0;
        int fresh=0;
        for(int i =0;i<n;i++)
        {
            for(int j =0;j<m;j++)
            {
                if(grid[i][j]==2)
                {
                    q.offer(new int[] {i,j});
                }
                if(grid[i][j]==1)
                {
                    fresh++;
                }
            }
        }
        if(fresh==0)return 0;
        if(q.isEmpty()) return -1;
        int [][] d={{0,1},{1,0},{-1,0},{0,-1}};
        while(!q.isEmpty())
        {
            int size=q.size();
            for(int i =0;i<size;i++)
            {
                int[] v=q.poll();
                int x=v[0];
                int y=v[1];
                for(int j=0;j<d.length;j++)
                {
                    int a=x+d[j][0];
                    int b=y+d[j][1];
                    if(a>=0 && a<n && b>=0 && b<m && grid[a][b]==1)
                    {
                        grid[a][b]=2;
                        q.offer(new int[]{a,b});
                        fresh--;
                    }
                }
            }
            minutes++;
        }
        return (fresh==0)? minutes-1:-1;
        //why minutes-1?? dry run you'll know
    }
}