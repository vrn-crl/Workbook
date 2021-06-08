package ires.corso.partone;

import java.util.Scanner;

//import java.util.*; per importare tutto
public class InputTest {

    public static void main(String[] args) {
        Scanner in;
        in = new Scanner(System.in);// Contrario di sout
        //soluzione "brutta" temporanea
        String[] position = {" primo", " secondo", " terzo"};

        System.out.println("Inserisci il primo numero: ");
        int n = in.nextInt();

        System.out.println("Inserisci il secondo numero: ");
        int m = in.nextInt();

        System.out.println("Inserisci il terzo numero: ");
        int l = in.nextInt();

        System.out.println("Hai inserito i numeri " + n + "," + m + "," + l);

        if (n>m){
            if(n>l){
                System.out.println("Il numero maggiore è il " + position[0] + " inserito e vale " + n);
            }
            else
                System.out.println("Il numero maggiore è il " + position[2] + " inserito e vale " + l);
        }
        else
            if(m>l) {
                System.out.println("Il numero maggiore è il " + position[1] + " inserito e vale " + m);
            }
            else
                System.out.println("Il numero maggiore è il " + position[2] + " inserito e vale " + l);

    }

}
