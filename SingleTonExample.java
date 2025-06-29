package LearnJavaWithMe;

public class SingleTonExample {
    public static void main(String args[]){
        DoubleCheckExample myInstance = DoubleCheckExample.getInstance();
        myInstance.customPrint();
    }
}


class DoubleCheckExample {
    // Volatile is required here because, if a thread A in the process of initializing instance
    // Thread B will find the instance as non-null and return the partially initialized instance 
    // This could result in crash. Therefore, volatile prevent this by the instance will not be visible
    // to Thread B until Thread A fully initialize it in the constructor.
    private static volatile DoubleCheckExample instance;

    private DoubleCheckExample(){

    }

    public void customPrint(){
        System.out.println("This is a custom print method");
    } 

    public static DoubleCheckExample getInstance() {
        // Here dual null check ensures high performance. Instance of having to enter the synchronized block
        // everytime, this will prevent it by checking the instance is not-null without acquiring lock.
        if(instance == null) {  // First check without locking.
            synchronized(DoubleCheckExample.class){
                if (instance == null) { // Second check with locking. 
                    instance = new DoubleCheckExample();
                }
            }
        }
        return instance;
    }
}

// This method is thread safe using static inner helper class(static class initialization) to initialize object for the original class.
class BillPughSingleton {

    private BillPughSingleton(){

    }

    public BillPughSingleton getInstance(){
        return BillPughSingletonHelper.instance;
    }

    // Static inner class is not loaded into the JVM memory until it is referenced. JVM will internally
    // take care of fully initializing the  static field instance before it is visible to all the threads. So, need of volatile/synchronized to be used in this case.
    static class BillPughSingletonHelper {
        static final BillPughSingleton instance = new BillPughSingleton();
    }
}