class Solution1020 {
    public void bfs(int i,int j, int[][] vis,int[][] grid,int m,int n)
    {
        int[] dirx={0,1,0,-1};
        int[] diry={1,0,-1,0};
        Queue<int[]> q=new LinkedList<>();
        q.offer(new int[]{i,j});
        while(!q.isEmpty())
        {
            int[] x=q.poll();
            for(int y=0;y<4;y++)
            {
                int a=x[0]+dirx[y];
                int b=x[1]+diry[y];
                if(a>=0 && b>=0 && a<m && b<n && grid[a][b]==1 && vis[a][b]==0)
                {
                    q.offer(new int[]{a,b});
                    vis[a][b]=1;
                }
            }
        }
    }
    public int numEnclaves(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int vis[][]=new int[m][n];
        for(int i =0;i<n;i++)
        {
            if(grid[0][i]==1 && vis[0][i]==0)
            {
                vis[0][i]=1;
                bfs(0,i,vis,grid,m,n);
            }
            if(grid[m-1][i]==1 && vis[m-1][i]==0)
            {
                vis[m-1][i]=1;
                bfs(m-1,i,vis,grid,m,n);
            }
        }
        for(int j=0;j<m;j++)
        {
            if(grid[j][0]==1 && vis[j][0]==0)
            {
                vis[j][0]=1;
                bfs(j,0,vis,grid,m,n);
            }
            if(grid[j][n-1]==1 && vis[j][n-1]==0)
            {
                vis[j][n-1]=1;
                bfs(j,n-1,vis,grid,m,n);
            }
        }
        int count=0;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==1 && vis[i][j]==0)
                {
                    count++;
                }
            }
        }
        return count;
    }
}