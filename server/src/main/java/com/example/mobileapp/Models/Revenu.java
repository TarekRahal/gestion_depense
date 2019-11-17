package com.example.mobileapp.Models;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

@Entity

public class Revenu implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "revenu_seq")
    @SequenceGenerator(name = "revenu_seq", sequenceName = "revenu_seq", allocationSize = 1)
    private Long id;
    private Double valeur;
    private Date date;

    @OneToMany(mappedBy = "revenu", cascade = CascadeType.ALL)
    private Set<Vente> vente;

    @OneToMany(mappedBy = "revenu", cascade = CascadeType.ALL)
    private Set<Credit> credit;

    @OneToMany(mappedBy = "revenu", cascade = CascadeType.ALL)
    private Set<Salaire> salaire;



    /**
     * @return Long return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return Double return the valeur
     */
    public Double getValeur() {
        return valeur;
    }

    /**
     * @param valeur the valeur to set
     */
    public void setValeur(Double valeur) {
        this.valeur = valeur;
    }

    /**
     * @return Date return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }


    /**
     * @return Set<Vente> return the vente
     */
    public Set<Vente> getVente() {
        return vente;
    }

    /**
     * @param vente the vente to set
     */
    public void setVente(Set<Vente> vente) {
        this.vente = vente;
    }

    /**
     * @return Set<Credit> return the credit
     */
    public Set<Credit> getCredit() {
        return credit;
    }

    /**
     * @param credit the credit to set
     */
    public void setCredit(Set<Credit> credit) {
        this.credit = credit;
    }

}
