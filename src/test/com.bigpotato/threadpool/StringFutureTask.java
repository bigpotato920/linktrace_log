package threadpool;

import java.util.concurrent.Callable;

/**
 * Created by hjy on 16/7/14.
 */
public class StringFutureTask implements Callable<String> {
    @Override
    public String call() throws Exception {
        return generateMsg();
    }

    public String generateMsg() throws BaseBussinessException{
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        throw new BaseBussinessException(1, "hello world");
    }
}
