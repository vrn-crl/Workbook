package ires.corso.parttwo.firstclasses;

import java.util.Scanner;

//1. creare una classe "MasterShape" che sarà la classe parent;

public class MasterShape {
    protected int l;
    protected int bM;
    protected int b;
    protected int h;
    protected int l1,l2; //lati obliqui

    //2. all'interno di MasterShape definire il metodo computeArea e il metodo computePerimeter, che NON devono
    //ricevere argomenti in input.
    //n.b. i metodi computeArea e computePerimeter della MasterShape avranno "return 0;", tanto poi ci farò l'override.

    public int computeArea(){
        return 0;
}

    public int computePerimeter(){
        return 0;
}

}
