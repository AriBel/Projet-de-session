

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Aristide
 * 
 */
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import java.io.*;
import java.text.DecimalFormat;

public class Tests {
    public static void main (String [] args) throws FileNotFoundException, IOException{
        
      String json = FileReader.loadFileIntoString("curseur.json","utf-8");
        JSONArray cds = JSONArray.fromObject(json);

        // Build the album list to add in the order
        JSONArray albums = new JSONArray();
        double total = 0.0;
        for(int i = 0; i < cds.size(); i++) {
            JSONObject album = cds.getJSONObject(i);
            if(album.getDouble("price") < 10.0) {
                   total += album.getDouble("price");
                   albums.add(album);
            }
        }

        // Format the price
        DecimalFormat format = new DecimalFormat();
        format.setMinimumFractionDigits(2);
        String totalStr = format.format(total);

        // Build the order
        JSONObject order = new JSONObject();
        order.accumulate("id", "1321033823");
        order.accumulate("total", totalStr);
        order.accumulate("date", "11/11/2011");
        order.accumulate("validated", true);
        order.accumulate("albums", albums);

        System.out.println(order);
        
    }
}

        
    
    
    
    

