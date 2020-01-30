/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swsusn;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;


public class AppSettings {
   
          
    public static Properties props = new Properties();
      
   private static void load () throws FileNotFoundException, IOException {
      props.load(new FileInputStream(new File("settings.ini"))); 
   }   
   // . .  
   private static void store () throws IOException {
     props.store(new FileWriter("settings.ini"), "store to properties file");
   }

   
   // Извлечение объекта из коллекции
// при отсутствии данных возвращается значение по умолчанию
public static String getString(String key, String deflt) throws IOException  {
   load ();
   String str = props.getProperty(key);
   if (str == null) {
      return deflt;
   } else {
      return str;
   }
}

// Для упрощения извлечения данных типа int
public static int getInt(String key, int deflt) throws IOException {
    
   load ();
   String str = props.getProperty(key);
   if (str == null) {
      return deflt;
   } else {
      return new Integer(str).intValue();
   }
}

// Добавление объекта в коллекцию
public static void set(String key, String data) throws IOException  {
   // prevent null values. Hasmap allow them
   if (data == null) {
      throw new IllegalArgumentException();
   } else {
     props.setProperty(key, data);
     store();
   }
 }
}