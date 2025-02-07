package fr.epsi.b3devc1.bo;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;


@Entity
@Table(name = "livre")
public class Livre {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "titre")
    private String titre;

    @Column(name = "auteur")
    private String auteur;

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

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }
}
