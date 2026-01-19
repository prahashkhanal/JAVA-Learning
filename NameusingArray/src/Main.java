import java.lang.StringBuffer;

public class Main {
    public static void main(String[] args) {
            /*char name[] = {'P','R','A','H','A','S','H'};
            for ( int i = 0; i < name.length; i++ ){
                System.out.print(name[i]);
            }
        System.out.println("\n");
            for ( int i = name.length - 1; i >= 0; i--){
                System.out.print(name[i]);
            }*/

        String name = "PRAHASH";
        String reversed = "";

        String str = "hello";
        String reverse = new StringBuffer(str).reverse().toString();
        System.out.println(reverse);

        System.out.println("My name is " + name);

        for ( int i = name.length() - 1; i >= 0; i-- ) {
            reversed += name.charAt(i);

        }
        System.out.println("The reverse is " + reversed);
        }
    }
