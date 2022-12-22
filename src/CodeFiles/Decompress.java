/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CodeFiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;

/**
 *
 * @author Harshad Rathod
 */
public class Decompress {
    
    public static void decompressFunction(File file) throws FileNotFoundException, IOException {
        // directory path of file to be decompressed
        String fileDirectory = file.getParent();
        
        FileInputStream fis = new FileInputStream(file);
        GZIPInputStream gzipIS = new GZIPInputStream(fis); // to read compressed file
        FileOutputStream fos = new FileOutputStream(fileDirectory + "\\decompressedFile.txt"); // storing the decompressed file in the directory
        
        byte[] buffer = new byte[1024];
        int len;
        
        while ((len = gzipIS.read(buffer)) != -1) {
            fos.write(buffer, 0, len);
        }
        
        gzipIS.close();
        fis.close();
        fos.close();
    }
    
    public static void main(String[] args) throws IOException {
        // path of file to be decompressed
        File path = new File("C:\\Users\\Harshad Rathod\\Documents\\NetBeansProjects\\CompresserDecompresserJavaProject\\src\\CompressedFile.gz");
        
        decompressFunction(path);
    }

}
