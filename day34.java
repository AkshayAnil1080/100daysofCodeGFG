
https://practice.geeksforgeeks.org/problem-of-the-day
19-02-22

class Solution
{
    //Function to find the number of islands.
    public int numIslands(char[][] grid)
    {
        // Code here
        int r=grid.length;
        int c =grid[0].length;
        int count=0;
        for( int i=0; i<r;i++)
        {
            for( int j =0; j <c;j++)
             {   if(grid[i][j]=='1')
                {
                    grid[i][j]='0';
                    count++;
                 dfs(grid, i,j+1,r,c); //right
                dfs(grid, i,j-1,r,c); // left
                dfs(grid, i+1,j,r,c); // down
                dfs(grid, i-1,j,r,c); // up
                dfs(grid, i-1,j+1,r,c); // d right up
                dfs(grid, i+1,j+1,r,c);  // d rught down
                dfs(grid, i-1,j-1,r,c);  //d left up
                dfs(grid, i+1,j-1,r,c);   //d left down
                }
             }
        }
        return count;
    }
    void dfs(char[][] grid, int i, int j , int r, int c)
    {
        //bc
        if(i<0 || j<0 || i>(r-1) || j>(c-1) || grid[i][j]!='1')
        return;

        //else recur for 8 neighbour vertices
        if(grid[i][j]=='1')
        {
                grid[i][j]='0';
                 dfs(grid, i,j+1,r,c); //right
                dfs(grid, i,j-1,r,c); // left
                dfs(grid, i+1,j,r,c); // down
                dfs(grid, i-1,j,r,c); // up
                dfs(grid, i-1,j+1,r,c); // d right up
                dfs(grid, i+1,j+1,r,c);  // d rught down
                dfs(grid, i-1,j-1,r,c);  //d left up
                dfs(grid, i+1,j-1,r,c);   //d left down
        }
    }
}
