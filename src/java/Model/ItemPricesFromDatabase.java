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

/**
 *
 * @author chris
 */
public class ItemPricesFromDatabase implements ItemPricingAccessStrategy{
            private HashMap<String, String> mapOrder;
            private List <HashMap<String,String>> list = new ArrayList();
           private DecimalFormat formatter = new DecimalFormat("#0.00");
            private double price = 0;
            private double cost = 0;
            private double tax = 0.05;
            private double tip_percent = .15;

    public void setTip_percent(double tip_percent) {
        this.tip_percent = tip_percent;
    }
            
            
            
            

    @Override
    public List<HashMap<String, String>> getItemPrices(String[] items) {
        
           /*
         Would access a database here for prices
         * but using a switch statement instead
         
         */
        for(String item : items){
            
            
            mapOrder = new HashMap();
            
            list.add(mapOrder);
            switch(item)
            {
                case "Chicken":
                    cost = 5.00;
                    price += cost;
                    mapOrder.put(item, formatter.format(cost));
                    break;
                    
                case "Beef":
                    cost = 19.00;
                    price += cost;
                    mapOrder.put(item, formatter.format(cost));
                    break;
                     
                case "Salad":
                    cost = 6.00;
                    price += cost;
                    mapOrder.put(item, formatter.format(cost));
                    break;
                    
                case "Wine":
                    cost = 4.00;
                    price += cost;
                    mapOrder.put(item, formatter.format(cost));
                    break;
                    
               case "Beer":
                    cost = 3.00;
                    price += cost;
                    mapOrder.put(item, formatter.format(cost));
                    break;
                   
               case "Prime Rib":
                    cost = 20.00;
                    price += cost;
                    mapOrder.put(item, formatter.format(cost));
                    break;
                   
               case "Soda":
                    cost = 2.00;
                    price += cost;
                    mapOrder.put(item, formatter.format(cost));
                    break;
            }
        }
        
        mapOrder = new HashMap();
     
        
        
       mapOrder.put("Total", formatter.format(price));
        
       list.add(mapOrder);
       
       mapOrder = new HashMap();
       
       
       
       
        //add tax
        tax = price * tax;
        mapOrder.put("Tax", formatter.format(tax));
        
        list.add(mapOrder);
        
        
        
        
        
        mapOrder = new HashMap();
        
        price = price + tax;
        
        mapOrder.put("Total with tax", formatter.format(price));
        
       list.add(mapOrder);
       
       
       
       
        
        mapOrder = new HashMap();
        
      double tip = price * tip_percent;
        
        mapOrder.put("Tip", formatter.format(tip));
        
       list.add(mapOrder);
        
        return list;
    }
    


  
}
