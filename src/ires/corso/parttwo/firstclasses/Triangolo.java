package ires.corso.parttwo.firstclasses;
//4. le classi figlie (Trapezio, Triangolo, Quadrato) devono estendere con "extends" la MasterShape e implementare l'
//   override dei metodi computeArea e computePerimeter (nota: aggiungere l'annotation @Override)


import java.util.Scanner;

public class Triangolo extends MasterShape {
    // 3. usate i costruttori speficici delle classi figlie per richiedere al momento della creazione i parametri che
    //    servono per fare i calcoli in ciascuna forma geometrica;

    public Triangolo(int b, int h){
        this.b = b;
        this.h = h;
    }

    public int getB(){
        return b;
    }

    public int getH(){
        return h;
    }


    public void setL1(int l1, int l2){ //lato obliquo1
        this.l1 = l1;
        this.l2 = l2;
    }
    public int getL1(){
        return l1;
    }

    public int getL2(){
        return l2;
    }

    @Override
    public int computeArea(){
        return (this.getB() * this.getH())/2;
    }

    @Override
    public int computePerimeter(){
        int perimeter = this.getL1() + this.getL2() + this.getB();
        return perimeter;
    }
}

