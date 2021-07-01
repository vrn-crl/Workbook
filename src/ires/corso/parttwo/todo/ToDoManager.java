package ires.corso.parttwo.todo;

import javax.swing.text.DateFormatter;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

// GRUPPO 2:
public class ToDoManager
{
    Scanner in = new Scanner(System.in);
    // Classe responsabile per le operazioni sull'insieme dei TO-DO:
    // - metodi per creazione nuovo TO-DO
    // - metodi per la modifica, la rimozione
    // - gestisce input utente (cioè loop di richiesta di quali campi devono essere modificati)
    // - ha al suo interno funzioni di controllo sull'input utente

   public void createNewToDo() {
       System.out.println("Aggiungi titolo:");
        String title = in.nextLine();
       System.out.println("Aggiungi descriione:");
        String description = in.nextLine();
       LocalDate insDate = LocalDate.now();
       System.out.println("Inserisci la data di consegna nel formato yyyy-mm-dd");
        String delivDate = in.nextLine();
       DateTimeFormatter form = DateTimeFormatter.ofPattern("yyyy/MM/d");
       LocalDate delivD = LocalDate.parse(delivDate, form);
        ToDo t = new ToDo(title, description, insDate, delivD);
   }

    //public void updateToDo() {
        // Chiede quale Id si vuole modificare
        // Si chiede un "clone" del TO-DO
        // Loop di richiesta dati da modificare
        // Salvataggio delle modifiche tramite ToDoRepository (update...)
   // }
    //Load from file()

    public static void main(String[] args) {
        ToDo tD1 = new ToDo("Compiti", "Compiti da fare", LocalDate.of(2021,6,29), LocalDate.of(2022, 6, 29));
        System.out.println("Id di td1 è " + tD1.getId().toString());
        ToDo tDcloned = tD1.cloneForUpdate();
        System.out.println("Id di tDcloned è " + tDcloned.getId());








    }
}