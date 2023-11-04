/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Model.Module;

/**
 *
 * @author ikhlas
 */
public class Inscrire {
    private Etudiants etudiant;
    private Module module;
    private String annee;

    public Inscrire() {
    }

    public Inscrire(Etudiants etudiant, Module module, String annee) {
        this.etudiant = etudiant;
        this.module = module;
        this.annee = annee;
    }

    
    public Etudiants getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiants etudiant) {
        this.etudiant = etudiant;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    public String getAnnee() {
        return annee;
    }

    public void setAnnee(String annee) {
        this.annee = annee;
    }
    
    
}
