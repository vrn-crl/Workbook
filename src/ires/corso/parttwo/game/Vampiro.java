package ires.corso.parttwo.game;

public class Vampiro implements Mostro {

    protected int forza;
    public Vampiro (){//costruttore
        forza = 15;
    }

    public void azzanna(){
        forza = forza-2;
    }
    public String getForza(){
        return "Forza rimanente Vampito " + forza;
    }
}
