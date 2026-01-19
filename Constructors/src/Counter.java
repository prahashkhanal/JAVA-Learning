class doCounter {
    static int count = 0;

    doCounter() {
        count++;
        System.out.println("Object Created. Current count: " + count);
    }
}


public class Counter {
    public static void main(String[] args) {
        doCounter obj1 = new doCounter();
        doCounter obj2 = new doCounter();
        doCounter obj3 = new doCounter();

        System.out.println("Final Count: " + doCounter.count);
    }
}
