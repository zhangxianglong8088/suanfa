package string;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * NC97 字符串出现次数的TopK问题
 * https://www.nowcoder.com/practice/fd711bdfa0e840b381d7e1b82183b3ee?tpId=117&tqId=37809&rp=1&ru=/exam/oj&qru=/exam/oj&sourceUrl=%2Fexam%2Foj%3Fpage%3D1%26tab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D117&difficulty=undefined&judgeStatus=undefined&tags=&title=
 *
 * @description：
 * @author: zhangxianglong
 * @date: 2022/7/24
 */
public class TopKstrings {

    /**
     * return topK string
     *
     * @param strings string字符串一维数组 strings
     * @param k       int整型 the k
     * @return string字符串二维数组
     */
    public static String[][] topKstrings(String[] strings, int k) {
        // write code here

        PriorityQueue<MyNode> queue = new PriorityQueue<>((a, b) -> (a.num - b.num));

        HashMap<String, Integer> map = new HashMap<>(16);
        for (int i = 0; i < strings.length; i++) {
            if (map.containsKey(strings[i])) {
                map.put(strings[i], map.get(strings[i]) + 1);
            } else {
                map.put(strings[i], 1);
            }
        }
        //入堆
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            queue.add(new MyNode(entry.getKey(), entry.getValue()));
        }
        String[][] result = new String[k][2];
        int j = 0;
        while (j < k && !queue.isEmpty()) {
            MyNode node = queue.poll();
            result[j][0] = node.val;
            result[j++][1] = String.valueOf(node.num);
        }
        return result;

    }

    static class MyNode {
        String val;
        int num;

        MyNode(String val, int num) {
            this.num = num;
            this.val = val;
        }
    }

    static class MyComparator implements Comparator<MyNode> {

        @Override
        public int compare(MyNode o1, MyNode o2) {
            if (o1.num == o2.num) {
                //字典序小的在前 所以 o1 比 o2
                return o1.val.compareTo(o2.val);
            } else {
                //数量大的在前所以 o2 - o1
                return o2.num - o1.num;
            }

        }
    }

    public static void main(String[] args) {
        String[] s = new String[]{"a", "b", "c", "b"};
        int k = 2;
        String[][] res = topKstrings(s, 2);
    }
}
