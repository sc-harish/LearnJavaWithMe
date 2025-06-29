package LearnJavaWithMe;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadSafeCounter {

    static AtomicInteger myInteger = new AtomicInteger(0);

    public static void main(String args[]){
        ExecutorService service = Executors.newFixedThreadPool(5);

        for(int i=0;i<5;i++){
            service.submit(() -> {
                int val = myInteger.incrementAndGet();
                System.out.println(val);
            });
        }
        service.shutdown();
    }
}
