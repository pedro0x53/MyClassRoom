package Utils;

import java.util.Scanner;

public class Menu {
    public static int createMenu(String[] items, String defaultValue) {
        Scanner keyboard = new Scanner(System.in);
        if (defaultValue != null) {
            System.out.println("0 - " + defaultValue);
        }
        while (true) {
            for (int i = 0; i < items.length; i++) {
                System.out.println(i + 1 + " - " + items[i]);
            }
            System.out.print("Escolha uma das opções acima: ");
            int req = keyboard.nextInt();
            System.out.println();
            if (req >= 0 && req <= items.length) {
                return req;
            } else {
                System.out.println("Opção inválida.");
            }
        }
    }
}
