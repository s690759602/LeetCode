public class 两数之和II_输入有序数组 {
    class Solution {
        public int[] twoSum(int[] numbers, int target) {
            int[] ans = new int[2];
            for (int i = 0; i < numbers.length - 1; ++i) {
                ans[1] = binarySearch(numbers, i + 1, numbers.length - 1, target - numbers[i]) + 1;
                if (ans[1] != 0) {
                    ans[0] = i + 1;
                    break;
                }
            }
            return ans;
        }

        private int binarySearch(int[] numbers, int left, int right, int target) {
            int mid;
            while (left <= right) {
                mid = left + (right - left) / 2;
                if (target > numbers[mid]) left = mid + 1;
                else if (target < numbers[mid]) right = mid - 1;
                else return mid;
            }
            return -1;
        }
    }
}
