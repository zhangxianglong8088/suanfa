package arry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description：
 * @author: zhangxianglong
 * @date: 2022/5/18
 */
public class FindDisappearedNumbers {

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], 1);
        }

        for (int i = 1; i <= nums.length; i++) {
            Integer result = map.get(i);
            if (result == null) {
                list.add(i);
            }
        }
        return list;
    }


    public static void main(String[] args) {

        int[] nums = new int[]{1, 1};
        List<Integer> result = findDisappearedNumbers(nums);
    }
}
