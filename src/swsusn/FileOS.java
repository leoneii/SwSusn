/*
 * Copyright (C) 2020 leone
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package swsusn;


import java.awt.Component;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author leone
 */
public class FileOS {
    
    private static  JFileChooser fileChooser = new JFileChooser();
    
    
    public static String getFile (String title, String filter, String filtername, Component parent ) throws IOException  {
 
        
        FileNameExtensionFilter fefilter= new FileNameExtensionFilter(filtername,filter);                                         
        fileChooser.setDialogTitle(title);
        fileChooser.setFileFilter(fefilter);
        // Определение режима - 
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int result = fileChooser.showOpenDialog(parent);
        // Если директория выбрана, покажем ее в сообщении
        if (result == JFileChooser.APPROVE_OPTION ){
            
              return fileChooser.getSelectedFile().toString();  
        }
              return null;  
        
    }

    
        public static String getFolder (String title, Component parent ) throws IOException  {
 
        
//        FileNameExtensionFilter fefilter= new FileNameExtensionFilter(filtername,filter);                                         
//        fileChooser.setDialogTitle(title);
//        fileChooser.setFileFilter(fefilter);
        // Определение режима - 
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int result = fileChooser.showOpenDialog(parent);
        // Если директория выбрана, покажем ее в сообщении
        if (result == JFileChooser.APPROVE_OPTION ){
            
              return fileChooser.getSelectedFile().toString();  
        }
              return null;  
        
    }

    
            public static String saveFile (String title, String filter, String filtername, Component parent ) throws IOException  {
 
        
        FileNameExtensionFilter fefilter= new FileNameExtensionFilter(filtername,filter);                                         
        fileChooser.setDialogTitle(title);
        fileChooser.setFileFilter(fefilter);
        // Определение режима - 
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
  
        int result = fileChooser.showSaveDialog(parent);
        // Если директория выбрана, покажем ее в сообщении
        if (result == JFileChooser.APPROVE_OPTION ){
            
              return fileChooser.getSelectedFile().toString();  
        }
              return null;  
        
    }
        
}
