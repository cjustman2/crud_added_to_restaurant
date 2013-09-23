/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.swing.text.NumberFormatter;

/**
 *
 * @author chris
 */
public class StringToArrayFormat implements FormatInputStrategy{
            private String order = null;
            private String[] orderItems = null;
            
            private DataAccessStrategy das = new EntreeService();
          
  
            
            
            
            
            
            
    @Override
    public List formatInput(String order) {
        this.order = order;
        
        
        
        
        orderItems = order.split("\r");
        
        
        
        //get rid of new line character
        for(int i = 0; i < orderItems.length; i++){
            
            
          orderItems[i] = orderItems[i].replaceAll("\\n", "");
            
        }
        
        
        
        List<HashMap<String,String>> list = null ;
        
        
        
        
        
        
        
      
       return list;
    }
    
}
