final class FinalDemo   // final class
{
    final int MAX = 100;   // final variable

    final void show()      // final method
    {
        System.out.println("Final variable value: " + MAX);
        System.out.println("This is a final method.");
    }
}

public class Main
{
    public static void main(String[] args)
    {
        FinalDemo obj = new FinalDemo();
        obj.show();
    }
}