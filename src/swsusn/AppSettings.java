/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swsusn;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;

public class AppSettings {
   private AppSettings() {
      fHashMap = new HashMap();
   }
   // . .  
   private HashMap fHashMap;
   
        Properties props = new Properties ();

        File f = new File ("lacc.prop");
                    
                //InputStream is = new BufferedInputStream (new FileInputStream (f));
                //props.load (is);
                //is.close ();
        
//}
                
//        if (f.exists()==true)  {
//            
       // }
   
   private static AppSettings SINGLETON;
   static {
      SINGLETON = new AppSettings();
   }
   
   // Извлечение объекта из коллекции
// при отсутствии данных возвращается значение по умолчанию
public static String getString(String key, String deflt) {
   String str = SINGLETON.fHashMap.get(key).toString();
   if (str == null) {
      return deflt;
   } else {
      return str;
   }
}

// Для упрощения извлечения данных типа int
public static int getInt(String key, int deflt) {
   String str = SINGLETON.fHashMap.get(key).toString();
   if (str == null) {
      return deflt;
   } else {
      return new Integer(str).intValue();
   }
}

// Добавление объекта в коллекцию
public static void set(String key, Object data) {
   // prevent null values. Hasmap allow them
   if (data == null) {
      throw new IllegalArgumentException();
   } else {
      SINGLETON.fHashMap.put(key, data);
   }
 }
}