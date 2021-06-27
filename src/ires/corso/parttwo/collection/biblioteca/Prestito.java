package ires.corso.parttwo.collection.biblioteca;

public class Prestito {
    private final Utente u;
    int numPrestito;
    public Prestito(Utente u,int numPrestito){
        this.u = u;
        this.numPrestito = numPrestito;
    }
}
