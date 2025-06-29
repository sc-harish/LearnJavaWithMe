package LearnJavaWithMe;
import java.util.*;

class StreamsExample {
    public static void main(String arg[]) {
        List<String> myList = new ArrayList();
        myList.add("jon jones");
        myList.add("aspinall");

        System.out.println(myList.stream().count());

        // Printing using streams
        myList.stream().forEach(x -> System.out.println(x));



    }
}