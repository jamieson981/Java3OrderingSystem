
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author arad
 */
public class FileAccess {
    public static final String FILE_NAME = "transaction.txt";
    
    public static void addTransactionToFile(String line) throws IOException {
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(FILE_NAME, true)))) {
            out.println(line);                
        }
    }
    
}
