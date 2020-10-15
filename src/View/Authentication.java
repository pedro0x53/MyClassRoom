package View;

import Utils.FormFields;

public class Authentication {
    private FormFields form;

    public Authentication() {
        this.form = new FormFields();
    }

    public String[] login() {
        String[] fields = new String[2];
        fields[0] = form.askForEmail();
        fields[1] = form.askForNonVoidField("Senha");
        return fields;
    }

    public String[] signUp() {
        String[] fields = new String[3];
        fields[0] = form.askForNonVoidField("Nome");
        fields[1] = form.askForEmail();
        fields[2] = form.askForNonVoidField("Senha");
        return fields;
    }
}
