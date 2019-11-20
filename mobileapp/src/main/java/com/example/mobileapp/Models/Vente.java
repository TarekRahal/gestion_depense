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

public class Vente implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vente_seq")
    @SequenceGenerator(name = "vente_seq", sequenceName = "vente_seq", allocationSize = 1)
    private Long id;
    private String detaildevente;
    private Double totalvente;
    public Vente(String detaildevente, Double totalvente){
      this.detaildevente=detaildevente;
      this.totalvente=totalvente;
    }

    @ManyToOne
    @JoinColumn(name = "revenuId")
    @JsonBackReference
    private Revenu revenu;


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
     * @return Revenu return the revenu
     */
    public Revenu getRevenu() {
        return revenu;
    }

    /**
     * @param revenu the revenu to set
     */
    public void setRevenu(Revenu revenu) {
        this.revenu = revenu;
    }


    /**
     * @return String return the detaildevente
     */
    public String getDetaildevente() {
        return detaildevente;
    }

    /**
     * @param detaildevente the detaildevente to set
     */
    public void setDetaildevente(String detaildevente) {
        this.detaildevente = detaildevente;
    }

    /**
     * @return Double return the totalvente
     */
    public Double getTotalvente() {
        return totalvente;
    }

    /**
     * @param totalvente the totalvente to set
     */
    public void setTotalvente(Double totalvente) {
        this.totalvente = totalvente;
    }

}
