package sort;

/**
 * @description：
 * @author: zhangxianglong
 * @date: 2022/6/15
 */
public class Singleton {
    static volatile Singleton singleton;

    public static Singleton getSingleton() {

        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                    //1、开辟空间
                    //2、初始化
                    //3、给引用赋值
                    //执行过程中，可能第2步和第3步交换 也就是先给引用赋值，后进行初始化  导致别的线程调用出现空指针
                }
            }
        }
        return singleton;
    }
}
