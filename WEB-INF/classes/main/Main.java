package main;
import utilitaire.Utilitaire;

public class Main {
    public static void main(String[] args) {
        String url = "http://localhost:8090/manager/html";
        System.out.println(Utilitaire.getURLParameter(url));
    }
}
