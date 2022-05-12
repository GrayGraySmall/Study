package zephyr.designmode.record.singleton;

/**
 * 双重检查 保证线程安全单例的实现
 * volatile 禁止重排序
 */
public class SingletonDoubleCheck {

    private SingletonDoubleCheck(){}

    private static volatile SingletonDoubleCheck instance = null;

    public static SingletonDoubleCheck getInstance() {
        if (instance == null) {
            synchronized (SingletonDoubleCheck.class) {
                // double check
                if (instance == null) {
                    instance = new SingletonDoubleCheck();
                }
            }
        }
        return instance;
    }
}
