/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import org.hibernate.annotations.NamedQuery;

/**
 *
 * @author DELL
 */
@Entity
@NamedQuery(name = "findPharmaciesByZone", query = "from Pharmacie where Zone_id= :id")
public class Pharmacie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private String adresse;
    private double latitude;
    private double longitude;
    @ManyToOne
    private Zone zone;
    @ManyToOne 
    private Pharmacien pharmacien;
    @OneToMany (mappedBy = "pharmacie", fetch = FetchType.EAGER)
    private List<Photo> photos;
    

    public Pharmacie() 
    {
    }

    public Pharmacie(String nom, String adresse, double latitude, double longitude, Zone zone, Pharmacien pharmacien, List<Photo> photos) {
        this.nom = nom;
        this.adresse = adresse;
        this.latitude = latitude;
        this.longitude = longitude;
        this.zone = zone;
        this.pharmacien = pharmacien;
        this.photos = photos;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public Zone getZone() {
        return zone;
    }

    public void setZone(Zone zone) {
        this.zone = zone;
    }

    public Pharmacien getPharmacien() {
        return pharmacien;
    }

    public void setPharmacien(Pharmacien pharmacien) {
        this.pharmacien = pharmacien;
    }

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }
    


    @Override
    public String toString() {
        return "Pharmacie "+ nom;
    }
    
    
    
    
}
