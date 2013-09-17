/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author chris
 */
public class ReceiptFormat1 implements FormatOutputStrategy{
    private StringBuilder stringBuilder = new StringBuilder();
    

    @Override
    public StringBuilder getFormattedReceipt(List<HashMap<String, String>> list) {
        
                   for (HashMap<String, String> map : list) {
    for (Map.Entry<String, String> item: map.entrySet()) {
      
        if(item.getKey().equalsIgnoreCase("Total")){
            stringBuilder.append("<hr>").append(item.getKey()).append("&nbsp; $").append(item.getValue()).append("<br>");
        }
        else if(item.getKey().equalsIgnoreCase("Total with tax")){
        
            stringBuilder.append("<b>").append(item.getKey()).append("</b>&nbsp; $").append(item.getValue()).append("<br>");
        }
        else{
            stringBuilder.append(item.getKey()).append("&nbsp; $").append(item.getValue()).append("<br>");
        }
        
        
                
    }
            
        }
        
        return stringBuilder;
    }
    
}
