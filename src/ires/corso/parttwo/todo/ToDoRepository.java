package ires.corso.parttwo.todo;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class ToDoRepository implements Serializable {

    private static boolean _init=false;
    private static String _fileName;
    private static ToDoRepository _repository = null;

    // Inizializzazione: imposta file di serializzazione
    public static boolean init(String fileName) {
        try {
            Path p = Paths.get(fileName);
            _fileName = p.toString();
            _init = true;
        } catch (InvalidPathException ipe) {
            System.out.println(ipe.getMessage());
        }
        return _init;
    }

    public static void writeToFile() throws IOException {
        try {
            FileOutputStream file = new FileOutputStream(_fileName);
            ObjectOutputStream out = new ObjectOutputStream(file);

            out.writeObject(_repository);
            //out.close();
            //file.close();
        } catch (IOException e) {
            System.out.println("IOException is caught");
        }
    }

    // Deserializza l'istanza del ToDoRepository da file
    public static ToDoRepository loadFromFile() throws IOException {
        try {
            FileInputStream file = new FileInputStream(_fileName);
            ObjectInputStream in = new ObjectInputStream(file);
            _repository = (ToDoRepository) in.readObject(); //parse a ToDoRepository
            in.close();
            file.close();

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("IOException is caught uat");
        }
        return _repository;
    }

    Map<Long, ToDo> _data = new HashMap<>();
    private long _idSeed;

    private ToDoRepository() {
    }  // Costruttore privato: non è possibile generare ToDoRepository con "new" dall'esterno

    public static ToDoRepository getToDoRepository() throws IOException {  // Restituisce sempre la stessa istanza (quella serializzata/deserializzata da file)
        if (_repository == null) {
            _repository = new ToDoRepository();
        }
        else {return loadFromFile();}
        return _repository;
    }

    public long getNewId() {
        _idSeed++;
        return _idSeed;
    }

    // Elimina un TO-DO
    public void delete(Long ID) {
        _data.remove(ID);
    }

    // Aggiunge un TO-DO
    public void add(ToDo t) {
        Long newId = getNewId();
        t.setId(newId);// si deve entrare nell'oggetto t e settare ID
        _data.put(newId, t);  // per poi salvarlo nella mappa correttamente (con put(ID, t))
    }

    // Aggiorna un TO-DO
    public void update(ToDo t) {
        if (_data.containsKey(t.getId())) {
            _data.replace(t.getId(), t);
        } else {
            System.out.println("Il To-Do non esiste nel repository");
        }
    }


    // Restituisce una lista di tutti i TO-DO
    public ArrayList<ToDo> getToDoList() {
        ArrayList<ToDo> toDoList = new ArrayList<>();
        for (ToDo t : _data.values()) {
            toDoList.add(t);
        }
        return toDoList;
    }
}


