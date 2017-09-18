package Lab1;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class FileWorker {
	private int dimention;
	private double approximation;
	private double[][] matrix;
	private double[] vectorB;

	private static final File file = new File ("input.txt");
	
	public FileWorker() {
		Scanner scanner;
		try {
			scanner = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return;
		}
		dimention = scanner.nextInt();
		vectorB = new double[dimention];
		matrix = new double[dimention][dimention];
		for (int i = 0; i < dimention; i++) {
			vectorB[i] = scanner.nextDouble();
		}
		
		for (int i = 0; i < dimention; i++) {
			for (int j = 0; j < dimention; j++) {
				matrix[i][j] = scanner.nextDouble();
			}
		}
		approximation = scanner.nextDouble();
	}
	
	public int getMatrixSize() {
		return dimention;
	}
	
	public double getApproximation() {
		return approximation;
	}
	
	public double[][] getMatrix() {
		return matrix;
	}
	
	public double[] getVectorB() {
		return vectorB;
	}
	
}
