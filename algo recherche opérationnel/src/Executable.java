/**
 * A class to perform your own tests
 */
 
import java.io.FileInputStream;
import java.io.InputStream;

public class Executable {
    
    public static void main(String[] args) {
        //I can test my class here: create instances and call the method(s), check the results
        try {
            
            InputStream input = new FileInputStream("test.txt");
            GrapheOriente g = GrapheOriente.read(input);
            System.out.print(g.fordFulkerson(0,3)) ;
            
            
        } catch (Exception e) {
            System.err.printf("Erreur de lecture du fichier : %1$s\n", e.getLocalizedMessage());
        }
    }
}