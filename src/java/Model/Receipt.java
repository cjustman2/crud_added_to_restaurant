/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.text.DecimalFormat;
import java.util.List;

/**
 *
 * @author chris
 */
public class Receipt {
    DecimalFormat formatter= new DecimalFormat("#0.00");
    private List<MenuItem> items;
    private double total = 0;
    private double tip = .15;

    public List<MenuItem> getItems() {
        return items;
    }

    public void setItems(List<MenuItem> items) {
        this.items = items;
    }

   
    
        public String getTotal() {
         String totl = formatter.format(total);
        return totl;
    }

    public void setTotal(double total) {
        this.total += total;
    }

    public String getTip() {
        tip = tip * total;
        String t = formatter.format(tip);
        return t;
    }

    public void setTip(double tip) {
        this.tip = tip;
    }
    
}
