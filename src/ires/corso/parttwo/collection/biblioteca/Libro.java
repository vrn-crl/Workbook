package ires.corso.parttwo.collection.biblioteca;

import java.util.Date;

public class Libro {
    private final String titolo;
    private final String autore;
    private final String dataPubb;
    private final int numPages;
    private final int numVolumes;
    private final int numChapters;

    public Libro(String titolo, String autore, String dataPubb, int numPages, int numVolumes, int numChapters ){
        this.titolo = titolo;
        this.autore = autore;
        this.dataPubb = dataPubb;
        this.numPages = numPages;
        this.numVolumes = numVolumes;
        this.numChapters = numChapters;
    }

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
