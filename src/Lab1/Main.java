package Lab1;
public class Main {
	public static void main(String args[]) {
		FileWorker matrixInfo = new FileWorker();
		
		GaussSeidel gaussSeidel = new GaussSeidel(
				matrixInfo.getMatrixSize(),
				matrixInfo.getApproximation(),
				matrixInfo.getMatrix(),
				matrixInfo.getVectorB()
				);
	}
}
