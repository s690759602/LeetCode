import java.util.*;

public class 打开转盘锁 {
    class Solution {
        public int openLock(String[] deadends, String target) {
            Set<String> deadCombinations = new HashSet<>();
            Collections.addAll(deadCombinations, deadends);
            Queue<String> queue = new LinkedList<>();
            queue.offer("0000");
            Set<String> visited = new HashSet<>();
            int size;
            String s;
            int value;
            int level = 0;
            int ans = -1;
            int a, b, c, d;
            while (!queue.isEmpty()) {
                size = queue.size();
                for (int i = 0; i < size; ++i) {
                    s = queue.poll();
                    if (visited.contains(s) || deadCombinations.contains(s)) continue;
                    if (s.equals(target)) {
                        ans = level;
                        queue.clear();
                        break;
                    }
                    visited.add(s);
                    value = Integer.parseInt(s);
                    a = value / 1000;
                    b = (value / 100) % 10;
                    c = (value / 10) % 10;
                    d = value % 10;
                    value = (a + 1) % 10 * 1000 + b * 100 + c * 10 + d;
                    queue.offer(transform(String.valueOf(value)));
                    value = (a + 9) % 10 * 1000 + b * 100 + c * 10 + d;
                    queue.offer(transform(String.valueOf(value)));
                    value = a * 1000 + (b + 1) % 10 * 100 + c * 10 + d;
                    queue.offer(transform(String.valueOf(value)));
                    value = a * 1000 + (b + 9) % 10 * 100 + c * 10 + d;
                    queue.offer(transform(String.valueOf(value)));
                    value = a * 1000 + b * 100 + (c + 1) % 10 * 10 + d;
                    queue.offer(transform(String.valueOf(value)));
                    value = a * 1000 + b * 100 + (c + 9) % 10 * 10 + d;
                    queue.offer(transform(String.valueOf(value)));
                    value = a * 1000 + b * 100 + c * 10 + (d + 1) % 10;
                    queue.offer(transform(String.valueOf(value)));
                    value = a * 1000 + b * 100 + c * 10 + (d + 9) % 10;
                    queue.offer(transform(String.valueOf(value)));
                }
                ++level;
            }
            return ans;
        }

        private String transform(String value) {
            StringBuilder builder = new StringBuilder(4);
            switch (value.length()) {
                case 1 -> {
                    builder.append("000");
                    builder.append(value);
                }
                case 2 -> {
                    builder.append("00");
                    builder.append(value);
                }
                case 3 -> {
                    builder.append("0");
                    builder.append(value);
                }
                case 4 -> {
                    builder.append(value);
                }
            }
            return builder.toString();
        }
    }
}
