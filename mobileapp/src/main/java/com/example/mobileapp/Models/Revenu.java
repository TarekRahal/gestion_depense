package com.example.mobileapp.Models;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;

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

    @ManyToOne
    @JoinColumn(name = "userId")
    @JsonBackReference
    private User user;

public Revenu(Double valeur, Date date){
  this.valeur=valeur;
  this.date=date;
}

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


    /**
     * @return Set<Salaire> return the salaire
     */
    public Set<Salaire> getSalaire() {
        return salaire;
    }

    /**
     * @param salaire the salaire to set
     */
    public void setSalaire(Set<Salaire> salaire) {
        this.salaire = salaire;
    }

    /**
     * @return User return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(User user) {
        this.user = user;
    }

}
