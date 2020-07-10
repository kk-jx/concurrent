package com.kk.concurrent.AsynSyn;

/**
 * Create By Zhenli.Hu
 * Create Time 2020-07-10 11:12
 */
public class DataThread extends Thread {

    private AsynToSynLockCondition asynToSynLockCondition;

    /**
     * Allocates a new {@code Thread} object. This constructor has the same
     * effect as {@linkplain #Thread(ThreadGroup, Runnable, String) Thread}
     * {@code (null, null, gname)}, where {@code gname} is a newly generated
     * name. Automatically generated names are of the form
     * {@code "Thread-"+}<i>n</i>, where <i>n</i> is an integer.
     */
    public DataThread(AsynToSynLockCondition asynToSynLockCondition) {
        super();
        this.asynToSynLockCondition = asynToSynLockCondition;
    }

    /**
     * If this thread was constructed using a separate
     * <code>Runnable</code> run object, then that
     * <code>Runnable</code> object's <code>run</code> method is called;
     * otherwise, this method does nothing and returns.
     * <p>
     * Subclasses of <code>Thread</code> should override this method.
     *
     * @see #start()
     * @see #stop()
     * @see #Thread(ThreadGroup, Runnable, String)
     */
    @Override
    public void run() {
        try {
            for (int i=0; i<10000; i++){

            }
            System.out.println("线程执行---");
            asynToSynLockCondition.callBack(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
