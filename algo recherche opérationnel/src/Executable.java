/***
* Name: ford-fulkerson
* Author: eric Papain
* Description: 
* Tags: Tag1, Tag2, TagN
***/

 
import java.io.FileInputStream;
import java.io.InputStream;

public class Executable {
    
    public static void main(String[] args) {
        //je peux maintenant essayer d'exécuter mon code sur un fichier exemple
        try {
            
            InputStream input = new FileInputStream("test.txt");
            GrapheOriente g = GrapheOriente.read(input);
            System.out.print(g.fordFulkerson(0,3)) ;
            
            
        } catch (Exception e) {
            System.err.printf("Erreur de lecture du fichier : %1$s\n", e.getLocalizedMessage());
        }
    }
}