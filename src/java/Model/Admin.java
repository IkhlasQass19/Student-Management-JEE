/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author ikhlas
 */
public class Admin {
    private int SOM;
    private String Nom;
    private String Prenom;
    private String Password;
    private String CIN;

    public Admin() {
    }

    public Admin(int SOM, String Nom, String Prenom, String Password, String CIN) {
        this.SOM = SOM;
        this.Nom = Nom;
        this.Prenom = Prenom;
        this.Password = Password;
        this.CIN = CIN;
    }

    public int getSOM() {
        return SOM;
    }

    public void setSOM(int SOM) {
        this.SOM = SOM;
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

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getCIN() {
        return CIN;
    }

    public void setCIN(String CIN) {
        this.CIN = CIN;
    }
    
    
}
