/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.File;
import java.io.IOException;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

/**
 *
 * @author ikhlas
 */
public class Etudiants {
    private String CNE;
    private int Apogee;
    private String Nom;
    private String Prenom;
    private String CIN;
    private String Password;
    private String sexe;
    private String dateN;
    

    
    private Admin admin;
    

    public Etudiants() {
    }

    public Etudiants(int Apogee, String Nom, String Prenom) {
        this.Apogee = Apogee;
        this.Nom = Nom;
        this.Prenom = Prenom;
    }

    public Etudiants(String CNE, int Apogee, String Nom, String Prenom, String CIN, String Password, String sexe, String dateN) {
        this.CNE = CNE;
        this.Apogee = Apogee;
        this.Nom = Nom;
        this.Prenom = Prenom;
        this.CIN = CIN;
        this.Password = Password;
        this.sexe = sexe;
        this.dateN = dateN;
        
    }

    public Etudiants(String CNE, int Apogee, String Nom, String Prenom, String CIN, String Password, String sexe, String dateN, Admin admin) {
        this.CNE = CNE;
        this.Apogee = Apogee;
        this.Nom = Nom;
        this.Prenom = Prenom;
        this.CIN = CIN;
        this.Password = Password;
        this.sexe = sexe;
        this.dateN = dateN;
       
        this.admin = admin;
    }
    
    
    


    

    public String getDateN() {
        return dateN;
    }

    public void setDateN(String dateN) {
        this.dateN = dateN;
    }

    

    public String getCNE() {
        return CNE;
    }

    

    public int getApogee() {
        return Apogee;
    }

    public void setApogee(int Apogee) {
        this.Apogee = Apogee;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public void setPrenom(String Prenom) {
        this.Prenom = Prenom;
    }

    public String getCIN() {
        return CIN;
    }

    public void setCIN(String CIN) {
        this.CIN = CIN;
    }

    public String getPassword() {
        return Password;
    }

    

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }
    
    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    @Override
    public String toString() {
        return "Etudiant{" + "CNE=" + CNE + ", Apogee=" + Apogee + ", Nom=" + Nom + ", Prenom=" + Prenom + ", CIN=" + CIN + '}';
    }
    
    
}
