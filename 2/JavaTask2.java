import java.util.Scanner;

public class JavaTask2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        step1();

        System.out.print("Введите номер месяца (1-12): ");
        int month = sc.nextInt();
        step2(month);

        System.out.print("Введите коэффициенты a, b и c для квадратного уравнения (через пробел): ");
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();
        step3(a, b, c);

        sc.close();
    }

    static void step1() {
        int n = 5;
        int counter = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(counter + " ");
                counter++;
            }
            System.out.println();
        }
    }

    static void step2(int month) {
        String monthName;
        switch (month) {
            case 1:
                monthName = "январь";
                break;
            case 2:
                monthName = "февраль";
                break;
            case 3:
                monthName = "март";
                break;
            case 4:
                monthName = "апрель";
                break;
            case 5:
                monthName = "май";
                break;
            case 6:
                monthName = "июнь";
                break;
            case 7:
                monthName = "июль";
                break;
            case 8:
                monthName = "август";
                break;
            case 9:
                monthName = "сентябрь";
                break;
            case 10:
                monthName = "октябрь";
                break;
            case 11:
                monthName = "ноябрь";
                break;
            case 12:
                monthName = "декабрь";
                break;
            default:
                monthName = "нет такого месяца";
                break;
        }
        System.out.println(monthName);
    }

    static void step3(double a, double b, double c) {
        double discriminant = b * b - 4 * a * c;
        if (discriminant > 0) {
            double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            System.out.println("Корни уравнения: " + root1 + " и " + root2);
        } else if (discriminant == 0) {
            double root = -b / (2 * a);
            System.out.println("Один корень уравнения: " + root);
        } else {
            System.out.println("Корней нет");
        }
    }
}
