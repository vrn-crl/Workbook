package ires.corso.parttwo.collection.biblioteca;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Utente {
    private String nome;
    private String cognome;
    private int id;
    public List<Prestito> listaPrestiti = new ArrayList<>();
    public Map<Utente, ArrayList<Prestito>> relazioneUtentePrestiti= new HashMap<>();

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
}
