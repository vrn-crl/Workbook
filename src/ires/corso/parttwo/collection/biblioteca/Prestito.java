package ires.corso.parttwo.collection.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Prestito {
    public List<Libro> listaLibriPrestati;

    public Prestito(List<Libro> listaLibriPrestati){
        this.listaLibriPrestati = listaLibriPrestati;
    }

    public List<Libro> ottieniLibriPrestati() {
        return listaLibriPrestati;
    }
}
