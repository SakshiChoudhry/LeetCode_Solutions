class Solution130 {
    public void bfs(int i,int j, int[][] vis,char[][] board,int m,int n)
    {
        Queue<int[]> q=new LinkedList<>();
        int[] row={0,1,0,-1};
        int[] col={1,0,-1,0};
        q.offer(new int[]{i,j});
        while(!q.isEmpty())
        {
            int[] x=q.poll();
            for(int il =0;il<4;il++)
            {
                int a=x[0]+row[il];
                int b =x[1]+col[il];
                if(a>=0 && b>=0 && a<m && b<n && board[a][b]=='O' && vis[a][b]==0)
                {
                    vis[a][b]=1;
                    q.offer(new int[]{a,b});
                }
            }
        }
    }
    public void solve(char[][] board) {
        int m =board.length;
        int n=board[0].length;
        int[][] vis=new int[m][n];
        for(int i =0;i<n;i++)
        {
            if(board[0][i]=='O'&& vis[0][i]==0)
            {
                vis[0][i]=1;
                bfs(0,i,vis,board,m,n);
            }
            if(board[m-1][i]=='O' && vis[m-1][i]==0)
            {
                vis[m-1][i]=1;
                bfs(m-1,i,vis,board,m,n);
            }
        }
        for(int j=0;j<m;j++)
        {
            if(board[j][0]=='O' && vis[j][0]==0)
            {
                vis[j][0]=1;
                bfs(j,0,vis,board,m,n);
            }
            if(board[j][n-1]=='O'&& vis[j][n-1]==0)
            {
                vis[j][n-1]=1;
                bfs(j,n-1,vis,board,m,n);
            }
        }
        for(int i =0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(board[i][j]=='O' && vis[i][j]==0)
                {
                    board[i][j]='X';
                }
            }
        }

    }
}