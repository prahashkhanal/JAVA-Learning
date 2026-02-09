public class MultipleCatchExample {
    public static void main(String[] args) {
        try {
            String str = null;
            System.out.println(str.length());
        }
        catch (NullPointerException e){
            System.out.println("Error: Null pointer Exception! Object is null. ");
        } catch (Exception e) {
            System.out.println("Some other error occured. ");
        }

        System.out.println("Program continues after exception handling. ");
    }
}
