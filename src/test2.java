/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Aristide
 */
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;
import net.sf.json.JSON;


import java.io.*;

public class test2 {
    
    public static boolean ValiderCycle(JSONObject json){
        boolean reponse = false;
        if(json.getString("cycle").equalsIgnoreCase("2012-2014")){
            reponse = true;
        }
        return reponse;
    }
    
    
public static void ecrire( String nomFichier, JSONObject json) {
FileWriter writer;
PrintWriter printer;
String chaineLue;
try {
writer = new FileWriter( nomFichier ); // IOException
printer = new PrintWriter( writer );

chaineLue = json.toString();
printer.println( chaineLue );

// Ne pas oublier de fermer le fichier
printer.close();
} catch ( IOException e ) {
System.out.println( e.getMessage() );
}
}

    
    
    public static void main(String [] args) throws Exception{
        
        String FichierEntree = "fentree.json";  
        String [] categories = {"cours","atelier", "seminaire", "colloque", "conference","lecture dirigee", "presentation","groupe de discussion", "projet de recherche","redaction professionnelle"};        
        String json = FileReader.loadFileIntoString(FichierEntree, "utf-8");
        JSONObject object = JSONObject.fromObject(json);
        JSONArray array = object.getJSONArray("activites");
        
        if(ValiderCycle(object)){
            JSONObject activite = new JSONObject();
            activite.accumulate("complet", true);
            JSONArray irr = new JSONArray();
            irr.add("Le cycle est complet");
            activite.accumulate("valide", irr);
     

     
            ecrire("text.json", activite);
        }else{
            JSONObject i = new JSONObject();
            i.accumulate("erreurs", "Le cycle est invalide");
            i.accumulate("filepath","C:Users.Aristide.Documents.NetBeansProjects.TravailDeSession1.test.json" );
            ecrire("curseur.json", i);
        }
        
    }
    
}
        
    
     
     

     
    
    
   

    



    
    
        
            
                    
                
                