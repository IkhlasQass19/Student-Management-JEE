/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;
import Model.Etudiants;
import Model.Module;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


/**
 *
 * @author ikhlas
 */
public class Trai {
    
    public List<Module> getModules(String p) throws JDOMException, IOException{
        List<Module> m = new ArrayList<Module>();
        SAXBuilder builder = new SAXBuilder();
        File f =new File(p);
        Document document = builder.build(f);
        List<Element> mod = document.getRootElement().getChild("Modules").getChildren();
        for(Element e : mod){
            m.add(new Module(Integer.parseInt(e.getAttributeValue("Id_module")), e.getAttributeValue("intitule"), e.getAttributeValue("semestre")));
        }
        return m;
    }
    
    
    public List<Etudiants> getEtudiants(String p) throws JDOMException, IOException{
        List<Etudiants> m = new ArrayList<Etudiants>();
        SAXBuilder builder = new SAXBuilder();
        File f =new File(p);
        Document document = builder.build(f);
        List<Element> mod = document.getRootElement().getChild("Etudiants").getChildren();
        for(Element e : mod){
            m.add(new Etudiants(Integer.parseInt(e.getAttributeValue("Apogee")), e.getAttributeValue("Nom"), e.getAttributeValue("Prenom")));
        }
        return m;
    }
    
    
    public Etudiants getEtudiant(String p,String cne) throws JDOMException, IOException{
        Etudiants m = new Etudiants();
        SAXBuilder builder = new SAXBuilder();
        File f =new File(p);
        Document document = builder.build(f);
        List<Element> mod = document.getRootElement().getChild("Etudiants").getChildren();
        for(Element e : mod){
            if(e.getAttributeValue("CNE").equalsIgnoreCase(cne))
            m= new Etudiants(Integer.parseInt(e.getAttributeValue("Apogee")), e.getAttributeValue("Nom"), e.getAttributeValue("Prenom"));
        }
        return m;
    }
    
    
    public Map<String, String[][]> getModSem(String p, Etudiants et) throws JDOMException, IOException{
        SAXBuilder builder = new SAXBuilder();
        File f =new File(p);
        Document document = builder.build(f);
        Map<String, String> module = new HashMap<String,String>();
        Map<String, String[][]> map= new HashMap<String,String[][]>();
        List<Element> inscr = document.getRootElement().getChild("Inscrire").getChildren();
        List<Element> m = document.getRootElement().getChild("Modules").getChildren();
        for(Element ins : inscr){
            if(ins.getAttributeValue("CNE").equalsIgnoreCase(et.getCNE())){
                for(Element mod : m){
                    if(mod.getAttributeValue("Id_module").equalsIgnoreCase(ins.getAttributeValue("Id_module"))){
                        if(module.containsKey(mod.getAttributeValue("semestre")))
                            module.put(mod.getAttributeValue("semestre"), module.get(mod.getAttributeValue("semestre"))+","+mod.getAttributeValue("intitule")+";"+ins.getAttributeValue("annee"));
                        else
                            module.put(mod.getAttributeValue("semestre"), mod.getAttributeValue("intitule")+";"+ins.getAttributeValue("annee"));
                    }
                }
            }
                
        }
        for (Map.Entry entry : module.entrySet()) {
            
            String[] str = entry.getValue().toString().split(",");
            String[][] t = new String[str.length][2];
            for(int i=0;i<str.length;i++){
                t[i]=str[i].split(";");
            }
            map.put(entry.getKey().toString(), t);
        }
       return map; 
        
    }
    
    
    public Map<String, Double> getNoteSemestreO(String p, String cne,int semestre,String ses) throws JDOMException, IOException{
        SAXBuilder builder = new SAXBuilder();
        File f =new File(p);
        Map<String, Double> noteS = new HashMap<String,Double>();
        Document document = builder.build(f);
        List<Element> notes = document.getRootElement().getChild("Notes").getChildren();
        List<Element> modules = document.getRootElement().getChild("Modules").getChildren();
        List<Element> Inscrires = document.getRootElement().getChild("Inscrire").getChildren();
        for(Element ins : Inscrires){
            if(ins.getAttributeValue("CNE").equalsIgnoreCase(cne)){
        for(Element e : modules){
            
            if(Integer.parseInt(e.getAttributeValue("semestre"))==semestre && e.getAttributeValue("Id_module").equalsIgnoreCase(ins.getAttributeValue("Id_module"))){
                for(Element n : notes){
                    if(n.getAttributeValue("Id_module").equalsIgnoreCase(e.getAttributeValue("Id_module")) && n.getAttributeValue("session").equalsIgnoreCase(ses))
                        noteS.put(e.getAttributeValue("intitule"), Double.parseDouble(n.getAttributeValue("note")));
                }
            }
        }}}
      return noteS;  
    }
    
    public void enrgNoteSemestre(String p,String sem,String cne,String p2,String nom,String prenom) throws IOException, JDOMException{
      SAXBuilder builder = new SAXBuilder();
               Map<String, Double> noteS = getNoteSemestreO(p2,cne,Integer.parseInt(sem),"o");
               Map<String, Double> noteR = getNoteSemestreO(p2,cne,Integer.parseInt(sem),"r");
               File xmlFile = new File(p);
               
               Document doc;
               try {
                   doc = (Document) builder.build(xmlFile);
                   Element rootNode = doc.getRootElement();
                   Element s = rootNode.getChild("Semestre");
                   s.removeContent();
                   s.getAttribute("id").setValue(sem);
                   
                   Element CNE = new Element("CNE").setText(cne);
                   s.addContent(CNE);
                   
                   Element Nom = new Element("Nom").setText(nom);
                   s.addContent(Nom);
                   
                   Element Prenom = new Element("Prenom").setText(prenom);
                   s.addContent(Prenom);
                   
                   Element so = new Element("SessionOrdinaire");
                   for (Map.Entry entry : noteS.entrySet()){
                       Element Intitule = new Element("Intitule").setText(entry.getKey().toString());
                        Element Module = new Element("Module");
                       Module.addContent(Intitule);
                       if(entry.getValue().toString().equalsIgnoreCase("-1.0")){
                           Element Note = new Element("Note").setText("absence justiée");
                           Module.addContent(Note);
                       }
                       else{
                           if(entry.getValue().toString().equalsIgnoreCase("-2.0")){
                       Element Note = new Element("Note").setText("absence non-justiée");
                       Module.addContent(Note);}
                           else{Element Note = new Element("Note").setText(entry.getValue().toString());
                       Module.addContent(Note);}
                       }
                       
                      
                       
                   so.addContent(Module);
                   }
                   s.addContent(so);
                   
                   Element sr = new Element("SessionRattrapage");
                   for (Map.Entry entry : noteR.entrySet()){
                       noteS.put(entry.getKey().toString(), Double.parseDouble(entry.getValue().toString()));
                       Element Intitule = new Element("Intitule").setText(entry.getKey().toString());
                       Element Note = new Element("Note").setText(entry.getValue().toString());
                       
                       Element Module = new Element("Module");
                       Module.addContent(Intitule);
                       Module.addContent(Note);
                   sr.addContent(Module);
                   }
                   s.addContent(sr);
                   
                   
                   XMLOutputter xmlOutput = new XMLOutputter();
                   
                   //display nice nice
                   xmlOutput.setFormat(Format.getPrettyFormat());
                   xmlOutput.output(doc, new FileWriter(p));
                   
               } catch (JDOMException ex) {
                   Logger.getLogger(ReleveEt2.class.getName()).log(Level.SEVERE, null, ex);
               }
    }
    
    public List<Element> getNotes(String p) throws JDOMException, IOException{
        List<Element> notes = new ArrayList<Element>();
        SAXBuilder builder = new SAXBuilder();
        File f =new File(p);
        Document document = builder.build(f);
        notes = document.getRootElement().getChild("Notes").getChildren();
        return notes;
    }
    
    public void enrgModuleNote(String id,String p,String p2) throws JDOMException, IOException{
        SAXBuilder builder = new SAXBuilder();
        List<Element> notes = getNotes(p2);
        File xmlFile = new File(p);
        Document doc;
        Module m = new Module();
        List<Module> mod = getModules(p2);
        for(Module m1 : mod){
            if(m1.getId_module()==Integer.parseInt(id)){
                m=new Module(m1.getId_module(), m1.getIntitule(), m1.getSemestre());
                break;
            }
        }
        doc = (Document) builder.build(xmlFile);
                   Element rootNode = doc.getRootElement();
                   Element s = rootNode.getChild("Module");
                   s.removeContent();
                   s.getAttribute("intitule").setValue(m.getIntitule());
                   s.getAttribute("semestre").setValue(m.getSemestre());
        for(Element n : notes){
            if(n.getAttributeValue("Id_module").equalsIgnoreCase(id)){
                Etudiants et = getEtudiant(p2,n.getAttributeValue("CNE"));
                String se = "";
                if(n.getAttributeValue("session").equalsIgnoreCase("o"))
                    se="Ordinaire";
                else
                    se="Rattrapage";
                Element etudiant = new Element("Etudiant");
                Element apogee = new Element("Apogee").setText(String.valueOf(et.getApogee()));
                Element nom = new Element("Nom").setText(et.getNom());
                Element prenom = new Element("Prenom").setText(et.getPrenom());
                Element note = new Element("Note").setText(n.getAttributeValue("note"));
                Element session = new Element("Session").setText(se);
                etudiant.addContent(apogee);
                etudiant.addContent(nom);
                etudiant.addContent(prenom);
                etudiant.addContent(note);
                etudiant.addContent(session);
                s.addContent(etudiant);
                
            }
        }
        XMLOutputter xmlOutput = new XMLOutputter();
                   
                   //display nice nice
                   xmlOutput.setFormat(Format.getPrettyFormat());
                   xmlOutput.output(doc, new FileWriter(p));
    }
    
    public void getEtListesSemestre(String p,String p2,String sem) throws JDOMException, IOException{
        List<Module> mod = getModules(p2);
        JSONObject obj = new JSONObject();
        SAXBuilder builder = new SAXBuilder();
        
        File f =new File(p2);
        Document document = builder.build(f);
        List<Element> Inscrires = document.getRootElement().getChild("Inscrire").getChildren();
        for(Module m1 : mod){
            if(m1.getSemestre().equalsIgnoreCase(sem)){
                
                for(Element e : Inscrires){
                    
                    if(Integer.parseInt(e.getAttributeValue("Id_module")) == m1.getId_module()){
                        
                        Etudiants et = getEtudiant(p2,e.getAttributeValue("CNE"));
                        JSONArray list = new JSONArray();
                        list.add("Apogee : "+et.getApogee());
                        list.add("Nom : "+et.getNom());
                        list.add("Prenom : "+et.getPrenom());
       
        obj.put(list, " etudiant ");
        try (FileWriter file = new FileWriter(p)) {
            file.write(obj.toString());
        } catch (IOException exp) {
            exp.printStackTrace();
        }
                    }
                }
          
    }}}
}


