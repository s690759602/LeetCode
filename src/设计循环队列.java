public class 设计循环队列 {
    class MyCircularQueue {
        private final int[] queue;
        private int head;
        private int tail;
        private int size;
        private final int capacity;
        
        /**
         * Initialize your data structure here. Set the size of the queue to be k.
         */
        public MyCircularQueue(int k) {
            this.queue = new int[k];
            this.head = -1;
            this.tail = -1;
            this.capacity = k;
            this.size = 0;
        }

        /**
         * Insert an element into the circular queue. Return true if the operation is successful.
         */
        public boolean enQueue(int value) {
            if (isFull()) {
                return false;
            }
            tail = (tail + 1) % capacity;
            queue[tail] = value;
            ++size;
            return true;
        }

        /**
         * Delete an element from the circular queue. Return true if the operation is successful.
         */
        public boolean deQueue() {
            if (isEmpty()) {
                return false;
            }
            head = (head + 1) % capacity;
            --size;
            return true;
        }

        /**
         * Get the front item from the queue.
         */
        public int Front() {
            if (!isEmpty()) {
                return queue[head+1];
            } else {
                return -1;
            }
        }

        /**
         * Get the last item from the queue.
         */
        public int Rear() {
            if (!isEmpty()) {
                return queue[tail];
            } else {
                return -1;
            }
        }

        /**
         * Checks whether the circular queue is empty or not.
         */
        public boolean isEmpty() {
            return size == 0;
        }

        /**
         * Checks whether the circular queue is full or not.
         */
        public boolean isFull() {
            return size == capacity;
        }
    }

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
}
