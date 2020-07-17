import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 墙与门 {
    class Solution {
        public void wallsAndGates(int[][] rooms) {
            int n = rooms.length;
            if(n == 0)return;
            int m = rooms[0].length;
            if(m == 0)return;
            Queue<Point> queue = new LinkedList<>();
            Point point;
            int distance, size;
            for (int x = 0; x < n; ++x) {
                for (int y = 0; y < m; ++y) {
                    distance = 0;
                    if (rooms[x][y] == Integer.MAX_VALUE) {
                        queue.offer(new Point(x, y));
                        boolean[][] visited = new boolean[n][m];
                        while (!queue.isEmpty()) {
                            size = queue.size();
                            for (int i = 0; i < size; ++i) {
                                point = queue.poll();
                                if (visited[point.x][point.y]) continue;
                                visited[point.x][point.y] = true;
                                if (rooms[point.x][point.y] == 0) {
                                    rooms[x][y] = distance;
                                    queue.clear();
                                    break;
                                } else if (rooms[point.x][point.y] != -1) {
                                    if (point.x + 1 < n) {
                                        queue.offer(new Point(point.x + 1, point.y));
                                    }
                                    if (point.x - 1 >= 0) {
                                        queue.offer(new Point(point.x - 1, point.y));
                                    }
                                    if (point.y - 1 >= 0) {
                                        queue.offer(new Point(point.x, point.y - 1));
                                    }
                                    if (point.y + 1 < m) {
                                        queue.offer(new Point(point.x, point.y + 1));
                                    }
                                }
                            }
                            ++distance;
                        }
                    }
                }
            }

        }

        private class Point {
            int x;
            int y;

            public Point(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }
    }
}
