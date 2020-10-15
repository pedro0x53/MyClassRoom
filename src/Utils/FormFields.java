package Utils;

import java.util.Scanner;

import static Utils.RegexString.REGEX_EMAIL;

public class FormFields {
    private final Scanner keyboard;

    public FormFields() {
        this.keyboard = new Scanner(System.in);
    }

    public String askForEmail() {
        while (true) {
            System.out.print("Digite o seu email: ");
            String login = this.keyboard.nextLine();
            if (login.matches(REGEX_EMAIL)) {
                return login;
            } else {
                System.out.println("O email utilizado não é um email válido.\n");
            }
        }
    }

    public String askForNonVoidField(String named) {
        while (true) {
            System.out.print(named + ": ");
            String field = this.keyboard.nextLine();
            if (!field.isEmpty()) {
                return field;
            } else {
                System.out.println("O campo " + named + " não pode estar vazio.\n");
            }
        }
    }
}
