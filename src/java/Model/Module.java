/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author kh
 */
public class Module {
    private int Id_module;
    private String intitule;
    private String semestre;

    public Module() {
    }

    
    public Module(int Id_module, String intitule, String semestre) {
        this.Id_module = Id_module;
        this.intitule = intitule;
        this.semestre = semestre;
    }
    
    

    public Module( String intitule, String semestre) {
        
        this.intitule = intitule;
        this.semestre = semestre;
    }

    public int getId_module() {
        return Id_module;
    }

    public void setId_module(int Id_module) {
        this.Id_module = Id_module;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }
    
    
    
}
