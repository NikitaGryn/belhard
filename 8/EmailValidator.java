public class EmailValidator {
    public void validate(String email) throws InvalidEmailException {
        if (email == null || email.isEmpty()) {
            throw new InvalidEmailException("Email cannot be null or empty.");
        }
        if (!email.contains("@") || email.startsWith("@") || email.endsWith("@") || email.startsWith(".") || email.endsWith(".")) {
            throw new InvalidEmailException("Invalid email format.");
        }
    }
}
