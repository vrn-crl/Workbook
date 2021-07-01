package ires.corso.parttwo.todo;

import java.io.*;
import java.util.*;

// GRUPPO 4:

public class ToDoRepository implements Serializable {
    private static ToDoRepository _repository = null;

    public static void writeToFile() throws IOException {

        try {
            FileOutputStream file = new FileOutputStream("ToDoList.txt");
            ObjectOutputStream out = new ObjectOutputStream(file);

            out.writeObject(_repository);

            out.close();
            file.close();
        } catch (IOException e) {
            System.out.println("IOException is caught");
        }
    }

    public static ToDoRepository loadFromFile() throws IOException {
        // Individua il file e lo deserializza con readObject
        // _repository = ...
        try {
            FileInputStream file = new FileInputStream("ToDoList.txt");
            ObjectInputStream in = new ObjectInputStream(file);

            _repository = (ToDoRepository) in.readObject();

            in.close();
            file.close();
        } catch (IOException | ClassNotFoundException e) {
            System.out.printf("IOException is caught");
        }

        return _repository;
    }

    // UNICA istanza del repository, dichiarata come
    // membro static della classe ToDoRepository


    // Deserializza l'istanza del ToDoRepository da file
    public static ToDoRepository loadFromFile(String fileName) {
        // Individua il file e lo deserializza con readObject
        // _repository = ...
        return _repository;
    }

    // Restituisce sempre la stessa istanza (quella serializzata/deserializzata da file)
    public static ToDoRepository getToDoRepository() {
        return _repository;
    }

    Map<Long, ToDo> _data = new HashMap<>();    // Mappa ID -> TO-DO
    //private long _idSeed;                       // Contatore per la generazione degli id

    // Costruttore privato: non è possibile generare ToDoRepository con "new" dall'esterno
    private ToDoRepository() {
    }

    // Utilizzato per generare un nuovo ID
    //public long getNewId() {
    //    _idSeed++;
    //    return _idSeed;
    //}

    // Elimina un TO-DO
    public void delete(Long ID) {
        _data.remove(ID);
    }

    ;

    // Aggiunge un TO-DO
    public void add(ToDo t) {
        // si deve entrare nell'oggetto t e leggere il suo ID
        // per poi salvarlo nella mappa correttamente (con put(ID, t))
        _data.put(t.getId(), t);
    }

    // Aggiorna un TO-DO ???
    public void update(ToDo t) {
        // si prende l'ID dall'oggetto da aggiornare t
        Long tId = t.getId();//id dell oggetto aggiornato t
        _data.put(tId, t);
        //se l'id esiste allora
        Set<Long> sl = _data.keySet();
        Iterator<Long> longIter = sl.iterator();

        while (longIter.hasNext()) {

            if (longIter.next() == t.getId()){
            _data.put(t.getId(), t);
        }
            else{
            System.out.println("non esiste questa chiave nel repository");
         }
        }
        // si recupera dalla mappa il TO-DO corrispondente con get(t), per controllo
        // si sostituisce con put(ID, t)
    }




    // Restituisce una lista di tutti i TO-DO
    public ArrayList<ToDo> getToDoList() { //iteratore sulla mappa??
        // restituisce lista di tutti i TO-DO esistenti
        ArrayList <ToDo> toDoList= new ArrayList(_data.values());
        return toDoList;

    }



    // Salva tutta l'istanza del repository (compresi gli oggetti
    // TO-DO presenti in mappa) in un file tramite il metodo
    // writeObject di ObjectOutputStream.
    // Anche il membro idSeed è salvato su file (è variabile di istanza).

}

