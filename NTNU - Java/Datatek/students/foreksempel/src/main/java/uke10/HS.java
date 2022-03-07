package uke10;

import java.util.HashMap;
import java.util.Map;

public class HS {
    
    public static void main(String[] args)
    {
        Map<String, String> hashSet
            = new HashMap<String, String>();
 
        hashSet.put("D", "Dora");
        hashSet.put("R", "Rappo");
        hashSet.put("T", "Trollet");

 
        // Lag en Map.Entry av hvert element: (som dictionary.items() i Python, men en må spesifisere typene en skal få ut)
        for (Map.Entry<String, String> set : hashSet.entrySet()) {
 
            System.out.println(set.getKey() + " = "
                               + set.getValue());
        }

        // Alternativt: (Som dictionary.keys() i Python, men en må spesifisere type en får )
        for (String key : hashSet.keySet()) {
            System.out.println(key + ": "+hashSet.get(key));
        }
    }}
