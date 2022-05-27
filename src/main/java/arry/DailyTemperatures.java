package arry;

/**
 * @description：739. 每日温度
 * https://leetcode.cn/problems/daily-temperatures/
 * @author: zhangxianglong
 * @date: 2022/5/24
 */
public class DailyTemperatures {

    public static int[] dailyTemperatures(int[] temperatures) {
        int[] tem = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            for (int j = i + 1; j < temperatures.length; j++) {

                if (temperatures[j] > temperatures[i]) {
                    tem[i] = j - i;
                    break;
                }
            }
        }
        return tem;

    }

    public static void main(String[] args) {

        int[] tem = new int[]{30, 40, 50, 60};

        int[] result = dailyTemperatures(tem);

    }
}
