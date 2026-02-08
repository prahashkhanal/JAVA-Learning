public class calculator {
    static int a = 10;
    static int b = 15;
    static int sum = a + b;

    public static void main(String[] args) {
        System.out.printf("sum = %d\n", sum); // printf accepts format string + values
        System.out.println("sum = " + sum + "+" + sum) ; // println doesnt accept, + concatenates 
        
    }
}