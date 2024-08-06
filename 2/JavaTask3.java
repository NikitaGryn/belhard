import java.util.Random;
import java.util.Scanner;

public class JavaTask3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите размерность матрицы n: ");
        int n = sc.nextInt();

        int[][] matrix = step1(n);
        System.out.println("Исходная матрица:");
        printMatrix(matrix);

        int sumBetweenPositives = step2(matrix);
        System.out.println("Сумма элементов между первым и вторым положительными элементами каждой строки: " + sumBetweenPositives);

        int[][] newMatrix = step3(matrix);
        System.out.println("Матрица после удаления строк и столбцов, содержащих максимальный элемент:");
        printMatrix(newMatrix);

        sc.close();
    }

    static int[][] step1(int n) {
        Random random = new Random();
        int[][] matrix;
        boolean containsNAndMinusN;

        do {
            containsNAndMinusN = false;
            matrix = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = random.nextInt(2 * n + 1) - n;
                    if (matrix[i][j] == n || matrix[i][j] == -n) {
                        containsNAndMinusN = true;
                    }
                }
            }
        } while (!containsNAndMinusN);

        return matrix;
    }

    static int step2(int[][] arr) {
        int sum = 0;

        for (int[] row : arr) {
            boolean firstPositiveFound = false;
            int rowSum = 0;

            for (int value : row) {
                if (value > 0) {
                    if (firstPositiveFound) {
                        sum += rowSum;
                        break;
                    } else {
                        firstPositiveFound = true;
                        rowSum = 0;
                    }
                } else if (firstPositiveFound) {
                    rowSum += value;
                }
            }
        }

        return sum;
    }

    static int[][] step3(int[][] arr) {
        int max = Integer.MIN_VALUE;

        for (int[] row : arr) {
            for (int value : row) {
                if (value > max) {
                    max = value;
                }
            }
        }

        boolean[] rowsToDelete = new boolean[arr.length];
        boolean[] colsToDelete = new boolean[arr[0].length];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == max) {
                    rowsToDelete[i] = true;
                    colsToDelete[j] = true;
                }
            }
        }

        int newRowCount = 0;
        int newColCount = 0;

        for (boolean rowToDelete : rowsToDelete) {
            if (!rowToDelete) newRowCount++;
        }

        for (boolean colToDelete : colsToDelete) {
            if (!colToDelete) newColCount++;
        }

        int[][] newMatrix = new int[newRowCount][newColCount];
        int newRowIdx = 0;

        for (int i = 0; i < arr.length; i++) {
            if (rowsToDelete[i]) continue;
            int newColIdx = 0;
            for (int j = 0; j < arr[0].length; j++) {
                if (colsToDelete[j]) continue;
                newMatrix[newRowIdx][newColIdx++] = arr[i][j];
            }
            newRowIdx++;
        }

        return newMatrix;
    }

    static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
