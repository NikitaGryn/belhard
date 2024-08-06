import java.util.Scanner;

public class JavaTask1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите количество элементов в массиве: ");
        int n = sc.nextInt();
        int[] array = new int[n];

        System.out.println("Введите элементы массива:");
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }

        step1(array);
        step2(array);
        step3(array);

        sc.close();
    }

    static void step1(int[] array) {
        int min = array[0];
        int max = array[0];
        for (int value : array) {
            if (value < min) {
                min = value;
            }
            if (value > max) {
                max = value;
            }
        }
        System.out.println("Минимальное и максимальное значения: " + min + " " + max);
    }

    static void step2(int[] array) {
        double sum = 0;
        for (int value : array) {
            sum += value;
        }
        double average = sum / array.length;
        System.out.print("Значения меньше среднего арифметического: ");
        for (int value : array) {
            if (value < average) {
                System.out.print(value + " ");
            }
        }
        System.out.println();
    }

    static void step3(int[] array) {
        int min = array[0];
        for (int value : array) {
            if (value < min) {
                min = value;
            }
        }
        System.out.print("Индексы минимального значения в порядке убывания: ");
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] == min) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
}
