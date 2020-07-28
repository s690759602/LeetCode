public class 每日气温 {
    class Solution {
        public int[] dailyTemperatures(int[] T) {
            int[] res = new int[T.length];
            //从后面开始查找
            for (int i = res.length - 1; i >= 0; i--) {
                int j = i + 1;
                while (j < res.length) {
                    if (T[j] > T[i]) {
                        //如果找到就停止while循环
                        res[i] = j - i;
                        break;
                    } else if (res[j] == 0) {
                        //如果没找到，并且res[j]==0。说明第j个元素后面没有
                        //比第j个元素大的值，因为这一步是第i个元素大于第j个元素的值，
                        //那么很明显这后面就更没有大于第i个元素的值。直接终止while循环。
                        break;
                    } else {
                        //如果没找到，并且res[j]！=0说明第j个元素后面有比第j个元素大的值，
                        //然后我们让j往后挪res[j]个单位，找到那个值，再和第i个元素比较
                        j += res[j];
                    }
                }
            }
            return res;
        }
    }
}
