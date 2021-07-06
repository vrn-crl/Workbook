package ires.corso.parttwo.todo;

import javax.swing.text.DateFormatter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

// GRUPPO 2:
public class ToDoManager
{

    // Classe responsabile per le operazioni sull'insieme dei TO-DO:
    // - metodi per creazione nuovo TO-DO
    // - metodi per la modifica, la rimozione
    // - gestisce input utente (cioè loop di richiesta di quali campi devono essere modificati)
    // - ha al suo interno funzioni di controllo sull'input utente

   public static void createNewToDo() throws IOException {

       Scanner in = new Scanner(System.in);
       System.out.println("Aggiungi il titolo del toDo:");
        String title = in.nextLine();
       System.out.println("Aggiungi descrizione:");
        String description = in.nextLine();
       LocalDate insDate = LocalDate.now();
       System.out.println("Inserisci la data di consegna nel formato yyyy/mm-dd");
        String delivDate = in.nextLine();
       DateTimeFormatter form = DateTimeFormatter.ofPattern("yyyy/MM/d");
       LocalDate delivD = LocalDate.parse(delivDate, form);
       ToDo.Priorities pr = choosePriority();
       ToDo.State st = chooseStatus();

        ToDo t = new ToDo(title, description, delivD, pr, st);
        ToDoRepository repo = ToDoRepository.getToDoRepository();
        repo.add(t);
        System.out.println("Il ToDo con id " + t.getId().toString() + ", con titolo " + t.getTitle() + ", descrizione " + t.getDescription() + ", con scadenza " + t.getDeliveryDate() + " e con priorità " + t.getPriority().toString() + " è stato aggiunto al repository");
   }

    public static ToDo.Priorities choosePriority(){
        System.out.println("Scegli una priorità per il To-Do tra: ALTA, MEDIA, BASSA");

        Scanner in = new Scanner (System.in);
        String priority = in.nextLine();
        ToDo.Priorities pr = null;
        if(priority.equalsIgnoreCase("alta")){
            pr = ToDo.Priorities.ALTA;
        }else if(priority.equalsIgnoreCase("media")){
            pr = ToDo.Priorities.MEDIA;
        }else if(priority.equalsIgnoreCase("BASSA")){
            pr = ToDo.Priorities.BASSA;
        }
        return pr;
    }

    public static ToDo.State chooseStatus(){
        System.out.println("Inserisci lo stato del ToDo fra: ANNULLATA, DA FARE, COMPLETATA e IN ESECUZIONE");
       Scanner in = new Scanner (System.in);
       String status = in.nextLine();
       ToDo.State st = null;
       if(status.equalsIgnoreCase("annullata")){
           st = ToDo.State.ANNULLATA;
       }
       else if (status.equalsIgnoreCase("da fare")){
           st = ToDo.State.DA_FARE;
       }
       else if (status.equalsIgnoreCase("completata")){
           st = ToDo.State.COMPLETATA;
       }
       else if (status.equalsIgnoreCase("in esecuzione")){
           st = ToDo.State.IN_ESECUZIONE;
       }
       return st;
    }

//----------------------------------------------------------------------------------------------------------------------

    public static void updateToDo() throws IOException {
        ToDoRepository repo = ToDoRepository.getToDoRepository();
        Scanner in = new Scanner(System.in);
        System.out.println("Inserisci id del ToDo che desideri cambiare:");
        Long user_inputID = in.nextLong();

        //stampa del TO-DO scelto se esiste, altrimenti di un messaggio di errore
        if (!repo._data.containsKey(user_inputID)) {
            System.out.println("ERRORE: ID non presente");
        }

        ToDo oldToDo = repo._data.get(user_inputID);//recupera il to-do  che si vuole modificare
        System.out.println(oldToDo.prettyPrint());

        //loop di richiesta di quali dati cambiare
        ToDo t = null;
        try{
            t = oldToDo.cloneForUpdate(); // Si chiede un "clone" del TO-DO
        }
        catch (CloneNotSupportedException cnse){
            System.out.println("error with clonation");
        }

        String input;
        String user_answer;

        System.out.println("\nVuoi cambiare il titolo?");
        if((user_answer = in.nextLine()).equalsIgnoreCase("si")){
            System.out.println("Inserisci nuovo titolo:");
            input = in.nextLine();
            t.setTitle(input);
        }

        System.out.println("Vuoi cambiare la descrizione?");
        if((user_answer = in.nextLine()).equalsIgnoreCase("si")){
            System.out.println("Inserisci nuova descrizione:");
            input = in.nextLine();
            t.setDescription(input);
        }

        System.out.println("Vuoi cambiare la data di scadenza?");
        if((user_answer = in.nextLine()).equalsIgnoreCase("si")){
            System.out.println("Inserisci nuova data di scadenza:");
            LocalDate inputDate = LocalDate.parse(in.nextLine());
            t.setDeliveryDate(inputDate);
        }
        System.out.println("Vuoi cambiare la priorità del to-do?");
        if((user_answer = in.nextLine()).equalsIgnoreCase("si")){
            System.out.println("Inserisci priorità:");
            t.setPriority(choosePriority());
        }
        System.out.println("Vuoi cambiare lo stato?");
        if((user_answer = in.nextLine()).equalsIgnoreCase("si")){
            t.setStatus(chooseStatus());
        }

        //chiedo ultima conferma prima di cambiare
        System.out.printf("Stai sostituendo il seguente TO-DO \n%s \n", oldToDo.prettyPrint());
        System.out.printf("con il seguente TO-DO \n%s\n", t.prettyPrint());
        System.out.println();
        if((user_answer = in.nextLine()).equalsIgnoreCase("si")){
            repo.update(t); // Salvataggio delle modifiche tramite ToDoRepository (update...)
            System.out.println("ToDo modificato");
        }
        else System.out.println("modifica ToDo annullata");
        System.out.println();
    }

        //Load from file()
    public static void deleteToDo() throws IOException {
        ToDoRepository repo = ToDoRepository.getToDoRepository();
        Scanner in = new Scanner(System.in);
        System.out.println("Seleziona ID del ToDo che desideri rimuovere:");
        Long user_inputId = in.nextLong();
        if (repo._data.containsKey(user_inputId)) {
            repo.delete(user_inputId);
            System.out.println("Il ToDo con id " + user_inputId + " è stato rimosso");
        }
        else {
            System.out.println("Sembra che questo id non esista...");
        }
    }
}
