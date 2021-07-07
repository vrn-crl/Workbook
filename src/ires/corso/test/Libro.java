package ires.corso.test;

import java.time.LocalDate;

public class Libro {
    protected Long id;
    private String titolo;
    private String autore;
    private String descrizione;
    private String isbnCode;
    private LocalDate dataPubblicazione;
    private Generi genere;
    private Giudizi giudizio;

        protected enum Generi {
            HORROR,
            CLASSICO,
            DRAMMATICO,
            FANTASY,
            ROMANZO
        }

    protected enum Giudizi {
        PER_NIENTE,
        POCO,
        ABBASTANZA,
        MOLTO,
        MOLTISSIMO
    }
    private Integer avanzamento;

    public Libro(String titolo, String autore, String descrizione, String isbnCode, LocalDate dataPubblicazione, Generi genere) {
        this.titolo = titolo;
        this.autore = autore;
        this.descrizione = descrizione;
        this.isbnCode = isbnCode;
        this.dataPubblicazione = dataPubblicazione;
        this.genere = genere;
    }

  //--GETTER----------------------------------------------------------------------

    public Long getId() {
        return id;
    }

    public String getTitolo() {
        return titolo;
    }

    public String getAutore() {
        return autore;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public String getIsbnCode() {
        return isbnCode;
    }

    public LocalDate getDataPubblicazione() {
        return dataPubblicazione;
    }

    public Integer getAvanzamento() {
        return avanzamento;
    }

    public Generi getGenere() {
        return genere;
    }

    public Giudizi getGiudizio() {
        return giudizio;
    }
//--SETTER------------------------------------------------------------------------

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public void setIsbnCode(String isbnCode) {
        this.isbnCode = isbnCode;
    }

    public void setDataPubblicazione(LocalDate dataPubblicazione) {
        this.dataPubblicazione = dataPubblicazione;
    }

    public void setGenere(Generi genere) {
        this.genere = genere;
    }

    public void setGiudizio(Giudizi giudizio) {
        this.giudizio = giudizio;
    }

    public void setAvanzamento(Integer avanzamento) {
        this.avanzamento = avanzamento;
    }

    public String printBook(){
        String s = String.format(" ID: %d \n TITOLO: %s \n DELL'AUTORE: %s \n DESCRIZIONE: %s \n  ISBN: %s \n DATA DI PUBBLICAZIONE: %s \n GENERE: %s", getId(), getTitolo(), getAutore(), getDescrizione(), getIsbnCode(), getDataPubblicazione().toString());//non regolato
        return s;
    }

    //-----------------------------------------------------------------------------------------------------------------
    public Libro cloneForUpdate() throws CloneNotSupportedException {

        Libro copiedToDo = null;
        try{
            copiedToDo = (Libro) clone();
        }
        catch (CloneNotSupportedException ce){
            System.out.println("error with clonation");
        }
        return copiedToDo;
    }
}
