package Utils;

import java.util.Scanner;

public class Menu {
    public static int createMenu(String[] items) {
        Scanner keyboard = new Scanner(System.in);
        while (true) {
            for (int i = 0; i < items.length; i++) {
                System.out.println(i + 1 + " - " + items[i]);
            }
            System.out.print("Escolha uma das opções acima: ");
            int req = keyboard.nextInt() - 1;
            System.out.println();
            if (req >= 0 && req < items.length) {
                return req;
            } else {
                System.out.println("Opção inválida.");
            }
        }
    }
}
