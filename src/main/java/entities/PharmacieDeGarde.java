/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.Date;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/**
 *
 * @author DELL
 */
@Entity
public class PharmacieDeGarde {
    @EmbeddedId
    private PharmacieDeGardePK pk;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateFin;
    @ManyToOne
    @JoinColumn(name = "pharmacie", insertable = false, updatable = false)
    private Pharmacie pharmacie;
    @ManyToOne
    @JoinColumn(name = "garde", insertable = false, updatable = false)
    private Garde garde;

    public PharmacieDeGarde() 
    {
    }

    public PharmacieDeGarde(PharmacieDeGardePK pk, Date dateFin, Pharmacie pharmacie, Garde garde) {
        this.pk = pk;
        this.dateFin = dateFin;
        this.pharmacie = pharmacie;
        this.garde = garde;
    }

    public PharmacieDeGardePK getPk() {
        return pk;
    }

    public void setPk(PharmacieDeGardePK pk) {
        this.pk = pk;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public Pharmacie getPharmacie() {
        return pharmacie;
    }

    public void setPharmacie(Pharmacie pharmacie) {
        this.pharmacie = pharmacie;
    }

    public Garde getGarde() {
        return garde;
    }

    public void setGarde(Garde garde) {
        this.garde = garde;
    }
    
    
}
