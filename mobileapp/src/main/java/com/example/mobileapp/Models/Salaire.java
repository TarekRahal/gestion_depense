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

public class Salaire implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "credit_seq")
    @SequenceGenerator(name = "credit_seq", sequenceName = "credit_seq", allocationSize = 1)
    private Long id;
    private String travail;
    @ManyToOne
    @JoinColumn(name = "revenuId")
    @JsonBackReference
    private Revenu revenu;
public Salaire(){

}

    public Salaire(String travail){
      this.travail=travail;
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
     * @return String return the travail
     */
    public String getTravail() {
        return travail;
    }

    /**
     * @param travail the travail to set
     */
    public void setTravail(String travail) {
        this.travail = travail;
    }

}
