/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.swing.text.NumberFormatter;

/**
 *
 * @author chris
 */
public class FormatInput {
            private String order = null;
            private String[] orderItems = null;
            
            
          
  
            
            
            
            
            
            
   
    public List formatInputToarray(String order) {
        List items = new ArrayList();
        this.order = order;
        
        
        
        
        orderItems = order.split(",");
        
        
        items =  Arrays.asList(orderItems);
        //get rid of new line character
        for(int i = 0; i < items.size(); i++){
            

                    if(items.get(i) == null){
                        items.remove(i);

                    }
            
        }
   return items;
    }
    
}
