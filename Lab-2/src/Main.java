import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        System.out.println("Check function: \n 1. y = sin(x^2)");
        Scanner scanner = new Scanner(System.in);
        int numberOfFunction = scanner.nextInt();
        System.out.println("Input low limit of integration (use ',' for double)");
        double lowLimit = scanner.nextDouble();
        System.out.println("Input up limit of integration (use ',' for double)");
        double upLimit = scanner.nextDouble();
        System.out.println("Input accuracy (use ',' for double)");
        double accuracy = scanner.nextDouble();
    }
}
