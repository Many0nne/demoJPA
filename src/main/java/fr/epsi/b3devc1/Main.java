package fr.epsi.b3devc1;

import fr.epsi.b3devc1.bo.Client;
import fr.epsi.b3devc1.bo.Emprunt;
import fr.epsi.b3devc1.bo.Livre;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo-jpa")) {
            System.out.println("EntityManagerFactory created");
            EntityManager em = emf.createEntityManager();

            em.getTransaction().begin();

            Client client = em.find(Client.class, 1);
            if (client == null) {
                System.out.println("Client not found");
                return;
            }

            StringBuilder output = new StringBuilder();
            output.append("Books borrowed by Client ID: ").append(client.getId()).append("\n");

            for (Emprunt emprunt : client.getEmprunts()) {
                output.append("Emprunt ID: ").append(emprunt.getId()).append("\n");

                for (Livre livre : emprunt.getLivres()) {
                    output.append(" - ").append(livre.getTitre()).append(" by ").append(livre.getAuteur()).append("\n");
                }
            }

            Livre livre = new Livre("New Book Title", "New Book Author");
            em.persist(livre);

            Emprunt emprunt = new Emprunt("2023-10-01", "2023-10-15", 14, client);
            List<Livre> livres = new ArrayList<>();
            livres.add(livre);
            emprunt.setLivres(livres);
            em.persist(emprunt);

            List<Emprunt> emprunts = client.getEmprunts();
            if (emprunts == null) {
                emprunts = new ArrayList<>();
                client.setEmprunts(emprunts);
            }
            emprunts.add(emprunt);

            em.getTransaction().commit();

            System.out.println("New loan and book added successfully");



        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}