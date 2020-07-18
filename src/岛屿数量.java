public class 岛屿数量 {
    class Solution {
        private int n;
        private int m;
        private char[][] grid;

        public int numIslands(char[][] grid) {
            this.n = grid.length;
            if (n == 0) return 0;
            this.m = grid[0].length;
            if (m == 0) return 0;
            this.grid = grid;
            int ans = 0;
            for (int x = 0; x < n; ++x) {
                for (int y = 0; y < m; ++y) {
                    if (grid[x][y] == '1') {
                        ++ans;
                        dfs(x, y);
                    }
                }
            }
            return ans;
        }

        private void dfs(int x, int y) {
            if (x < 0 || y < 0 || x >= n || y >= m || grid[x][y] == '0') return;
            grid[x][y] = '0';
            dfs(x - 1, y);
            dfs(x + 1, y);
            dfs(x, y - 1);
            dfs(x, y + 1);
        }
    }
}
