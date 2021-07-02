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

    //-------------8 LIBRI---------------------------------------
    public static void main(String[] args) {
        Libro l1 = new Libro("Il Signore degli Anelli", "J.R.R Tolkien", "1920", 1000, 3, 100);
        Libro l2 = new Libro("Madame Bouvary","Flaubert", "1920", 1000, 3, 100);
        Libro l3  = new Libro("Null pointer exeption ","Veronica Cirillo", "1800", 1000, 3, 100);
        Libro l4 = new Libro("Il maestro e margherita","Bergheiev", "1920", 1000, 3, 100);
        Libro l5 = new Libro("Marcovaldo","Italo Calvino", "1920", 1000, 3, 100);
        Libro l6= new Libro("Per mano nel buio","Barbara Demik", "1920", 1000, 3, 100);
        Libro l7 = new Libro("Java Programming for Dummies","Marcello Mauro", "1920", 1000, 3, 100);
        Libro l8  = new Libro("Anna Karenina","Tolstoj", "1920", 1000, 3, 100);

    //--------------CATEGORIE-------------------------------------
        Categoria fantasy = new Categoria("Fantasy", "libri fantasy");
        Categoria drammatico = new Categoria("Drammatico", "...");
        Categoria classico = new Categoria("Classico", "...");
        Categoria informatica = new Categoria("Informatica", "...");
        Categoria attualita = new Categoria("Attualità", "...");
        Categoria giallo = new Categoria("Giallo", "...");
        Categoria horror = new Categoria("Horror", "...");

        //--------------------------------------------------------------------------------------------------------------

        /*Almeno 4 libri devono essere associati a più di una categoria.
            Rappresentate opportunamente l'associazione tra libri e categorie in una struttura (basata sulle Java
            collections) che permetta di ricavare agevolmente a quali categorie appartiene un libro.*/
        l1.aggiungiCategoria(fantasy);
        l2.aggiungiCategoria(drammatico);
        l2.aggiungiCategoria(classico);
        l6.aggiungiCategoria(attualita); //aggiunge la categoria del libro nell ArrayList "categorieLibri" e il libro e la categoria nell'hashMap "relazLibroCat"


        ArrayList<String> elencoGeneriPerLibro = new ArrayList<>();
        for(Categoria c: l2.categorieLibri) {
            elencoGeneriPerLibro.add(c.getTitolo());
        }
        System.out.println(l2.getTitolo() + elencoGeneriPerLibro.toString());
    }
}

