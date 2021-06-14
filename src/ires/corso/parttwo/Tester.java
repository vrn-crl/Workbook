package ires.corso.parttwo;

import ires.corso.parttwo.firstclasses.MasterShape;
import ires.corso.parttwo.firstclasses.Quadrato;
import ires.corso.parttwo.firstclasses.Trapezio;
import ires.corso.parttwo.firstclasses.Triangolo;

import java.sql.SQLOutput;
import java.util.Scanner;
//5. creare una classe Tester con il metodo main(String[] args), all'interno del quale devo:

public class Tester {
    public static void main(String[] args) {
    /*
5
- creare un array di MasterShape che avrà come elementi le istanze create
- calcolare le aree e stamparle in un unico loop
*/
        /*
        System.out.println("Quale figura geometrica ti interessa?");
        String user_in = in.nextLine();*/
        Scanner in = new Scanner(System.in);
        //5.1 creare 3 forme geometriche diverse come istanze delle classi figlie;
        //chiedere i dati in input nel metodo main e salvateli nelle proprietà interne di ciascuna classe;


        //AREA E PERIMETRO QUADRATO
        System.out.println("Inserisci lato quadrato");
        int l_insert = in.nextInt();
        Quadrato q1 = new Quadrato(l_insert);
        //System.out.println("Hai creato un oggetto Quadrato di lato " + q1.getL());


        //AREA E PERIMETRO TRIANGOLO
        System.out.println("Inserisci base e altezza triangolo");
        int b_insert = in.nextInt();
        int h_insert = in.nextInt();
        Triangolo t1 = new Triangolo(b_insert, h_insert);
        System.out.println("Inserisci i lati obliqui del triangolo");
        int l1_insert = in.nextInt();
        int l2_insert = in.nextInt();
        t1.setL1(l1_insert, l2_insert);

        //AREA E PERIMETRO TRAPEZIO
        System.out.println("Inserisci base BASE MINORE, BASE MAGGIORE e ATEZZA TRAPEZIO");
        int bT_insert = in.nextInt();
        int bM_insert = in.nextInt();
        int hT_insert = in.nextInt();
        Trapezio trap1 = new Trapezio(bT_insert, bM_insert, hT_insert);


        System.out.println("Inserisci i lati obliqui del trapezio");
        int lT1_insert = in.nextInt();
        int lT2_insert = in.nextInt();
        trap1.setL1(lT1_insert, lT2_insert);

        MasterShape[] arrayShapes = new MasterShape[3];
        arrayShapes[0] = q1;
        arrayShapes[1] = t1;
        arrayShapes[2] = trap1;

        System.out.println("Ti interessa Area o Perimetro?");
        String insert_AoP = in.nextLine();

        for (int i = 0; i < arrayShapes.length; i++) {
            switch (insert_AoP) {
                case "Area":
                    System.out.println("L'area è " + arrayShapes[i].computeArea());
                    break;
                case "Perimetro":
                    System.out.println("il suo perimetro è " + arrayShapes[i].computePerimeter());
                    break;

                    }
                }
            }
        }