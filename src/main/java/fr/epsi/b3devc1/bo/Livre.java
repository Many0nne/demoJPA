package fr.epsi.b3devc1.bo;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import java.util.List;
import java.util.ArrayList;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;


@Entity
@Table(name = "livre")
public class Livre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "titre")
    private String titre;

    @Column(name = "auteur")
    private String auteur;

    @ManyToMany(mappedBy = "livres")
    private List<Emprunt> emprunts;

    public Livre() {
    }

    public Livre(String titre, String auteur) {
        this.titre = titre;
        this.auteur = auteur;
    }

    public String getTitre() {
        return titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public List<Emprunt> getEmprunts() {
        return emprunts;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public void setEmprunts(List<Emprunt> emprunts) {
        this.emprunts = emprunts;
    }
}
