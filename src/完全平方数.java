import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class 完全平方数 {
    class Solution {
        public int numSquares(int n) {
            int limit = (int) Math.sqrt(n);
            int sum, size;
            Set<Integer> visited = new HashSet<>();
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(0);
            int level = 0;
            while (!queue.isEmpty()) {
                size = queue.size();
                for (int i = 0; i < size; ++i) {
                    sum = queue.poll();
                    if (visited.contains(sum) || sum > n) continue;
                    visited.add(sum);
                    if (sum == n) {
                        queue.clear();
                        break;
                    }
                    for (int a = limit; a > 0; --a) {
                        queue.offer(sum + a * a);
                    }
                }
                ++level;
            }
            return level - 1;
        }
    }
}
