import java.util.LinkedList;
import java.util.Queue;

class Solution733 {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n=image.length;
        int m =image[0].length;
        Queue<int[]> q=new LinkedList<>();
        int[][] d={{0,1},{0,-1},{1,0},{-1,0}};
        int col=image[sr][sc];
        if(col==color)
        {
            return image;
        }

        image[sr][sc]=color;
        q.offer(new int[] {sr,sc});
        while(!q.isEmpty())
        {
            int size=q.size();
            for(int i=0;i<size;i++)
            {
                int[] x=q.poll();
                int a=x[0];
                int b=x[1];
                for(int j=0;j<d.length;j++)
                {
                    int y=a+d[j][0];
                    int z=b+d[j][1];
                    if(y>=0 && y<n && z>=0 && z<m && image[y][z]==col)
                    {
                        image[y][z]=color;
                        q.offer(new int[] {y,z});
                    }
                }
            }

        }
        return image;
    }
}