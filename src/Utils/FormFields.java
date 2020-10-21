package Utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import static Utils.RegexString.REGEX_EMAIL;

public class FormFields {
    public final Scanner keyboard;

    public boolean isRequired = false;

    public FormFields() { this.keyboard = new Scanner(System.in); }

    public String askForEmail(Boolean isRequired) {
        while (true) {
            System.out.print("Digite o seu email: ");
            String email = this.keyboard.nextLine();
            if (email.matches(REGEX_EMAIL)) {
                return email;
            } else {
                if (isRequired) {
                    System.out.println("O email utilizado não é um email válido.\n");
                } else {
                    return "";
                }
            }
        }
    }

    public String askForDate(String named, String message, Boolean isRequired) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        while (true) {
            System.out.print(message);
            String dateStr = this.keyboard.nextLine();
            try {
                Date date = formatter.parse(dateStr);
                return dateStr;
            } catch (Exception e) {
                if (isRequired) {
                    System.out.println("Digite uma data válida (dd/mm/aaaa).");
                } else {
                    return "";
                }
            }
        }
    }

    public String askForTextField(String named, String message, Boolean isRequired) {
        while (true) {
            System.out.print(message);
            String field = this.keyboard.nextLine();
            if (isRequired) {
                if (field.isEmpty()) {
                    System.out.println("O " + named + " não pode estar vazio.\n");
                } else {
                    return field;
                }
            } else {
                return field;
            }
        }
    }

    public Integer askForNumberField(String named, String message, Boolean isRequired) {
        while (true) {
            System.out.print(message);
            String numberStr = this.keyboard.nextLine();
            try {
                return Integer.parseInt(numberStr);
            } catch (Exception e) {
                if (isRequired) {
                    System.out.println("Digite um número válido.");
                } else {
                    return null;
                }
            }
        }
    }
}
