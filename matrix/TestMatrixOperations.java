
class MatrixOperations {
    private double[][] matrix;

    // Constructor
    public MatrixOperations(double[][] matrix) {
        this.matrix = matrix;
    }

    // Transpose
    public double[][] transpose() {
        double[][] result = new double[3][3];
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                result[j][i] = matrix[i][j];
        return result;
    }

    // Determinant of 3x3 matrix
    public double determinant() {
        return matrix[0][0] * (matrix[1][1]*matrix[2][2] - matrix[1][2]*matrix[2][1])
             - matrix[0][1] * (matrix[1][0]*matrix[2][2] - matrix[1][2]*matrix[2][0])
             + matrix[0][2] * (matrix[1][0]*matrix[2][1] - matrix[1][1]*matrix[2][0]);
    }

    // Inverse of 3x3 matrix
    public double[][] inverse() {
        double det = determinant();
        if (det == 0) {
            throw new ArithmeticException("Matrix is singular and cannot be inverted.");
        }

        double[][] inv = new double[3][3];
        inv[0][0] =  (matrix[1][1]*matrix[2][2] - matrix[1][2]*matrix[2][1]) / det;
        inv[0][1] = -(matrix[0][1]*matrix[2][2] - matrix[0][2]*matrix[2][1]) / det;
        inv[0][2] =  (matrix[0][1]*matrix[1][2] - matrix[0][2]*matrix[1][1]) / det;

        inv[1][0] = -(matrix[1][0]*matrix[2][2] - matrix[1][2]*matrix[2][0]) / det;
        inv[1][1] =  (matrix[0][0]*matrix[2][2] - matrix[0][2]*matrix[2][0]) / det;
        inv[1][2] = -(matrix[0][0]*matrix[1][2] - matrix[0][2]*matrix[1][0]) / det;

        inv[2][0] =  (matrix[1][0]*matrix[2][1] - matrix[1][1]*matrix[2][0]) / det;
        inv[2][1] = -(matrix[0][0]*matrix[2][1] - matrix[0][1]*matrix[2][0]) / det;
        inv[2][2] =  (matrix[0][0]*matrix[1][1] - matrix[0][1]*matrix[1][0]) / det;

        return inv;
    }

    // Utility to print matrix
    public void printMatrix(double[][] mat) {
        for (double[] row : mat) {
            for (double val : row) {
                System.out.printf("%8.3f", val);
            }
            System.out.println();
        }
    }
}

public class TestMatrixOperations {
    public static void main(String[] args) {
        double[][] m = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        MatrixOperations matrix = new MatrixOperations(m);

        System.out.println("Original Matrix:");
        matrix.printMatrix(m);

        System.out.println("\nTranspose:");
        double[][] transpose = matrix.transpose();
        matrix.printMatrix(transpose);

        System.out.println("\nDeterminant:");
        double det = matrix.determinant();
        System.out.printf("%.3f\n", det);

        try {
            System.out.println("\nInverse:");
            double[][] inverse = matrix.inverse();
            matrix.printMatrix(inverse);
        } catch (ArithmeticException e) {
            System.out.println("Inverse: " + e.getMessage());
        }
    }
}
