/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author DELL
 */
@Entity
public class Pharmacien extends Utilisateur{
    private String email;
    private String telephone;
    private String nom;
    private String prenom;
    @Temporal(TemporalType.DATE)
    private Date dateCreation;

    public Pharmacien() 
    {
    	dateCreation = new Date();
    }

    public Pharmacien(String email, String telephone, String nom, String prenom, String login, String password) {
        super(login, password);
        this.email = email;
        this.telephone = telephone;
        this.nom = nom;
        this.prenom = prenom;
        dateCreation = new Date();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	@Override
	public String toString() {
		return  nom + " " + prenom ;
	}
    
    
    
    
    
    
    
}
