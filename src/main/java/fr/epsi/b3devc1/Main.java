package fr.epsi.b3devc1;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import fr.epsi.b3devc1.bo.Livre;

public class Main {
    public static void main(String[] args) {

        try( EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo-jpa")) {
            System.out.println("EntityManagerFactory created");
            EntityManager em = emf.createEntityManager();

            Livre livre = em.find(Livre.class, 1);

            System.out.println("Titre : " + livre.getTitre());
            System.out.println("Auteur : " + livre.getAuteur());
        }
    }
}