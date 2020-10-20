package View;

import Utils.FormFields;

public class Authentication {
    private FormFields ff = new FormFields();

    public String[] login() {
        String[] fields = new String[2];
        fields[0] = ff.askForTextField("Login", "Digite seu login: ", true);
        fields[1] = fields[0] = ff.askForTextField("Senha", "Digite sua senha: ", true);
        return fields;
    }

    public String[] signUp() {
        String[] fields = new String[3];
        fields[0] = ff.askForTextField("Nome", "Digite seu nome: ", true);
        fields[1] = ff.askForTextField("Login", "Digite seu login: ", true);
        fields[2] = fields[0] = ff.askForTextField("Senha", "Digite sua senha: ", true);
        return fields;
    }
}
