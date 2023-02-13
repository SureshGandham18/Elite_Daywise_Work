class Pair{
    int first;
    int second;
    int val;
    Pair(int f,int s,int v){
        this.first = f;
        this.second = s;
        this.val = v;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        int[][] vis = new int[n][m];
        int fresh = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    q.offer(new Pair(i,j,0));
                    vis[i][j] = 2;
                }
                else vis[i][j] = 0;
                if(grid[i][j]==1) fresh++;
            }
        }
        int ans = 0;
        int count = 0;
        int[] delRow = {-1,1,0,0};
        int[] delCol = {0,0,-1,1};
        while(!q.isEmpty()){
            int row = q.peek().first;
            int col = q.peek().second;
            int cost = q.peek().val;
            q.remove();
            ans = Math.max(cost,ans);
            for(int i=0;i<4;i++){
                int nrow = row+delRow[i];
                int ncol = col+delCol[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==0 && grid[nrow][ncol]==1){
                    q.offer(new Pair(nrow,ncol,cost+1));
                    vis[nrow][ncol] = 2;
                    count++;
                }
            }
        }
        if(count!=fresh) return -1;
        return ans;
    }
}
