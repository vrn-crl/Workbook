package ires.corso.parttwo.collection.biblioteca;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Main {
    //    Create almeno 8 libri diversi e 5 categorie diverse.
    //    Almeno 4 libri devono essere associati a più di una categoria.
    //    Rappresentate opportunamente l'associazione tra libri e categorie in una struttura (basata sulle Java
    //    collections) che permetta di ricavare agevolmente a quali categorie appartiene un libro.
    //
    //    Create poi almeno 3 utenti diversi.
    //    Per ciascun utente create almeno 2 prestiti, con 2 o + volumi appartenenti a categorie distinte.
    //    Rappresentate opportunamente l'associazione tra utenti e prestiti tramite una struttura (basata sulle
    //    Java collections) che permetta di ricavare agevolmente quali prestiti ha eseguito un utente.
    //
    //    Incrociate i dati delle due strutture per costruire una terza struttura (basata.....) che dica
    //    quanti e quali prestiti sono stati eseguiti per ciascuna categoria (vogliamo cioè fare un'analisi
    //    statistica di quali siano le categorie più gradite).
    //
    //    Tutte le classi possono essere pensate come semplici strutture dati: quindi campi private e final,
    //    valori dei campi da passare nel costruttore, solo metodi "getter" per recupare i valori.

    //Creazione 8 libri e 5 categorie
    public static void main(String[] args) {
        Libro l1 = new Libro("Il Signore degli Anelli", "J.R.R Tolkien", "1920", 1000, 3, 100);
        Libro l2 = new Libro("Madame Bouvary","Flaubert", "1920", 1000, 3, 100);
        Libro l3  = new Libro("Null pointer exeption ","Veronica Cirillo", "1800", 1000, 3, 100);
        Libro l4 = new Libro("Il maestro e margherita","Bergheiev", "1920", 1000, 3, 100);
        Libro l5 = new Libro("Marcovaldo","Italo Calvino", "1920", 1000, 3, 100);
        Libro l6= new Libro("Per mano nel buio","Barbara Demik", "1920", 1000, 3, 100);
        Libro l7 = new Libro("Java Programming for Dummies","Marcello Mauro", "1920", 1000, 3, 100);
        Libro l8  = new Libro("Anna Karenina","Tolstoj", "1920", 1000, 3, 100);

        Categoria fantasy = new Categoria("Fantasy", "...");
        Categoria drammatico = new Categoria("Drammatico", "...");
        Categoria classico = new Categoria("Classico", "...");
        Categoria informatica = new Categoria("Informatica", "...");
        Categoria attualità = new Categoria("Attualità", "...");
        Categoria giallo = new Categoria("Giallo", "...");
        Categoria horror = new Categoria("Horror", "...");

        //Il signore degli anelli --> Fantasy l1
        //Madame Bouvary--> Classico, Drammatico l2
        //Null pointer exeption --> Horror, Informatica l3
        //Il maestro e margherita --> Classico l4
        //Marcovaldo --> Classico l5
        // Per Mano nel buio --> Attualità, Drammatico l6
        //Java Programming for Dummies --> Informatica l7
        //Anna Karenina --> Classico, Drammatico l8

        //--------------------------------------------------------------------------------------------------------------

        /*Almeno 4 libri devono essere associati a più di una categoria.
            Rappresentate opportunamente l'associazione tra libri e categorie in una struttura (basata sulle Java
            collections) che permetta di ricavare agevolmente a quali categorie appartiene un libro.*/

        ArrayList<String> libriDrammatici = new ArrayList<>();
        libriDrammatici.add(l2.getTitolo());
        libriDrammatici.add(l6.getTitolo());
        libriDrammatici.add(l8.getTitolo());

        ArrayList<String> libriClassici = new ArrayList<>();
        libriClassici.add(l2.getTitolo());
        libriClassici.add(l4.getTitolo());
        libriClassici.add(l5.getTitolo());
        libriClassici.add(l8.getTitolo());

        ArrayList<String> libriFantasy = new ArrayList<>();
        libriFantasy.add(l1.getTitolo());

        ArrayList<String> libriAttualità = new ArrayList<>();
        libriAttualità.add(l6.getTitolo());

        ArrayList<String> libriInformatica = new ArrayList<>();
        libriInformatica.add(l3.getTitolo());
        libriInformatica.add(l7.getTitolo());

        ArrayList<String> libriHorror = new ArrayList<>();
        libriHorror.add(l3.getTitolo());

        Map <Categoria, ArrayList> libroCategoria = new HashMap<>();
        libroCategoria.put(fantasy, libriFantasy);
        libroCategoria.put(horror,libriHorror);
        libroCategoria.put(informatica, libriInformatica);
        libroCategoria.put(classico, libriClassici);
        libroCategoria.put(drammatico, libriDrammatici);
        libroCategoria.put(attualità, libriAttualità);

        Iterator<Map.Entry<Categoria, ArrayList>> itr = libroCategoria.entrySet().iterator();
        System.out.println(libriAttualità.toString());
        while(itr.hasNext())
        {
            Map.Entry<Categoria, ArrayList> entry = itr.next();
            System.out.println("Genere = " + entry.getKey().getTitolo() +
                    ", Libri = " + entry.getValue());
        }
    }
}

