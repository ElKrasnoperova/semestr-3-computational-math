import java.text.DecimalFormat;

public class SimpsonMethod {
    private static final double SIMPSON_COEFFICIENT_FOR_RUNGE = 0.0666;

    private int numberOfPartitions = 2;
    private int functionId;
    private double lowLimit;
    private double upLimit;
    private double accuracy;
    private double previousSolution;
    private double currentSolution;
    private double rungeError;

    SimpsonMethod(int functionId, double lowLimit, double upLimit, double accuracy) {
         this.functionId = functionId;
         this.lowLimit = lowLimit;
         this.upLimit = upLimit;
         this.accuracy = accuracy;
    }
    private boolean checkAccuracy() {
        rungeError = SIMPSON_COEFFICIENT_FOR_RUNGE * Math.abs(currentSolution - previousSolution);
        return rungeError < accuracy;
    }

    private double computationOfTheIntegral() {
        double oddElementsSum = 0;
        double evenElementsSum = 0;

        double h = (upLimit - lowLimit) / numberOfPartitions;
        double[] x = new double[numberOfPartitions + 1];
        double[] y = new double[numberOfPartitions + 1];

        for (int i = 0; i <= numberOfPartitions; i++) {
            x[i] = h * i;
            y[i] = Functions.getFunction(functionId, x[i]);
        }

        for (int i = 1; i < numberOfPartitions; i++) {
            if (i % 2 == 0) {
                evenElementsSum += y[i];
            } else {
                oddElementsSum += y[i];
            }
        }
        return (h/3) * (y[0] + y[numberOfPartitions] + 2 * evenElementsSum + 4 * oddElementsSum);
    }

    void solve() {
        previousSolution = computationOfTheIntegral();
        numberOfPartitions *= 2;
        currentSolution = computationOfTheIntegral();
        while (!checkAccuracy()) {
            numberOfPartitions *= 2;
            previousSolution = currentSolution;
            currentSolution = computationOfTheIntegral();
        }
    }

    @Override
    public String toString() {
        String pattern = "##0.000";
        DecimalFormat decimalFormat = new DecimalFormat(pattern);
        return ("\nAnswer: \t " + decimalFormat.format(currentSolution)) +
                "\nPartitions:  " + numberOfPartitions + "\nRunge error: " + decimalFormat.format(rungeError);
    }
}