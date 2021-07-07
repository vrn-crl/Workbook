package ires.corso.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Applicazione {

    public static void main(String[] args) throws IOException {
        Biblioteca.initialization("todo.ser");
        Biblioteca library = Biblioteca.getToDoRepository();
        ArrayList<Libro> listaLibri = library.getList();
        menuApp();
        Biblioteca.writeToFile();
    }

    public static void menuApp() throws IOException {
        Lista lista = new Lista();
        Scanner in = new Scanner(System.in);
        boolean exit = false;
        //boolean innerExit = false;
        while (!exit){
            System.out.println("----------BENVENUTO NELLA TUA BIBLIOTECA!----------");
            System.out.println("Scegli cosa vuoi fare:)");
            System.out.println("1. Visualizza elenco libri");
            System.out.println("2. Aggiungi un volume");
            System.out.println("3. Modifica un volume");
            System.out.println("4. Elimina un volume");
            System.out.println("5. Avanzamento lettura");
            System.out.println("6. Giudizio personale");
            System.out.println("7. Uscita");

            String user_input = in.nextLine();
            switch (user_input) {
                case "1":
                   lista.viewByTitle();//visualizza elenco libri
                    break;
                case "2":
                    LibraryManager.createNewBook();
                    break;
                case "3":
                    LibraryManager.updateBook();
                    break;
                case "4":
                    LibraryManager.deleteBook();
                case "5":
                    //
                    break;
                case "6":
                    //
                    break;
                case "7":
                    System.out.println("Sei sicuro di voler uscire?");
                    String user_in = in.nextLine();
                    if(user_in.equalsIgnoreCase("si")){
                        System.out.println("Arrivederci!");
                        exit =  true;
                        break;
            }
        }
    }

    }
}
