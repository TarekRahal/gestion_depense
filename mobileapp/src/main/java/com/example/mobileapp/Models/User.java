package com.example.mobileapp.Models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

@Entity

public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    @SequenceGenerator(name = "user_seq", sequenceName = "user_seq", allocationSize = 1)
    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private Date datenaissance;
    private Long objectif;
    private String devise;
    private String password;
    private Double compte;
    private String status;

public User(String nom, String prenom, String email, Date datenaissance, Long objectif,
String devise, String password, Double compte){
  this.nom=nom;
  this.prenom=prenom;
  this.email=email;
  this.datenaissance=datenaissance;
  this.objectif=objectif;
  this.devise=devise;
  this.password=password;
  this.compte=compte;

}
public User(String status){
this.status=status;
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
     * @return String return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }


    /**
     * @return String return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @return String return the prenom
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * @param prenom the prenom to set
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * @return String return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return Date return the datenaissance
     */
    public Date getDatenaissance() {
        return datenaissance;
    }

    /**
     * @param datenaissance the datenaissance to set
     */
    public void setDatenaissance(Date datenaissance) {
        this.datenaissance = datenaissance;
    }

    /**
     * @return Long return the objectif
     */
    public Long getObjectif() {
        return objectif;
    }

    /**
     * @param objectif the objectif to set
     */
    public void setObjectif(Long objectif) {
        this.objectif = objectif;
    }


    /**
     * @return Double return the compte
     */
    public Double getCompte() {
        return compte;
    }

    /**
     * @param compte the compte to set
     */
    public void setCompte(Double compte) {
        this.compte = compte;
    }


    /**
     * @return String return the devise
     */
    public String getDevise() {
        return devise;
    }

    /**
     * @param devise the devise to set
     */
    public void setDevise(String devise) {
        this.devise = devise;
    }


    /**
     * @return String return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

}
