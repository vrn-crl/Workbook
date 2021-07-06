
package ires.corso.parttwo.todo;

        import java.io.*;
        import java.lang.reflect.Array;
        import java.time.LocalDate;
        import java.util.ArrayList;
        import java.util.Iterator;
        import java.util.List;
        import java.util.Scanner;

public class ToDoImportExport {
    private static String convertToString(ToDo t) {
        String result = t.getTitle() + "|" + t.getDescription() + "|" + t.getDeliveryDate().toString() + "|"
                + t.getPriority().toString() + "|" + t.getStatus().toString();
        return result;
    }

    public static void exportToFile() throws IOException {
        Scanner in = new Scanner(System.in);
        // Chiuede all'utente un nome file di export...
        System.out.println("Inserisci nome del file");
        String fileName = in.nextLine();
        try (PrintWriter outputStream = new PrintWriter(new FileWriter(fileName))) {

            List<ToDo> toDoList = ToDoRepository.getToDoRepository().getToDoList();
            Iterator<ToDo> tdi = toDoList.iterator();

            while (tdi.hasNext()) {
                String sToDo = convertToString(tdi.next());
                outputStream.println(sToDo);
            }
        }
    }

    public static void importFromFile() throws IOException {
        // Chiede all'utente un nome file di import...
        Scanner in = new Scanner(System.in);
        // Chiuede all'utente un nome file di export...
        System.out.println("Inserisci nome del file");
        String fileName = in.nextLine();

        ArrayList<String> fileLines = new ArrayList<>();

        try (BufferedReader inputStream = new BufferedReader(new FileReader(fileName))) {
            String l;
            while ((l = inputStream.readLine()) != null) {

                fileLines.add(l);
            }
        }

        Iterator<String> itrLines = fileLines.iterator(); //fileLines ha la riga prevista dal file in input
        int numImportedToDo = 0;
        while (itrLines.hasNext()) {
            String line = itrLines.next();
            String[] strArray = line.split("\\|");

            ToDo td = toDoConverter(strArray);

            ToDoRepository.getToDoRepository().add(td);
            numImportedToDo++;
        }
    }

        private static ToDo toDoConverter(String[] str) throws IOException {

            String title = null;
            String description = null;
            LocalDate deliveryDate = null;
            ToDo.Priorities priority = null;
            ToDo.State status = null;

            if (str[1] != null)
                title = str[1];
            else
                System.out.println("Il titolo era nullo.");

            if (str[2] != null)
                description = str[2];
            else
                System.out.println("La descrizione era nulla.");

            if (str[4] != null)
                deliveryDate = LocalDate.parse(str[4]);
            else
                System.out.println("La data di creazione era nulla.");

            if (str[5].equals("ALTA")) {
                priority = ToDo.Priorities.ALTA;
            } else if (str[5].equals("MEDIA")) {
                priority = ToDo.Priorities.MEDIA;
            } else if (str[5].equals("BASSA")) {
                priority = ToDo.Priorities.BASSA;
            } else
                System.out.println("Valore di priorità nullo o non valido.");

            if (str[6].equals("DA_FARE")) {
                status = ToDo.State.DA_FARE;
            } else if (str[6].equals("IN_ESECUZIONE")) {
                status = ToDo.State.IN_ESECUZIONE;
            } else if (str[6].equals("COMPLETATA")) {
                status = ToDo.State.COMPLETATA;
            } else if (str[6].equals("ANNULLATA")) {
                status = ToDo.State.ANNULLATA;
            } else
                System.out.println("Valore di stato nullo o non valido.");

            ToDo td = new ToDo(title, description, deliveryDate, priority, status);
            return td;
        }
    }



