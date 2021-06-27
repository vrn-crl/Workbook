package ires.corso.parttwo.collection.università;

public class Assignment {
    private String titolo;
    private String descrizione;
    private double voto;
    //- Assignment (titolo, descrizione)
    public Assignment(String titolo, String descrizione){
        this.titolo = titolo;
        this.descrizione = descrizione;
    }

    public float voto(){
        return (float) (Math.random()*10);
    }
}
