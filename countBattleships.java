class Solution {
    public int countBattleships(char[][] grid) {
      int rsize=grid.length,csize=grid[0].length;
      int count=0;
      for(int row=0;row<rsize;row++){
        for(int col=0;col<csize;col++){
            if(grid[row][col]!='X') continue;
            if(row>0 && grid[row-1][col]=='X' )continue;
            if(col>0&& grid[row][col-1]=='X') continue;
            count++;
        }
      }  
      return count;
    }
}
