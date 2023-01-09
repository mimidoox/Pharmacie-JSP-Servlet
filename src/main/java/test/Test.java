/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import entities.Utilisateur;
import entities.Ville;
import entities.Zone;
import service.UtilisateurService;
import service.VilleService;
import service.ZoneService;

/**
 *
 * @author DELL
 */
public class Test {
    
	

    public static void main(String[] args) {
    UtilisateurService us = new UtilisateurService();
    VilleService vs = new VilleService();
    /*
    vs.create(new Ville("MARRAKECH"));
    vs.create(new Ville("CASABLANCA"));
    vs.create(new Ville("RABAT"));
    vs.create(new Ville("TANGER"));
    vs.create(new Ville("FES"));
    vs.create(new Ville("SAFI"));
    vs.create(new Ville("AGADIR")); */
    
    ZoneService zs = new ZoneService();
   /* 
    zs.create(new Zone("MEDINA",vs.findById(1)));
    zs.create(new Zone("GRAND GUELIZ",vs.findById(1)));
    zs.create(new Zone("DAOUDIAT",vs.findById(1)));
    zs.create(new Zone("HAY AL FADL",vs.findById(1)));
    zs.create(new Zone("SIDI GHANNEM AZZOUZIA",vs.findById(1)));
    zs.create(new Zone("TARGA",vs.findById(1)));
    zs.create(new Zone("HAY HASSANI",vs.findById(1)));
    zs.create(new Zone("AÏN ITTI",vs.findById(1)));
    zs.create(new Zone("SIDI YOUSSEF",vs.findById(1)));
    zs.create(new Zone("LAHAMID",vs.findById(1)));
*/
   /* zs.create(new Zone("AIN CHOK",vs.findById(2)));*/
    for(Zone z : zs.findZonesByVille(vs.findById(1))){
        System.out.println(z.getNom());
    }  
    
	
}
}