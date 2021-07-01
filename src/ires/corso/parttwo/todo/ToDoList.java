package ires.corso.parttwo.todo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;

// GRUPPO 1:
public class ToDoList
{
    // Implementa le funzionalità di visualizzazione con:
    // - ordinamento per priorità
    // - ordinamento per data
    // - ordinamento per stato
    // Si appoggia a un metodo di ToDoRepository per avere una lista (= copia dei TO-DO
    // originali) dei TO-DO attualmente a sistema, cioè un ArrayList facilmente utilizzabile

    ToDoRepository tdr = ToDoRepository.getToDoRepository();//ci ritorna quella repository (oggetto statico, smepre quello)
    ArrayList<ToDo> tDList = tdr.getToDoList();

    public void viewByPriority() {
        // Questa funzione è chiamata qunado l'utente sceglie di visualizzare i dati per priorità...

    public void viewByDate(){
        tDList.sort(Comparator<>);
        }
    }
}
