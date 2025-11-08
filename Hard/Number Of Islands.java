import java.util.LinkedList;
import java.util.Queue;

class Islands{
    public void bfs(int i,int j,char[][] grid, int[][] visited, Queue<int[]> q,int n,int m)
    {
        int[] dirx={-1,-1,-1,0,1,1,1,0};
        int [] diry={-1,0,1,1,1,0,-1,-1};
        q.offer(new int[]{i,j});
        visited[i][j]=1;
        while(!q.isEmpty())
        {
            int[] x=q.poll();
            for(int z =0;z<8;z++)
            {
               int a=x[0]+dirx[z];
               int b=x[1]+diry[z];
               if(a>=0 && b>=0 && a<n && b<m && visited[a][b]==0 && grid[a][b]==1)
               {
                   q.offer(new int[]{a,b});
                   visited[a][b]=1;
               }
            }
        }
    }
    public int findIslands(char[][] grid)
    {
        int n =grid.length;
        int m=grid[0].length;
        Queue<int[]> q=new LinkedList<>();
        int[][] visited=new int[n][m];
        int count=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(visited[i][j]==0 && grid[i][j]==1)
                {
                    count++;
                    bfs(i,j,grid,visited,q,n,m);
                }
            }
        }
        return count;
    }
    public static void main(String[] args)
    {
        char[][] grid = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };
        Islands obj=new Islands();
        System.out.println(obj.findIslands(grid));
    }
}