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
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AppSettings {
   private AppSettings() throws FileNotFoundException, IOException {
          
       Properties props = new Properties();
       props.load(new FileInputStream(new File("settings.ini")));
      
   }
   // . .  
   private Properties props;

   private static AppSettings SINGLETON;
   static {
       try {
           SINGLETON = new AppSettings();
       } catch (IOException ex) {
           Logger.getLogger(AppSettings.class.getName()).log(Level.SEVERE, null, ex);
       }
   }
   
   // Извлечение объекта из коллекции
// при отсутствии данных возвращается значение по умолчанию
public static String getString(String key, String deflt) {
   String str = SINGLETON.props.getProperty(key);
   if (str == null) {
      return deflt;
   } else {
      return str;
   }
}

// Для упрощения извлечения данных типа int
public static int getInt(String key, int deflt) {
   String str = SINGLETON.props.getProperty(key);
   if (str == null) {
      return deflt;
   } else {
      return new Integer(str).intValue();
   }
}

// Добавление объекта в коллекцию
public static void set(String key, String data) {
   // prevent null values. Hasmap allow them
   if (data == null) {
      throw new IllegalArgumentException();
   } else {
      SINGLETON.props.setProperty(key, data);
   }
 }
}