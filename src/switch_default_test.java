import java.util.Scanner;
public class switch_default_test {
    public static void main(String[] args) {
        int day;
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce un número entero del 1 al 7:");
        day = sc.nextInt();

        switch (day) {
            case 6:
                System.out.println("Today is Saturday");
                break;
            default:
                System.out.println("Looking forward to the Weekend");
                break;
            case 7:
                System.out.println("Today is Sunday");
                break;
        }
    }
}
