package ires.corso.parttwo.collection.biblioteca;

public class Categoria {
    private String titolo;
    private String descrizione;

    public Categoria(String titolo, String descrizione){
        this.titolo = titolo;
        this.descrizione = descrizione;
    }

    public String getTitolo() {
        return titolo;
    }

    public String getDescrizione() {
        return descrizione;
    }
}
