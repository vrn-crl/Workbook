package ires.corso.parttwo.todo;

import java.util.Scanner;

// GRUPPO 3/4:
public class ToDoApplication
{
    // 1. Deserializza il repository da file (carica i dati dell'ultimo salvataggio)
    //    creando una classe Repository
    // 2. Gestione del MENU principale con un loop e due switch
    // 3. In corrispondenza di una scelta dell'utente (ramo dello switch) chiama
    //    le classi necessarie per svolgere l'azione
    // 4. Chiede conferma e serializza in uscita
    // 5. Fornisce anche i metodi della classe "lettore" di quiz... askForInput , display
    public static void doMenu(){
        while(true) {
            System.out.println();
            System.out.println("--------------------------TO DO LIST--------------------------");
            System.out.println("Scegli cosa vuoi fare!");
            System.out.println("1. VISUALIZZA\n");
            System.out.println("2. AGGIUNGI, RIMUOVI, MODIFICA\n");
            System.out.println("3. IMPORT/EXPORT\n");
            System.out.println("4. USCITA\n");
            System.out.println();

            Scanner in = new Scanner(System.in);
            String userInsert= in.nextLine();

            switch(userInsert){
                case "1":
                    System.out.println("1. Per priorità");
                    System.out.println("2. Per Data");
                    System.out.println("3. Per cjapilu");
                    userInsert = in.nextLine();
                    switch (userInsert){
                        case "1":
                            //funzione corrispondente;
                        case "2":
                            //funzione corrispondente;
                        case "3":
                            //funzione corrispondente;
                    }
                    break;
                case "2":
                    System.out.println("1.");
                    System.out.println("2.");
                    System.out.println("3.");
                    userInsert = in.nextLine();

                    switch(userInsert){
                        case "1":
                            //funzione corrispondente
                            break;
                        case "2":
                            //funzione corrispondente
                            break;
                        case "3":
                            //funzione corrispondente
                            break;

                }
                    break;
                case "3":
                    System.out.println();
                    System.out.println();
                    userInsert = in.nextLine();
                    switch (userInsert){
                        case "1":
                            //funzione corrispondente;
                            break;
                        case "2":
                            //funzione corrispondente;
                            break;
                    }
                    break;

                case "4":
                    System.out.println("Arrivederci!");
                    System.exit(0);
                    break;
            }

        }
    }
}
