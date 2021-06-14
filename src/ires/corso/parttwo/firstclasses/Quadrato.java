package ires.corso.parttwo.firstclasses;

import java.util.Scanner;
//4. le classi figlie (Trapezio, Triangolo, Quadrato) devono estendere con "extends" la MasterShape e implementare l'
//   override dei metodi computeArea e computePerimeter (nota: aggiungere l'annotation @Override)
public class Quadrato extends MasterShape{

    //    usate i costruttori speficici delle classi figlie per richiedere al momento della creazione i parametri che
    //    servono per fare i calcoli in ciascuna forma geometrica;
    Scanner in = new Scanner (System.in);

    public Quadrato(int l){
        this.l = l;
    }

    public int getL(){
        return l;
    }

@Override
    public int computeArea(){
        return this.getL() * this.getL();
}

@Override
    public int computePerimeter(){
        int l_perimeter = this.getL();
        return l_perimeter * 4;
}
}
