package generator;

import java.util.concurrent.ThreadPoolExecutor;

public class MonitorThread implements Runnable {

    private ThreadPoolExecutor executor;
    private int delay;
    private boolean run;

    
    
    
    public MonitorThread(ThreadPoolExecutor executor, int delay) {
        super();
        this.executor = executor;
        this.delay = delay;
        this.run = true;
    }

    public void shutDown() {
        this.run = false;
    }

    public void run() {
        while (run) {
            System.out.println(String.format(
                    "[monitor] [%d/%d] Active: %d, Completed: %d, Task: %d, isShutdown: %s, isTerminated: %s",
                    this.executor.getPoolSize(), this.executor.getCorePoolSize(), this.executor.getActiveCount(),
                    this.executor.getCompletedTaskCount(), this.executor.getTaskCount(), this.executor.isShutdown(),
                    this.executor.isTerminated()));
            try {
                Thread.sleep(delay * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
