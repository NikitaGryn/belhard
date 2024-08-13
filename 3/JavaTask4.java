import java.util.Arrays;
import java.util.Scanner;

public class JavaTask4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Введите размер одномерного массива: ");
        int len = sc.nextInt();
        int[] array = new int[len];
        System.out.println("Введите элементы одномерного массива:");
        for (int i = 0; i < len; i++) {
            array[i] = sc.nextInt();
        }

        System.out.print("Введите размерность матрицы (количество строк): ");
        int rows = sc.nextInt();
        System.out.print("Введите количество столбцов: ");
        int cols = sc.nextInt();
        int[][] matrix = new int[rows][cols];
        System.out.println("Введите элементы матрицы:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        System.out.println("Исходный одномерный массив: " + Arrays.toString(array));
        System.out.println("Отсортированный одномерный массив: " + Arrays.toString(step1(array)));

        System.out.println("Исходная матрица: ");
        printMatrix(matrix);
        int[][] sortedMatrix = step2(matrix);
        System.out.println("Отсортированная матрица: ");
        printMatrix(sortedMatrix);

        System.out.println("Введите размерность матрицы для умножения на вектор (количество строк): ");
        int vectorRows = sc.nextInt();
        System.out.println("Введите количество столбцов в матрице: ");
        int vectorCols = sc.nextInt();
        double[][] matrixForVector = new double[vectorRows][vectorCols];
        System.out.println("Введите элементы матрицы:");
        for (int i = 0; i < vectorRows; i++) {
            for (int j = 0; j < vectorCols; j++) {
                matrixForVector[i][j] = sc.nextDouble();
            }
        }
        System.out.println("Введите элементы вектора:");
        double[] vector = new double[vectorCols];
        for (int i = 0; i < vectorCols; i++) {
            vector[i] = sc.nextDouble();
        }

        double[] resultVector = mul(matrixForVector, vector);
        System.out.println("Результат умножения матрицы на вектор: " + Arrays.toString(resultVector));

        System.out.println("Введите размерность первой матрицы для умножения (количество строк): ");
        int leftRows = sc.nextInt();
        System.out.println("Введите количество столбцов в первой матрице: ");
        int leftCols = sc.nextInt();
        double[][] matrixLeft = new double[leftRows][leftCols];
        System.out.println("Введите элементы первой матрицы:");
        for (int i = 0; i < leftRows; i++) {
            for (int j = 0; j < leftCols; j++) {
                matrixLeft[i][j] = sc.nextDouble();
            }
        }
        System.out.println("Введите размерность второй матрицы для умножения (количество строк): ");
        int rightRows = sc.nextInt();
        System.out.println("Введите количество столбцов в второй матрице: ");
        int rightCols = sc.nextInt();
        double[][] matrixRight = new double[rightRows][rightCols];
        System.out.println("Введите элементы второй матрицы:");
        for (int i = 0; i < rightRows; i++) {
            for (int j = 0; j < rightCols; j++) {
                matrixRight[i][j] = sc.nextDouble();
            }
        }

        double[][] resultMatrix = mul(matrixLeft, matrixRight);
        System.out.println("Результат умножения матрицы на матрицу: ");
        printMatrix(resultMatrix);

        System.out.println("Введите текст для замены букв:");
        sc.nextLine();
        String text = sc.nextLine();
        String replacedText = replace(text);
        System.out.println("Текст после замены: " + replacedText);

        System.out.println("Введите слово для проверки на палиндром:");
        String word = sc.next();
        boolean isPalindrome = isPalindrom(word);
        System.out.println("Слово является палиндромом: " + isPalindrome);

        sc.close();
    }

    static int[] step1(int[] array) {
        int n = array.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
        return array;
    }

    static int[][] step2(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 1; j < array[i].length; j++) {
                int key = array[i][j];
                int k = j - 1;
                while (k >= 0 && array[i][k] > key) {
                    array[i][k + 1] = array[i][k];
                    k = k - 1;
                }
                array[i][k + 1] = key;
            }
        }
        return array;
    }

    static double[] mul(double[][] matrix, double[] vector) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        double[] result = new double[rows];

        for (int i = 0; i < rows; i++) {
            result[i] = 0;
            for (int j = 0; j < cols; j++) {
                result[i] += matrix[i][j] * vector[j];
            }
        }
        return result;
    }

    static double[][] mul(double[][] matrixLeft, double[][] matrixRight) {
        int rows = matrixLeft.length;
        int cols = matrixRight[0].length;
        int commonDim = matrixLeft[0].length;
        double[][] result = new double[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = 0;
                for (int k = 0; k < commonDim; k++) {
                    result[i][j] += matrixLeft[i][k] * matrixRight[k][j];
                }
            }
        }
        return result;
    }

    static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int elem : row) {
                System.out.print(elem + " ");
            }
            System.out.println();
        }
    }

    static void printMatrix(double[][] matrix) {
        for (double[] row : matrix) {
            for (double elem : row) {
                System.out.print(elem + " ");
            }
            System.out.println();
        }
    }

    public static String replace(String s) {
        StringBuilder result = new StringBuilder();
        String[] words = s.split("\\s+");

        for (String word : words) {
            if (word.length() >= 4) {
                // Замена 4-й буквы
                char[] chars = word.toCharArray();
                chars[3] = '#';
                if (word.length() >= 7) {
                    chars[6] = '#';
                }
                result.append(new String(chars)).append(" ");
            } else {
                result.append(word).append(" ");
            }
        }
        return result.toString().trim();
    }

    public static boolean isPalindrom(String word) {
        int left = 0;
        int right = word.length() - 1;
        while (left < right) {
            if (word.charAt(left) != word.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
