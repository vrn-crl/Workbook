package ires.corso.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Lista {
    public Lista() throws IOException {
    }
    private Biblioteca b = Biblioteca.getToDoRepository();
    private ArrayList<Libro> lista= b.getList();

    //ordinamento lista per titolo
   Comparator<Libro> compareByTitle = (l1, l2) -> l1.getTitolo().compareTo(l2.getTitolo());


    public void viewByTitle() {
      Collections.sort(lista, compareByTitle);
      lista.forEach(l -> System.out.println(l.printBook()));
    }
}
