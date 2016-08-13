package threadpool;

import com.bigpotato.service.FutureTaskThreadPool;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Created by hjy on 16/7/14.
 */
public class TestFutureResult {
    private static final Logger logger = LoggerFactory.getLogger(TestFutureResult.class);

    @Test
    public void testFutureResult() {
        FutureTaskThreadPool futureTaskThreadPool = new FutureTaskThreadPool();

        StringFutureTask stringFutureTask = new StringFutureTask();

        Future<String> futureResult = futureTaskThreadPool.submitTask(stringFutureTask);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            futureResult.get(10, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            logger.error("InterruptedException", e.getMessage());
        } catch (ExecutionException e) {
            logger.error("ExecutionException", e.getMessage());
        } catch (TimeoutException e) {
            logger.error("TimeoutException", e.getMessage());
        } catch (Exception e) {
            logger.error("Exception", e.getMessage());

        }

    }
}
