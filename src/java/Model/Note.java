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
public class Note {
    private int Id;
    private double note;
    private String session;
    private Admin admin;
    private Etudiants etudiant;
    private Module module;

    public Note() {
    }

    public Note(int Id, double note, String session, Admin admin, Etudiants etudiant, Module module) {
        this.Id = Id;
        this.note = note;
        this.session = session;
        this.admin = admin;
        this.etudiant = etudiant;
        this.module = module;
    }

    public Note(double note, String session, Admin admin, Etudiants etudiant, Module module) {
        this.note = note;
        this.session = session;
        this.admin = admin;
        this.etudiant = etudiant;
        this.module = module;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public double getNote() {
        return note;
    }

    public void setNote(double note) {
        this.note = note;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
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

    
   
}
