package test;
import cartes.*;

public class Main {
    public static void main(String[] args) {
        Serviteur serviteur1 = new Serviteur("Ursoc", 9, 14, 6, "Aucun");
        Serviteur serviteur2 = new Serviteur("Acolyte squelettique", 1, 2, 1, "Cri de guerre");

        System.out.println(serviteur1);
        System.out.println(serviteur2);

        serviteur1.attaquer(serviteur2);
        serviteur2.attaquer(serviteur1);
    }
}