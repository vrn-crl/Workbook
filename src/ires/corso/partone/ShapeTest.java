package ires.corso.partone;

//import ires.corso.partone.geometric.Quadrato;

import ires.corso.partone.geometric.Quadrato;
import ires.corso.partone.geometric.Trapezio;
import ires.corso.partone.geometric.Triangolo;

import java.util.Scanner;

public class ShapeTest {

    public static void main(String[] args) {

        System.out.println("Quale area desideri calcolare fra Triangolo, Trapezio e Quadrato?");
        Scanner in = new Scanner(System.in);
        String shape = in.nextLine();
        switch (shape) {
            case "Quadrato":
                System.out.println("Inserisci misura lato quadrato:");
                double l_insert = in.nextDouble();
                double areaQuad = Quadrato.calc_area(l_insert);
                System.out.println(areaQuad);
            break;
            case "Triangolo":
                System.out.println("Inserisci misura base triangolo:");
                double b_insert = in.nextDouble();
                System.out.println("Inserisci misura altezza triangolo:");
                double h_insert = in.nextDouble();
                double areaTri = Triangolo.calc_area(b_insert, h_insert);
                System.out.println(areaTri);
            break;
            case "Trapezio":
                System.out.println("Inserisci misura base maggiore:");
                double bM_insert = in.nextDouble();
                System.out.println("Inserisci misura base minore:");
                double bm_insert = in.nextDouble();
                System.out.println("Inserisci misura altezza:");
                double ht_insert = in.nextDouble();
                double areaTra = Trapezio.calc_area( bM_insert, bm_insert, ht_insert);
                System.out.println(areaTra);
            break;

        }
    }

}
