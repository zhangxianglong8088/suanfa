package half;

/**
 * @description：NC71 旋转数组的最小数字
 * https://www.nowcoder.com/practice/9f3231a991af4f55b95579b44b7a01ba?tpId=117&tqId=37768&rp=1&ru=/exam/oj&qru=/exam/oj&sourceUrl=%2Fexam%2Foj%3Fpage%3D3%26tab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D117&difficulty=undefined&judgeStatus=undefined&tags=&title=
 * @author: zhangxianglong
 * @date: 2022/8/6
 */
public class MinNumberInRotateArray {

    public int minNumberInRotateArray(int[] array) {
        int left = 0;
        int right = array.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;
            //最小的数字在mid右边
            if (array[mid] > array[right]) {
                left = mid + 1;
            }
            //无法判断，一个一个试
            else if (array[mid] == array[right]) {
                right--;
            }
            //最小数字要么是mid要么在mid左边
            else {
                right = mid;
            }
        }
        return array[left];
    }
}
