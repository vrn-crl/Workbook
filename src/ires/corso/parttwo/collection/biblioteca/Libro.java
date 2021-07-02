package ires.corso.parttwo.collection.biblioteca;

import java.util.*;

public class Libro {
    //varibili
    private final String titolo;
    private final String autore;
    private final String dataPubb;
    private final int numPages;
    private final int numVolumes;
    private final int numChapters;
    public List<Categoria> categorieLibri = new ArrayList<>(); //ogni libro ha oiù di una categoria
    public static Map<Libro, ArrayList<Categoria>> relazioneLibroCat = new HashMap<>();

    //costruttore
    public Libro(String titolo, String autore, String dataPubb, int numPages, int numVolumes, int numChapters ){
        this.titolo = titolo;
        this.autore = autore;
        this.dataPubb = dataPubb;
        this.numPages = numPages;
        this.numVolumes = numVolumes;
        this.numChapters = numChapters;
    }

    //metodi
    public void aggiungiAMap (Libro l, Categoria c){
        ArrayList<Categoria> categories;
        categories = new ArrayList<>();
        categories.add(c);
        relazioneLibroCat.put(l, categories);
    }
    public static List<Categoria>  ottieniCategoria(Libro l){
       return relazioneLibroCat.get(l);
    }
    public void aggiungiCategoria(Categoria c) {    //1.
        categorieLibri.add(c);
       // aggiungiAMap(this, c);
    }


//--------------------GETTER E SETTER--------------------------

    public String getTitolo()
    {
        return titolo;
    }
    public String getAutore() {
        return autore;
    }

    public String getDataPubb() {
        return dataPubb;
    }

    public int getNumPages() {
        return numPages;
    }

    public int getNumVolumes() {
        return numVolumes;
    }

    public int getNumChapters() {
        return numChapters;
    }
}
