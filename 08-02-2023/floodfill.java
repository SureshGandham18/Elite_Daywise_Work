class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int [][]ans=image;
        int iniColor=image[sr][sc];

        int delRow[]={-1,1,0,0};
        int delCol[]={0,0,1,-1};

        DFS(image,sr,sc,color,iniColor,ans,delRow,delCol);
        return ans;
    }

    public void DFS(int[][] image,int sr, int sc, int color,int iniColor,int [][]ans,
    int delRow[],int delCol[]){
        ans[sr][sc]=color;
        int n=image.length;
        int m=image[0].length;

        for(int i=0;i<4;i++){
            int nrow=sr+delRow[i];
            int ncol=sc+delCol[i];

            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && image[nrow][ncol]==iniColor &&
            ans[nrow][ncol]!=color){
                DFS(image,nrow,ncol,color,iniColor,ans,delRow,delCol);
            }
        }

    }
}



/*using dfs*/
class Solution {
    public void dfs(int i,int j,int[][] image,int k,int color){
        if(i<0 || i>=image.length || j<0 || j>=image[0].length || image[i][j]==color || image[i][j]!=k) return;
        image[i][j] = color;
        dfs(i-1,j,image,k,color);
        dfs(i+1,j,image,k,color);
        dfs(i,j-1,image,k,color);
        dfs(i,j+1,image,k,color);
        return ;
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int k = image[sr][sc];
        dfs(sr,sc,image,k,color);
        return image;
    }
}
