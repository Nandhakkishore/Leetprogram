class Solution {
    public int findCircleNum(int[][] grid) {

        int size=grid.length,province=0;
        boolean[] visit=new boolean[size];
        for(int index=0;index<size;index++){
            if(!visit[index]){
                dfs(grid,visit,index);
                    province++;
            }
        }
        return province;
    }
        public static void dfs(int[][] grid,boolean[] visit,int cur){
            visit[cur]=true;
            for(int col=0;col<grid.length;col++)
                if(grid[cur][col]==1&& !visit[col])
                    dfs(grid,visit,col);
        }
    
}
