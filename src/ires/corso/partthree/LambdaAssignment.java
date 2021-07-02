package ires.corso.partthree;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LambdaAssignment
{
    public static void main(String[] args) {
        // 1. Data una lista di nomi:
        //    - Agnese Stefano, Niki, Veronica, GabrieleM, Davide, GabrieleG, Alessandor, Albnerto, Fabiola, Alessio, Daniele
        //    - ...partire con un ArrayList che li contiene;
        List<String> names = new ArrayList<>();
        names.add("Agnese");
        names.add("Niki");
        names.add("Veronica");
        names.add("Gabriele");

        //    - trasformarlo in stream
       Stream<String> namesStream = names.stream();

        //Stream<Long> namesLength = namesStream.map(s -> Long.valueOf(s.length()));
        //    - filtrare (escludendoli) i nomi che hanno lunghezza < 5 lettere
                names
                .stream()
                .filter(s -> s.length() > 4)
                .map(String::toUpperCase)//Returns a stream consisting of the results of applying the given function (lambda) to the elements of this stream.
                .forEach(System.out::println);
                //trasformo in maiuscole ritorna uno stream
                //.collect(Collectors.toList());


       // System.out.println(piuDiCinqueLettere);
        //  - trasformare con UPPERCASE i rimanenti
        //  - stamparli su schermo
        //for (String s:piuDiCinqueLettere) { //for enanced
         //   System.out.println(s.toUpperCase());
        //}


        // 2. Fare un programma Java che:
        //    - chiede all'utente una lista di numeri (separati da virgola) <== RIUSATE IL CODICE DEL SORTING GAME
        Scanner in = new Scanner(System.in);
        System.out.println("=>");
        String linea = in.nextLine();
        String[] stringLines = linea.split(",");
        ;
        ArrayList<Double> doubleNumb = new ArrayList<>();

        for (String s : stringLines) {
            Double d = Double.parseDouble(s);
            doubleNumb.add(d);
        }

        doubleNumb
                .stream() //    - li trasforma in stream
                .distinct() //    - filtra i duplicati (HINT: guardate bene i metodi dell'interfaccia Stream...)
                .map(d -> d * d)// - eleva al quadrato i numeri filtrati//utilizziamo metodi vuoti. map non fa niente finchè non gli diciamo cosa fare
                .collect(Collectors.toList());


        //manca average
    //    - calcola la media (HINT: operazione terminale chiamata "average": https://docs.oracle.com/en/java/javase/16/docs/api/java.base/java/util/stream/IntStream.html#average())
    }
}