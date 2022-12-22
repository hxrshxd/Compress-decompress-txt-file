/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CodeFiles;

import java.io.*;
import java.util.zip.GZIPOutputStream;
/**
 *
 * @author Harshad Rathod
 */
public class Compress {
    public static void compressFunction(File file) throws FileNotFoundException, IOException {
        // store directory path of the file
        // getParent() is used to get the path of directory where the file is saved
        String fileDirectory = file.getParent();         
        
        // line 26 - 33 are used to create objects which we will use for --
        // to read content of the file
        FileInputStream fis = new FileInputStream(file);
        
        // get output OR store the content of the compressed file
        FileOutputStream fos = new FileOutputStream(fileDirectory + "\\CompressedFile.gz");
        
        // used to convert txt to gz (compress the content of the file)
        GZIPOutputStream gzipOS = new GZIPOutputStream(fos);
        
        
        byte[] buffer = new byte[1024]; // declare byte array
        int len;
        
        // we are reading from 'fis' which is our file to be compressed
        // then we are storing the content in byte array
        // it is reading the content in len of bytes array
        while ((len = fis.read(buffer)) != -1) {
            gzipOS.write(buffer, 0, len); // writing the compressed version
        }
        
        // done reading, storing the content and no more content we will read again
        // so we close all the objects
        gzipOS.close();
        fos.close();
        fis.close();
    } 
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // path of file to be compressed
        File path = new File("C:\\Users\\Harshad Rathod\\Documents\\NetBeansProjects\\CompresserDecompresserJavaProject\\src\\sampleFile.txt");
        
        compressFunction(path);
    }
}
