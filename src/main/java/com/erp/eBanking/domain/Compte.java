package com.erp.eBanking.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Compte  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    @Column(unique = true , updatable = false)
    private Long numeroCompte ;
    private double soldeCompte ;
    private double soldeComptable ;
    private String compteLeader ;
    @OneToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "CODE_ABONNE")
    private Abonne abonne ;


    public Compte() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNumeroCompte() {
        return numeroCompte;
    }

    public void setNumeroCompte(Long numeroCompte) {
        this.numeroCompte = numeroCompte;
    }

    public double getSoldeCompte() {
        return soldeCompte;
    }

    public void setSoldeCompte(double soldeCompte) {
        this.soldeCompte = soldeCompte;
    }

    public double getSoldeComptable() {
        return soldeComptable;
    }

    public void setSoldeComptable(double soldeComptable) {
        this.soldeComptable = soldeComptable;
    }

    public String getCompteLeader() {
        return compteLeader;
    }

    public void setCompteLeader(String compteLeader) {
        this.compteLeader = compteLeader;
    }

    public Abonne getAbonne() {
        return abonne;
    }

    public void setAbonne(Abonne abonne) {
        this.abonne = abonne;
    }


}
