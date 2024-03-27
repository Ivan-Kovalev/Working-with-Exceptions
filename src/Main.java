
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        checkAuthorise("Qwerty_123", "Qwerty_123", "Qwerty_123");
    }

    public static void checkAuthorise(String login, String password, String confirmPassword) {
        try {
            checkSyntax(login, password, confirmPassword);
        } catch (WrongLoginException e) {
            System.out.println("Логин должен содержать до 20 символов только латинского алф. и нижние подчеркивания");
        } catch (WrongPasswordException e) {
            System.out.println("Пароль должен содержать до 20 символов только латинского алф. и нижние подчеркивания и совпадать с подтверждением пароля");
        } finally {
            System.out.println("Проверка завершена");
        }
    }

    public static void checkSyntax(String login, String password, String confirmPassword) throws RuntimeException {
        if (login.matches("\\w+") == false || login.length() > 20){
            throw new WrongLoginException();
        }
        if (password.matches("\\w+") == false || password.length() > 20) {
            throw new WrongPasswordException();
        }
        if (confirmPassword.equals(password) == false) {
            throw new WrongPasswordException();
        }
    }

}