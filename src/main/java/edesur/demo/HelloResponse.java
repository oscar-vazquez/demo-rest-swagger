package edesur.demo;

public class HelloResponse {
    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getInEnglish() {
        return inEnglish;
    }

    public void setInEnglish(String inEnglish) {
        this.inEnglish = inEnglish;
    }

    private String mensaje;
    private String inEnglish;
}
