/***
* Name: GrapheOriente
* Author: eric Papain
* Description: 
* Tags: Tag1, Tag2, TagN
***/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


/**
 * Modélise un graphe orienté avec capacités et flots sur les arcs
 *
 */
public class GrapheOriente {

    private final List<LinkedList<Arc>> adjacence; // L'élément à l'index i est la liste des arcs sortants du sommet i

    /**
     * Initialise l'instance de graphe avec {@code n} sommets
     *
     * @param n le nombre de sommets du graphe. {@code n} doit être strictement positif.
     * @throws IllegalArgumentException si {@code n} est négatif ou nul
     */
    public GrapheOriente(int n) {
        if (n < 1)
            throw new IllegalArgumentException("le nombre de sommets doit etre strictement positif");
        this.adjacence = new ArrayList<>(n);
        for (int i = 0; i < n; i++)
            adjacence.add(new LinkedList<Arc>());
    }

    /**
     * Construit un graphe à partir d'un flux de données (InputStream)
     *
     * @param input données du graphe à construire
     * @return un graphe orienté pondéré
     * @throws GrapheReaderException en cas d'erreur de lecture de {@code input}
     */
    public static GrapheOriente read(final InputStream input) throws GrapheReaderException {
        return new Reader().read(input);
    }

    /**
     * renvoie le nombre de sommets du graphe
     *
     * @return le nombre de sommets (toujours positif)
     */
    public int getN() {
        return this.adjacence.size();
    }

    /**
     * Ajoute l'arc {@code i}{@code j} au graphe avec la capacité {@code capacite} et le flot {@code flot}.
     * On peut rajouter un arc déjà existant ou faire des boucles !
     *
     * @param i     sommet initial de l'arc
     * @param j     sommet terminal de l'arc
     * @param capacite  capacité de l'arc
     * @param flot  flot sur l'arc
     */
    public void ajouterArc(int i, int j, int capacite, int flot) {
        verifieSommet(i);
        verifieSommet(j);
        this.adjacence.get(i).add(new Arc(i, j, capacite, flot));
    }

    /**
     * Renvoie la liste des arcsSortants du sommet {@code v}
     * Cette liste ne peut pas etre modifiée
     *
     * @param v sommet du graphe
     * @return la liste des arcs sortants du sommet {@code v}
     */
    public List<Arc> arcsSortants(int v) {
        verifieSommet(v);

        return Collections.unmodifiableList(adjacence.get(v));
    }

    public List<Arc> arcsEntrants(int v) {
        verifieSommet(v);
        List<Arc> entrants = new LinkedList<>();

        for (int i = 0; i < getN(); i++) {
            for(Arc a : adjacence.get(i)){
                if (a.getA()==v) entrants.add(a);
            }
        }
        return Collections.unmodifiableList(entrants);
    }


    /**
     * vérifie que le sommet {@code v} est un sommet valide du graphe
     *
     * @param v sommet du graphe à verifier
     * @throws IllegalArgumentException si le sommet n'est pas valide
     */
    private void verifieSommet(int v) {
        if (v >= getN() || v < 0)
            throw new IllegalArgumentException(String.format("Le sommet %d n'est pas valide", v));
    }

    /**
     * Calcule la valeur du flot
     * @param s
     * @return la valeur du flot en {@code s} : la somme des flots sortants moins la somme des flots entrants
     */
    public int valeurFlot(int s){
        // TODO
        return -1 ;
    }

    /**
     * Vérifie la conservation du flot
     *
     * @param s source du flot
     * @param t puit du flot
     * @return true ssi le flot est conservé pour l'ensemble des sommets sauf {@code s} et {@code t}
     */
    public boolean verifierConservationFlot(int s   , int t){
        // TODO
         return false ;
    }



    /**
     * Fait un parcours du graphe à partir de la racine.
     * construit un tableau contenant un arc depuis le père de chaque sommet dans l'arborescence
     *
     * @param racine sommet de démarrage du parcours
     * @return un tableau contenant l'arc qui a permis d'arriver au sommet (depuis le père).
     *              Si le sommet est non atteignable, la valeur correspondante est null
     * @throws IllegalArgumentException si le sommet n'est pas valide
     */
    public Arc[] atteignable(int racine){
        // TODO
        return null ;
      }
    

    /**
     * calcule la somme des capacités des arcs sortants de la coupe définie par le paramètre {@code coupe}
     *
     * @param coupe est un tableau qui indique si le sommet est dans la coupe (valeur true) ou non (valeur false)
     *
     * @return la somme des capacités des arcs sortants de la coupe
     */
    public int valeurCoupe(boolean[] coupe){
        // TODO
         return -1 ;
    }

    /**
     * Construit le graphe auxiliaire avec les capacités résiduelles.
     * je vous recommande d'utiliser la valeur du flot pour savoir si l'arc est un arc avant (dans le même sens que dans le graphe initial)
     * ou un arc arrière (sens inverse par rapport au graphe initial)
     *
     * @return le graphe auxiliaire avec les capacités résiduelles
     */
    public GrapheOriente construireGrapheResiduel(){
        // TODO
         return null ;
     }




    /**
    * Exécute Ford et Fulkerson avec le graphe résiduel
    * @param s : source du graphe
    * @param t : puit du graphe
    * @return la valeur du flot max
    */
    public int fordFulkerson(int s, int t){
        // TODO
         return -1 ;
    }
    


    private  static final class Reader {

        public GrapheOriente read(final InputStream input) throws GrapheReaderException {
            try {
                final BufferedReader reader = new BufferedReader(new InputStreamReader(input)); {

                    final GrapheOriente g;
                    String line;

                    String[] items = readNextLine(reader);

                    if ((items == null) || (items.length < 2) || !"p".equals(items[0]))
                        throw new GrapheReaderException("il manque la ligne p",null);

                    g = new GrapheOriente(toInt(items[2]));


                    while (items != null) {
                        items = readNextLine(reader);
                        if ((items != null) && (items.length > 0) && "e".equals(items[0])) {
                            g.ajouterArc(toInt(items[1]), toInt(items[2]), toInt(items[3]), toInt(items[4]));
                        }
                    }
                    return g;
                }
            } catch (IOException e) {
                throw new GrapheReaderException(e.getMessage(),e);
            }
        }

        private String[] readNextLine(BufferedReader reader) throws IOException {
            String line = reader.readLine();
            while ((line != null) && line.startsWith("c")) {
                line = reader.readLine();
            }
            return (line == null) ? null : line.split("\\s+");
        }


        private static int toInt(String s) throws GrapheReaderException {
            try {
                return Integer.parseInt(s);
            } catch (NumberFormatException e) {
                throw new GrapheReaderException(String.format("'%1$s' n'est pas un entier", s),e) ;
            }
        }
    }

    public static class GrapheReaderException extends Exception {
        public GrapheReaderException(String message, Throwable cause) {
            super(message, cause);
        }
    }
}