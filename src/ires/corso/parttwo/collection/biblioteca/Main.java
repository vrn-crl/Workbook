package ires.corso.parttwo.collection.biblioteca;

import java.util.*;
import java.lang.*;
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

        //sto aggiungendo una categoria specifica all'arrayList CategorieLibri dell istanza l1, l2, l6
        l1.aggiungiCategoria(fantasy);
        l2.aggiungiCategoria(drammatico);
        l2.aggiungiCategoria(classico);
        l6.aggiungiCategoria(attualita); //aggiunge la categoria del libro nell ArrayList "categorieLibri" e il libro e la categoria nell'hashMap "relazLibroCat"

        //--------ELENCO LIBRI con categoria assegnata(NON TUTTI)
        List<Libro> elencoLibri= new ArrayList<>();
        elencoLibri.add(l1);
        elencoLibri.add(l2);
        elencoLibri.add(l6);
//-------STAMPA LIBRO E GENERE/I ASSOCIATO/I

        for (Libro l : elencoLibri) {
            List<String> elencoGeneriPerLibro = new ArrayList<>();
            for (Categoria c : l.categorieLibri) {
                elencoGeneriPerLibro.add(c.getTitolo());
            }
            System.out.println(l.getTitolo() + " è associato al/ai seguente/i genere/i: " + elencoGeneriPerLibro.toString());

        }

        //lista libri in prestito Veronica
        ArrayList <Libro> libriU1 = new ArrayList<>();
        libriU1.add(l1);
        libriU1.add(l2);
        libriU1.add(l3);
        //lista libri in prestito di Davide
        ArrayList <Libro> libriU2 = new ArrayList<>();
        libriU2.add(l4);
        libriU2.add(l5);



        //
        //CREIAMO DUE UTENTI
        Utente u1 = new Utente("Veronica","Cirillo",353);
        Utente u2 = new Utente("Davide", "Revignas", 543);


        //Prestito prestitoU1 = new Prestito(libriU1); //l'utente Veronica Ha preso 3 libri in prestito
        Prestito prestitoU2 = new Prestito(libriU2); //

        //System.out.println(prestitoU1.ottieniLibriPrestati().size());
        System.out.println(prestitoU2.ottieniLibriPrestati().size());

        u1.aggiungiPrestito(new Prestito(libriU1));
        u2.aggiungiPrestito(prestitoU2);

        for(Prestito p: Utente.getLoanById(353)) {
            for(Libro l: p.listaLibriPrestati) {
                System.out.println("Libri presi in prestito: " + l.getTitolo());
            }
        }
    }
}

