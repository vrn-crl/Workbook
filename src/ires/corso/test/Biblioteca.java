package ires.corso.test;

import java.io.*;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Biblioteca {

    //variabili statiche
    private static boolean _init=false;
    private static String _fileName;
    private static Biblioteca _biblioteca = null;


    //istanza di classe
    private Biblioteca() {
    }
    // Restituisce sempre la stessa istanza (quella serializzata/deserializzata da file)
    public static Biblioteca getToDoRepository() throws IOException {
        if (_biblioteca == null) {
            _biblioteca = new Biblioteca();
        }
        else {return loadFromFile();}
        return _biblioteca;
    }

    //INIZIALIZZAZIONE
    public static boolean initialization(String fileName){
        try {
            Path p = Paths.get(fileName);
            _fileName = p.toString();
            _init = true;
        } catch (InvalidPathException ipe) {
            System.out.println(ipe.getMessage());
        }
        return _init;
    }

    //SERIALIZZAZIONE E DESERIALIZZAZIONE

    public static void writeToFile() throws IOException {
        try {
            FileOutputStream file = new FileOutputStream(_fileName);
            ObjectOutputStream out = new ObjectOutputStream(file);

            out.writeObject(_biblioteca);
            //out.close();
            //file.close();
        } catch (IOException e) {
            System.out.println("IOException is caught S&D");
        }
    }

    public static Biblioteca loadFromFile() throws IOException {
        try {
            FileInputStream file = new FileInputStream(_fileName);
            ObjectInputStream in = new ObjectInputStream(file);
            _biblioteca = (Biblioteca)in.readObject();
            in.close();
            file.close();
        }
        catch (IOException|ClassNotFoundException e){
            System.out.println("IO exception is caught");
        }
        return _biblioteca;
    }

    Map<Long, Libro> _data = new HashMap<>();
    private long _idSeed;

    public Long getNewid(){
        _idSeed++;
              return _idSeed;
    }

    //aggiunta di una nuova istanza alla biblioteca
    public void addBook(Libro l){
        Long newId = getNewid();
        l.setId(newId);// setto ID oggetto l
        _data.put(newId, l);  // lo salvo nella mappa
    }

    //eliminazione di un'istanza dalla biblioteca
    public void deleteBook(Long id){
        _data.remove(id);
    }

    //modifica di un'istanza esistente;
    public void updateBook(Libro l){
        Long keyBook = l.getId();//ottengo id libro;
        if(_data.containsKey(keyBook)){ //controllo che effettivamente ci sia quell'id nella mappa;
            _data.replace(keyBook, l); //sostituisco in mappa con libro aggiornato
        }
        else {
            System.out.println("Non ho trovato il libro che volevi aggiornare...");
        }
    }

    //Elenco di tutte le istanza disponibili;
    public ArrayList<Libro> getList(){
        ArrayList<Libro> listaLibri = new ArrayList<>();
        for(Libro l: _data.values()){
            listaLibri.add(l);
        }
        return listaLibri;
    }
}
