package View;

import Utils.FormFields;

public class Authentication {
    private FormFields ff = new FormFields();

    public String[] login() {
        System.out.println("----- Login -----");
        String[] fields = new String[2];
        fields[0] = ff.askForEmail(true);
        fields[1] = ff.askForTextField("Senha", "Digite sua senha: ", true);
        return fields;
    }

    public String[] signUp() {
        System.out.println("----- Cadastro -----");
        String[] fields = new String[3];
        fields[0] = ff.askForTextField("Nome", "Digite seu nome: ", true);
        fields[1] = ff.askForEmail(true);
        fields[2] = fields[0] = ff.askForTextField("Senha", "Digite sua senha: ", true);
        return fields;
    }
}
