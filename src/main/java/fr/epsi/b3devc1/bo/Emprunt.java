package fr.epsi.b3devc1.bo;

import jakarta.persistence.*;
import java.util.List;
import java.util.ArrayList;

@Entity
@Table(name = "emprunt")
public class Emprunt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "date_debut")
    private String date_debut;

    @Column(name = "date_fin")
    private String date_fin;

    @Column(name = "delai")
    private int delai;

    @ManyToOne
    @JoinColumn(name = "ID_CLIENT")
    private Client client;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "emprunt_livre",
            joinColumns = @JoinColumn(name = "ID_EMPRUNT", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "ID_LIVRE", referencedColumnName = "id")
    )
    private List<Livre> livres;

    public Emprunt() {
    }

    public Emprunt(String date_debut, String date_fin, int delai, Client client) {
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.delai = delai;
        this.client = client;
    }

    public int getId() {
        return id;
    }

    public String getDate_debut() {
        return date_debut;
    }

    public String getDate_fin() {
        return date_fin;
    }

    public int getDelai() {
        return delai;
    }

    public Client getClient() {
        return client;
    }

    public List<Livre> getLivres() {
        return livres;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDate_debut(String date_debut) {
        this.date_debut = date_debut;
    }

    public void setDelai(int delai) {
        this.delai = delai;
    }

    public void setDate_fin(String date_fin) {
        this.date_fin = date_fin;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setLivres(List<Livre> livres) {
        this.livres = livres;
    }

}
