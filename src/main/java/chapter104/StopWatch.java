package chapter104;

/**
 * @author: ymm
 * @date: 2021/7/2
 * @version: 1.0.0
 * @description: 计时器
 */
public class StopWatch {

    private final long start;

    /**
     * 创建一个计时器
     */
    public StopWatch() {
        start = System.currentTimeMillis();
    }

    /**
     * 返回对象创建依赖所经历的时间，单位为s
     *
     * @return
     */
    public double elapsedTime() {
        long now = System.currentTimeMillis();
        return (now - start) / 1000.0;
    }

}
