/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.HashMap;
import java.util.List;

/**
 *
 * @author chris
 */
public interface FormatOutputStrategy {
    
    public abstract StringBuilder getFormattedReceipt( List<HashMap<String,String>> list);
    
}
