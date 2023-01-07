/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author DELL
 */
@Embeddable
public class PharmacieDeGardePK implements Serializable{
    private int pharmacie;
    private int garde;
    @Temporal(TemporalType.DATE)
    private Date dateDebut;

    public PharmacieDeGardePK() 
    {
    }

    public PharmacieDeGardePK(int pharmacie, int garde, Date dateDebut) {
        this.pharmacie = pharmacie;
        this.garde = garde;
        this.dateDebut = dateDebut;
    }

    public int getPharmacie() {
        return pharmacie;
    }

    public void setPharmacie(int pharmacie) {
        this.pharmacie = pharmacie;
    }

    public int getGarde() {
        return garde;
    }

    public void setGarde(int garde) {
        this.garde = garde;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }
    
    
    
}
