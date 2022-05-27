package arry;

/**
 * @description：
 * @author: zhangxianglong
 * @date: 2022/5/15
 */
public class MergeArray {

    /**
     * 合并有序数组
     *
     * @return
     */
    static void merge(int[] A, int m, int[] B, int n) {
        int[] result = new int[m + n];
        int p = 0;
        int q = 0;

        for (int i = 0; i < m + n - 1; i++) {

            if (p <= m - 1 && q <= n - 1) {
                int mValue = A[p];
                int nValue = B[q];

                if (mValue <= nValue) {
                    result[i] = mValue;
                    p++;
                } else {
                    result[i] = nValue;
                    q++;
                }
            }
            //
            if (p == m && q < n) {
                result[i + 1] = B[q];
                q++;
            }

            if (q == n && p < m) {
                result[i + 1] = A[p];
                p++;
            }
        }

        for (int i = 0; i <= m + n - 1; i++) {
            A[i] = result[i];
        }
    }

    public static void main(String[] args) {

        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[]{2, 5, 6};

        merge(nums1, 3, nums2, 3);

    }
}
