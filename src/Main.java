import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        checkAuthorise("Qwerty_123", "Qwerty_123", "Qwerty_123");
    }

    private final static Pattern PATTERN = Pattern.compile("\\w+");

    public static void checkAuthorise(String login, String password, String confirmPassword) {
        try {
            checkSyntax(login, password, confirmPassword);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void checkSyntax(String login, String password, String confirmPassword) {
        if (login == null || password == null || confirmPassword == null) {
            throw new RuntimeException("Заполните все поля!");
        }
        if (!PATTERN.matcher(login).matches() || login.length() > 20) {
            throw new WrongLoginException("Логин должен содержать до 20 символов только латинского алф. и нижние подчеркивания");
        }
        if (!PATTERN.matcher(password).matches() || password.length() > 20) {
            throw new WrongPasswordException("Пароль должен содержать до 20 символов только латинского алф. и нижние подчеркивания");
        }
        if (!confirmPassword.equals(password)) {
            throw new WrongPasswordException("Пароли не совпадают");
        }
        System.out.println("Проверка завершена, авторизация пройдена!");
    }

}