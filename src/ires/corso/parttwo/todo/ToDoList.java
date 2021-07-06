package ires.corso.parttwo.todo;

import java.io.IOException;
import java.util.*;

// GRUPPO 1:
public class ToDoList {
    // Implementa le funzionalità di visualizzazione con:
    // - ordinamento per priorità
    // - ordinamento per data
    // - ordinamento per stato
    // Si appoggia a un metodo di ToDoRepository per avere una lista (= copia dei TO-DO
    // originali) dei TO-DO attualmente a sistema, cioè un ArrayList facilmente utilizzabile

    private ToDoRepository tdr = ToDoRepository.getToDoRepository();//ci ritorna quella repository (oggetto statico, smepre quello)
    private ArrayList<ToDo> tDList = tdr.getToDoList();

    Comparator<ToDo> compareByPriority = (t1, t2) -> t1.getPriority().compareTo(t2.getPriority());

    public ToDoList() throws IOException {
    }

    public void viewByPriority() {
        Collections.sort(tDList, compareByPriority);
        tDList.forEach(t -> System.out.println(t.prettyPrint()));
    }

    Comparator<ToDo> compareByStatus = (ToDo t1, ToDo t2) -> t1.getStatus().compareTo(t2.getStatus());

    public void viewByStatus() {
        Collections.sort(tDList, compareByPriority);
        tDList.forEach(t -> System.out.println(t.prettyPrint()));
    }

    Comparator<ToDo> compareByDate = (ToDo t1, ToDo t2) -> t1.getDeliveryDate().compareTo(t2.getDeliveryDate());

    public void viewByDate() {
        Collections.sort(tDList, compareByDate);
        tDList.forEach(t -> System.out.println(t.prettyPrint()));
    }

}
