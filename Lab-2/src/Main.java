import java.lang.reflect.Field;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Check function:");
        for (int i = 0; i < Functions.formulas.length; i++) {
            System.out.println(i+1 + ". " + Functions.formulas[i]);
        }

        Scanner scanner = new Scanner(System.in);
        int numberOfFunction = scanner.nextInt();
        System.out.println("Input low limit of integration (use ',' for double)");
        double lowLimit = scanner.nextDouble();
        System.out.println("Input up limit of integration (use ',' for double)");
        double upLimit = scanner.nextDouble();
        System.out.println("Input accuracy (use ',' for double)");
        double accuracy = scanner.nextDouble();

        if (lowLimit > upLimit) {
            double temporary = lowLimit;
            lowLimit = upLimit;
            upLimit = temporary;
        }

        SimpsonMethod simpsonMethod = new SimpsonMethod(numberOfFunction, lowLimit, upLimit, accuracy);
        simpsonMethod.solve();
        System.out.println(simpsonMethod);
    }
}
