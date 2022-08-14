package arry;

/**
 * 48. 旋转图像
 *
 * @description： https://leetcode.cn/problems/rotate-image/solution/xuan-zhuan-tu-xiang-by-leetcode-solution-vu3m/
 * @author: zhangxianglong
 * @date: 2022/7/20
 */
public class RotateGGG {

    public static void rotate(int[][] matrix) {
        //1、数组水平反转
        int len = matrix.length;
        //思考为什么这里i<len/2
        for (int i = 0; i < len / 2; i++) {
            //思考为什么这里j<len 而不是j<i
            for (int j = 0; j < len; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[len - i - 1][j];
                matrix[len - i - 1][j] = tmp;
            }
        }

        //2、对角线置换
        for (int i = 0; i < len; i++) {
            //注意这里j<i
            for (int j = 0; j < i; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotate(nums);
        System.out.println(nums);
    }
}
