package ires.corso.test;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class LibraryManager {

    //aggiunta nuovo libro
    public static void createNewBook() throws IOException {
        Scanner in = new Scanner(System.in);

        //SI CHIEDE TITOLO
        System.out.println("Aggiungi il titolo del libro:");
        String title = in.nextLine();

        //SI CHIEDE AUTORE
        System.out.println("Aggiungi autore del libro:");
        String author = in.nextLine();

        //SI CHIEDE DESCRIZIONE
        System.out.println("Aggiungi descrizione:");
        String description = in.nextLine();

        //SI CHIEDE ISBN
        System.out.println("Aggiungi il codice ISBN");
        String isbnCode = in.nextLine();

        //SI CHIEDE DATA DI PUBBLICAZIONE
        System.out.println("Inserisci la data di pubblicazione nel formato yyyy/mm/dd:");
        String publicationDate = in.nextLine();
        DateTimeFormatter form = DateTimeFormatter.ofPattern("yyyy/MM/d");
        LocalDate pubD = LocalDate.parse(publicationDate, form);

        //SI CHIEDE GENERE
        Libro.Generi gen = chooseGenere();


        Libro l = new Libro(title ,author, description, isbnCode, pubD, gen);
        Biblioteca repo = Biblioteca.getToDoRepository();
        repo.addBook(l);
        System.out.println("Il libro con id " + l.getId().toString() + ", titolo " + l.getTitolo() + ", autore " + l.getAutore() + ", descrizione "+ l.getDescrizione() + ", codice ISBN " + l.getIsbnCode().toString() + ", data di pubblicazione " + l.getDataPubblicazione().toString() + " e genere " + l.getGenere().toString() + " è stato aggiunto alla tua biblioteca!");
    }

    public static Libro.Generi chooseGenere(){ //metodo scelta del libro

        Scanner in = new Scanner(System.in);
        Libro.Generi gen = null;
        System.out.println("Inserisci il genere del libro!");
        String user_answer = in.nextLine();
        if(user_answer.equalsIgnoreCase("horror"))
            gen = Libro.Generi.HORROR;
        else if(user_answer.equalsIgnoreCase("classico"))
            gen = Libro.Generi.CLASSICO;
        else if(user_answer.equalsIgnoreCase("drammatico"))
            gen = Libro.Generi.DRAMMATICO;
        else if(user_answer.equalsIgnoreCase("fantasy"))
            gen = Libro.Generi.FANTASY;
        else if(user_answer.equalsIgnoreCase("romanzo"))
            gen = Libro.Generi.ROMANZO;
        return gen;
    }
    //------------------------------------------------------------------------------------------------------------------

    //ELIMINAZIONE LIBRO
    public static void deleteBook() throws IOException {
        Biblioteca repo = Biblioteca.getToDoRepository();
        Scanner in = new Scanner(System.in);
        System.out.println("Seleziona ID del libro che desideri rimuovere:");
        Long user_inputId = in.nextLong();
        if (repo._data.containsKey(user_inputId)) {
            repo.deleteBook(user_inputId);
            System.out.println("Il libro con id " + user_inputId + " è stato rimosso");
        }
        else {
            System.out.println("Sembra che questo id non esista...");
        }
    }
    //-----------------------------------------------------------------------------------------------------------------
    //MODIFICA VOLUME
    public static void updateBook() throws IOException {
        Biblioteca repo = Biblioteca.getToDoRepository();
        Scanner in = new Scanner(System.in);

        System.out.println("Inserisci id del libro che desideri cambiare:");
        Long user_inputID = in.nextLong();
        if (!repo._data.containsKey(user_inputID)) {
            System.out.println("ERRORE: ID non presente"); //stampa del TO-DO scelto se esiste, altrimenti di un messaggio di errore
        }

        Libro oldBook = repo._data.get(user_inputID);//recupera il to-do  che si vuole modificare
        System.out.println(oldBook.printBook());

        //loop di richiesta di quali dati cambiare
        Libro l = null;
        try{
            l = oldBook.cloneForUpdate(); // Si chiede un "clone" del TO-DO
        }
        catch (CloneNotSupportedException cnse){
            System.out.println("Error with clonation");
        }

        String input;
        String user_answer;

        System.out.println("\nVuoi cambiare il titolo?");
        if((user_answer = in.nextLine()).equalsIgnoreCase("si")){
            System.out.println("Inserisci nuovo titolo:");
            input = in.nextLine();
            l.setTitolo(input);
        }

        System.out.println("Vuoi cambiare autore?");
        if((user_answer = in.nextLine()).equalsIgnoreCase("si")){
            System.out.println("Inserisci nuovo autore:");
            input = in.nextLine();
            l.setAutore(input);
        }

        System.out.println("Vuoi cambiare descrizione?");
        if((user_answer = in.nextLine()).equalsIgnoreCase("si")){
            System.out.println("Inserisci nuova descrizione:");
            input = in.nextLine();
            l.setAutore(input);
        }

        System.out.println("Vuoi cambiare codice ISBN?");
        if((user_answer = in.nextLine()).equalsIgnoreCase("si")){
            System.out.println("Inserisci nuovo codice ISBN:");
            input = in.nextLine();
            l.setIsbnCode(input);
        }

        System.out.println("Vuoi cambiare la data di pubblicazione?");
        if((user_answer = in.nextLine()).equalsIgnoreCase("si")){
            System.out.println("Inserisci la data di pubblicazione aggiornata:");
            LocalDate pubDate = LocalDate.parse(in.nextLine());
            l.setDataPubblicazione(pubDate);
        }
        System.out.println("Vuoi cambiare il genere del Libro?");
        if((user_answer = in.nextLine()).equalsIgnoreCase("si")){
            System.out.println("Inserisci genere:");
            l.setGenere(chooseGenere());
        }

        //chiedo ultima conferma prima di cambiare
        System.out.printf("Stai sostituendo il seguente libro \n%s \n", oldBook.printBook());
        System.out.printf("con il seguente libro \n%s\n", l.printBook());
        System.out.println("Scrivi \" si \" per continuare, altrimenti un qualunque altro tasto per annullare:");
        if((user_answer = in.nextLine()).equalsIgnoreCase("si")){
            repo.updateBook(l); // Salvataggio delle modifiche tramite ToDoRepository (update...)
            System.out.println("Libro modificato");
        }
        else System.out.println("modifica libro annullata");
        System.out.println();
    }

    //-----------------------------------
    //AVANZAMENTO LETTURA
    //1public static void ()
}

