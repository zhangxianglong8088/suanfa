package arry;

/**
 * 旋转数组
 *
 * @description： https://www.nowcoder.com/practice/e19927a8fd5d477794dac67096862042?tpId=117&tqId=37834&rp=1&ru=/exam/oj&qru=/exam/oj&sourceUrl=%2Fexam%2Foj%3Fpage%3D3%26tab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D117&difficulty=undefined&judgeStatus=undefined&tags=&title=
 * @author: zhangxianglong
 * @date: 2022/7/27
 */
public class RotateArray {

    public static int[] rotate(int n, int m, int[] a) {
        //**** 取余，因为每次长度为n的旋转数组相当于没有变化
        m = m % n;
        //第一次逆转全部数组元素
        reverse(a, 0, n - 1);
        //第二次只逆转开头m个
        reverse(a, 0, m - 1);
        //第三次只逆转结尾m个
        reverse(a, m, n - 1);
        return a;
    }

    //反转函数
    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start++, end--);
        }
    }

    //交换函数
    public static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};

        int n = 7;
        int m = 2;
        //长度为7的数组向右移动3次
        rotate(7, m, nums);
    }
}
