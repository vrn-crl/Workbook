package ires.corso.parttwo.collection.biblioteca;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Utente {
    private String nome;
    private String cognome;
    private Integer id;

    public List<Prestito> listaPrestiti = new ArrayList<>();

    public static Map<Integer, ArrayList<Prestito>> relazioneUtentePrestiti= new HashMap<>();
    public Map<Integer,  Map<Libro, ArrayList<Categoria>>> relazIdElencoPrestiti = new HashMap<>();

    public Utente(String nome, String cognome, int id){
        this.nome = nome;
        this.cognome = cognome;
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public int getId() {
        return id;
    }

    public static List<Prestito> getLoanById(Integer id) {
        return relazioneUtentePrestiti.get(id);
    }


        private static void addToMap(Integer i, Prestito p) {
            List<Prestito> prestiti;
            if(relazioneUtentePrestiti.containsKey(i)) { //se la mappa contiene l'id

                relazioneUtentePrestiti.get(i).add(p);// allora prendi il valore relatio a quell'id e aggiorna il prestit0?
            }
            else {
                prestiti = new ArrayList<>(); //altrimenti crea un array di prestiti
                prestiti.add(p); //aggiungi un prestito
                relazioneUtentePrestiti.put(i, (ArrayList<Prestito>) prestiti);
            }
        }
    public void aggiungiPrestito(Prestito p) {
        listaPrestiti.add(p);
        addToMap(this.id, p);
    }

}
