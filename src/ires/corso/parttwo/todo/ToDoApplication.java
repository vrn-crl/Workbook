package ires.corso.parttwo.todo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

// GRUPPO 3/4:
public class ToDoApplication {
    // 1. Deserializza il repository da file (carica i dati dell'ultimo salvataggio)
    //    creando una classe Repository
    // 2. Gestione del MENU principale con un loop e due switch
    // 3. In corrispondenza di una scelta dell'utente (ramo dello switch) chiama
    //    le classi necessarie per svolgere l'azione
    // 4. Chiede conferma e serializza in uscita
    // 5. Fornisce anche i metodi della classe "lettore" di quiz... askForInput , display

    public static void main(String[] args) throws IOException {
        ToDoRepository.init("todo.ser");
        ToDoRepository tdr = ToDoRepository.getToDoRepository();
        ArrayList<ToDo> tdl = tdr.getToDoList();
        doMenu();
        ToDoRepository.writeToFile();
    }

        public static void doMenu() throws IOException {
            ToDoList tdl = new ToDoList();
        boolean exit = false;
            while (!exit) {
                System.out.println();
                System.out.println("--------------------------TO DO LIST--------------------------");
                System.out.println("Scegli cosa vuoi fare!");
                System.out.println("1. VISUALIZZA");
                System.out.println("2. AGGIUNGI, RIMUOVI, MODIFICA");
                System.out.println("3. IMPORT/EXPORT");
                System.out.println("4. USCITA");

                Scanner in = new Scanner(System.in);
                String userInsert = in.nextLine();

                switch (userInsert) {
                    case "1":
                        System.out.println("1. Per priorità");
                        System.out.println("2. Per Data");
                        System.out.println("3. Per Stato");
                        userInsert = in.nextLine();
                        switch (userInsert) {
                            case "1":
                                tdl.viewByPriority();
                            case "2":
                                tdl.viewByDate();
                            case "3":
                                tdl.viewByStatus();
                            //default:
                                   // System.out.println("Dovresti premere un numero");
                        }
                        break;
                    case "2":
                        System.out.println("1. Aggiungi");
                        System.out.println("2. Rimuovi");
                        System.out.println("3. Modifica");
                        userInsert = in.nextLine();

                        switch (userInsert) {
                            case "1":
                                ToDoManager.createNewToDo();
                                break;
                            case "2":
                                ToDoManager.deleteToDo();
                                break;
                            case "3":
                                ToDoManager.updateToDo();
                                break;

                        }
                        break;

                    case "3":
                        System.out.println("1. Import");
                        System.out.println("2. Export");
                        userInsert = in.nextLine();
                        switch (userInsert) {
                            case "1":
                                ToDoImportExport.importFromFile();
                                break;
                            case "2":
                                ToDoImportExport.exportToFile();
                                break;
                        }
                        break;

                    case "4":
                        System.out.println("Arrivederci!");
                        exit = true;
                        break;
                }
            }
        }
    }
