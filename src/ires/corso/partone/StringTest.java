package ires.corso.partone;

public class StringTest {
    public static void main(String[] args) {
        //accetta in input tre stringhe
        System.out.println(args[0] + " "+ args[1] + " " + args[2]);

        //verifica che gli elementi sono 3

        int arrayLength=args.length;
        System.out.println(arrayLength);

        if (arrayLength==3) {
            System.out.println("no problem");
        }
        else {
            System.out.println("Inserisci 3 args!");
        }

        //calcola la lunghezza di ciascuna stringa
        int string_1 = args[0].length();
        System.out.println(string_1);

        int string_2 = args[1].length();
        System.out.println(string_2);

        int string_3 = args[2].length();
        System.out.println(string_3);

        // 4. trova il carattere iniziale e finale di ciascuna stringa
        char initialChar1 = args[0].charAt(0);
        System.out.println(initialChar1);

        char initialChar2 = args[1].charAt(0);
        System.out.println(initialChar2);

        char initialChar3 = args[2].charAt(0);
        System.out.println(initialChar3);

        char finalChar1 = args[0].charAt(string_1 - 1);
        System.out.println(finalChar1);

        char finalChar2 = args[1].charAt(string_2 - 1);
        System.out.println(finalChar2);

        char finalChar3 = args[2].charAt(string_3 - 1);
        System.out.println(finalChar3);

        // 5. per tutte e 3 le stringhe stampa un report:
        // "La stringa " .... " ha lunghezza " .... " comincia per " ... " e fniisce per " ...
        String output1 = String.format("La stringa %s ha lunghezza %d, comincia per %c e finisce per %c ", args[0], string_1, initialChar1, finalChar1);
        String output2 = String.format("La stringa %s ha lunghezza %d, comincia per %c e finisce per %c ", args[1], string_2, initialChar2, finalChar2);
        String output3 = String.format("La stringa %s ha lunghezza %d, comincia per %c e finisce per %c ", args[2], string_3, initialChar3, finalChar3);

        System.out.println(output1 + output2 + output3);
    }
}
