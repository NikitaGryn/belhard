public class Main {
    public static void main(String[] args) {
        try {
            BankAccount account = new BankAccount(1000);
            account.deposit(500);
            System.out.println("Balance after deposit: " + account.getBalance());
            account.withdraw(200);
            System.out.println("Balance after withdrawal: " + account.getBalance());
            account.withdraw(2000);

        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
        }

        try {
            Calculator calculator = new Calculator();
            double result = calculator.divide(10, 2);
            System.out.println("Division result: " + result);
            result = calculator.divide(10, 0);

        } catch (DivisionByZeroException e) {
            System.out.println(e.getMessage());
        }

        try {
            EmailValidator validator = new EmailValidator();
            validator.validate("test@example.com");
            System.out.println("Email is valid.");
            validator.validate("invalid-email");

        } catch (InvalidEmailException e) {
            System.out.println(e.getMessage());
        }
    }
}
