public class 数据流中的移动平均值 {
    class MovingAverage {
        private int count;
        private int[] queue;
        private int cur;
        private int sum;

        /**
         * Initialize your data structure here.
         */
        public MovingAverage(int size) {
            this.count = 0;
            this.queue = new int[size];
            this.cur = -1;
            this.sum = 0;
        }

        public double next(int val) {
            cur = (cur + 1) % queue.length;
            if (count < queue.length) {
                ++count;
                sum +=val;
                queue[cur] = val;
            } else {
                sum += val;
                sum -= queue[cur];
                queue[cur] = val;
            }
            return (double)sum/count;
        }
    }

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
}
