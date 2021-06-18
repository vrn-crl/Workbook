package ires.corso.parttwo.game;

public class Licantropo implements Mostro, Umano{

    private boolean isUomo;
    protected int forzaUmano, forzaMostro;
    boolean luna = true;
    public Licantropo(boolean luna)
    {
        isUomo = !luna; //isUomo = false
        if (luna)
        {forzaMostro=15; forzaUmano=0; }
        else {forzaUmano=10; forzaMostro=0;}
    }
    public String getForza () {
        return "Forza rimanente come Umano:" + forzaUmano + "\nForza rimanente come Mostro: " + forzaMostro;
    }

    public void azzanna()
    { if (!isUomo) forzaMostro=forzaMostro-2;}
    public void combatti ()
    { if (isUomo) forzaUmano=forzaUmano-3;}
}
