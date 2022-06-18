package sort;

import java.util.HashMap;
import java.util.Map;

/**
 * @description：
 * @author: zhangxianglong
 * @date: 2022/6/14
 */
public class MemoryLeakTest {
    /**
     * 声明缓存对象
     */
    private static final Map<String, TestMemory> CACHE_MAP = new HashMap<>();

    public static void main(String[] args) {
        try {
            //给打开visualVm时间
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //循环添加对象到缓存
        for (int i = 0; i < 1000000; i++) {
            TestMemory t = new TestMemory();
            CACHE_MAP.put("key" + i, t);
        }
        System.out.println("-------1------");
        //为dump出堆提供时间
        try {
            //给打开visualVm时间
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 1000000; i++) {
            TestMemory t = new TestMemory();
            CACHE_MAP.put("key" + i, t);
        }
    }
}
