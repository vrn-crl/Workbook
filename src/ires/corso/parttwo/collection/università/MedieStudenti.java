package ires.corso.parttwo.collection.università;

import java.lang.reflect.Array;
import java.util.*;

public class MedieStudenti {

    public static void main(String[] args) {
        //Creo 3 studenti
        Student s1 = new Student("Veronica", "Cirillo", "A031");
        Student s2 = new Student("Carlo", "Quinto", "A032");
        Student s3 = new Student("Enrico", "Ottavo", "A033");

        //creo una collection ArrayList students di studenti
        ArrayList <Student> students= new ArrayList<>();
        students.add(s1);
        students.add(s2);
        students.add(s3);
        for(Student s : students)
        {
            System.out.println(s.getName() + " "+ s.getSurname());
        }

        //Creo 3 corsi (mai usati)
        Course c1 = new Course("Java foundamentals", "Basi di Java", "Informatica");
        Course c2 = new Course("Diritto Canonico", "Insieme delle norme formulate dalla Chiesa Cattolica che regolano le interazioni inter ecclesiastiche e quelle con la società esterna", "Giurisprudenza");
        Course c3 = new Course("Musica Elettronica", "Storia della music nel '900","Musica");

        //creo assignments corso Java
        Assignment asJava1 = new Assignment("tipi primitivi", "first excercises");
        Assignment asJava2 = new Assignment("classi e oggetti", "first excercises");
        Assignment asJava3 = new Assignment("jcf", "first excercises");

        //creo assignments corso Giurisprudenza
        Assignment asDir1 = new Assignment("La costituzione","...");
        Assignment asDir2 = new Assignment("diritto canonico", "ecc");

        //creo Assignments corso MusicaEle
        Assignment asMusE1 = new Assignment("scuola di colonia", "Attraverso il software Supercollider realizza un programmino capace di sintetizzare una semplice melodia");
        Assignment asMusE2 = new Assignment("Piano phase", "componi un semplice brano applicando la tecnica di Steve Reich");

        //creo arraylist assignment di java
        ArrayList <Assignment> javaAss = new ArrayList<>();
        javaAss.add(asJava1);
        javaAss.add(asJava2);
        javaAss.add(asJava3);

        // creo arrayList assignment di Giurisprudenza
        ArrayList <Assignment> dirAss = new ArrayList<>();
        dirAss.add(asDir1);
        dirAss.add(asDir2);

        //creo arrayList assignment di MusicaElettronica
        //ArrayList<Assignment> mElAss = new ArrayList<>();
        //mElAss.add(asMusE1);
        //mElAss.add(asMusE2);

        //______________________________________________________________________________________________________________
        //voti per ogni assignment java di Veronica
        ArrayList<Float> marksVeronicaJava= new ArrayList<>();
        for (Assignment element : javaAss) {
            marksVeronicaJava.add(element.voto());
        }
        System.out.println("Voti di Veronica in assignments Java : \n" + marksVeronicaJava);

        //voti per ogni assignment java di Enrico
        ArrayList<Float> marksEnricoJava= new ArrayList<>();
        for (Assignment item : javaAss) {
            marksEnricoJava.add(item.voto());
        }

        //voti per ogni assignment java di Carlo
        ArrayList<Float> marksCarloJava= new ArrayList<>();
        for (Assignment value : javaAss) {
            marksCarloJava.add(value.voto());
        }
        //------------------------------------------------------------------------------------------

        //voti per ogni assignment giurisprud di Veronica
        ArrayList<Float> marksVeronicaDir= new ArrayList<>();
        for (Assignment assignment : dirAss) {
            marksVeronicaDir.add(assignment.voto());
        }
        System.out.println("Voti di Veronica in assignments Giurisprudenza : \n" + marksVeronicaDir);

        //voti per ogni assignment giurisp di Enrico Ottavo
        ArrayList<Float> marksEnricoDir= new ArrayList<>();
        for (Assignment ass : dirAss) {
            marksEnricoDir.add(ass.voto());
        }
        //voti per ogni assignment giuris di Carlo Quinto
        ArrayList<Float> marksCarloDir= new ArrayList<>();
        for (Assignment assi : dirAss) {
            marksCarloDir.add(assi.voto());
        }
      //----------------------------------------------------------------------------------------------------------------

        //per ogni assignment (di un corso) dovrò avere il voto che un certo studente ha preso
        Map <Student, Float> firstJavaAssMark = new HashMap<>(); // VOTO DEL PRIMO COMPITO JAVA DI CIASCUNO STUDENTE
        firstJavaAssMark.put(s1,marksVeronicaJava.get(0)); //voto di Veronica al primo ASS java
        firstJavaAssMark.put(s2, marksEnricoJava.get(0)); //voto di Anrico al primo Ass java
        firstJavaAssMark.put(s3, marksCarloJava.get(0)); // voti di Carlo al primo ass java

        Map <Student, Float> secondJavaAssMark = new HashMap<>(); // VOTO DEL SECONDO COMPITO JAVA DI CIASCUNO STUDENTE
        secondJavaAssMark.put(s1,marksVeronicaJava.get(1)); //voto di Veronica al secondo ASS java
        secondJavaAssMark.put(s2, marksEnricoJava.get(1)); //voto di Anrico al secondo Ass java
        secondJavaAssMark.put(s3, marksCarloJava.get(1)); // voti di Carlo al secodno ass java

        Map <Student, Float> thirdJavaAssMark = new HashMap<>(); // VOTO DEL TERZO COMPITO JAVA DI CIASCUNO STUDENTE
        thirdJavaAssMark.put(s1,marksVeronicaJava.get(2)); //voto di Veronica al secondo ASS java
        thirdJavaAssMark.put(s2, marksEnricoJava.get(2)); //voto di Anrico al secondo Ass java
        thirdJavaAssMark.put(s3, marksCarloJava.get(2)); // voti di Carlo al secodno ass java

        //--------------------------------------------------------------------------------------------------------------
        //per ogni assignment (di un corso) dovrò avere il voto che un certo studente ha preso
        Map <Student, Float> firstDirAssMark = new HashMap<>(); // VOTO DEL PRIMO COMPITO DIR DI CIASCUNO STUDENTE
        firstDirAssMark.put(s1,marksVeronicaDir.get(0)); //voto di Veronica al primo ASS dir
        firstDirAssMark.put(s2, marksEnricoDir.get(0)); //voto di Anrico al primo Ass dir
        firstDirAssMark.put(s3, marksCarloDir.get(0)); // voti di Carlo al primo ass dir

        Map <Student, Float> secondDirAssMark = new HashMap<>(); // VOTO DEL SECONDO COMPITO DIR DI CIASCUNO STUDENTE
        secondDirAssMark.put(s1, marksVeronicaDir.get(1)); //voto di Veronica al secondo ASS Dir
        secondDirAssMark.put(s2, marksEnricoDir.get(1)); //voto di Anrico al secondo Ass Dir
        secondDirAssMark.put(s3, marksCarloDir.get(1)); // voti di Carlo al secodno ass Dir

        //--------------------------------------------------------------------------------------------------------------

        // calcolo la media dei voti di tutti gli studenti in ciascun assignment (quanto è difficile per gli studenti un certo assignment?)

        int totalStudents = students.size();
        float mediaAss1 = (firstJavaAssMark.get(s1) + firstJavaAssMark.get(s2) + firstJavaAssMark.get(s3))/totalStudents; //somma dei voti di ciascuno studente in un determinato assignment
        float mediaAss2 = (secondJavaAssMark.get(s1)+ secondJavaAssMark.get(s2) + secondJavaAssMark.get(s3))/totalStudents;
        float mediaAss3 = (thirdJavaAssMark.get(s1)+thirdJavaAssMark.get(s2)+thirdJavaAssMark.get(s3))/totalStudents;

        System.out.printf("La classe nel 1 assJava ha una media del %.2f \n", mediaAss1);
        System.out.printf("La classe nel 2 assJava ha una media del %.2f \n", mediaAss2);
        System.out.printf("La classe nel 3 assJava ha una media del %.2f \n", mediaAss3);

        //--------------------------------------------------------------------------------------------------------------

        float mediaAsD1 = (firstDirAssMark.get(s1) + firstDirAssMark.get(s2) + firstDirAssMark.get(s3))/totalStudents; //somma dei voti di ciascuno studente in un determinato assignment
        float mediaAsD2 = (secondDirAssMark.get(s1)+ secondDirAssMark.get(s2) + secondDirAssMark.get(s3))/totalStudents;

        System.out.printf("La classe nel 1 assignment di diritto ha una media del %.2f \n", mediaAsD1);
        System.out.printf("La classe nel 2 assignment di diritto ha una media del %.2f \n", mediaAsD2);


        //--------------------------------------------------------------------------------------------------------------

        //Calcolo la media dei voti di ciascun studente in ciascun corso (come è andato ciascun studente in un corso?)

        Map<Assignment, Map<Student,Float>> corsoJava= new HashMap<>();
            corsoJava.put(asJava1, firstJavaAssMark);
            corsoJava.put(asJava2, secondJavaAssMark);
            corsoJava.put(asJava3, thirdJavaAssMark);

        float mediaVeronicainJava = (corsoJava.get(asJava1).get(s1) + corsoJava.get(asJava2).get(s1) + corsoJava.get(asJava3).get(s1))/3;
        System.out.printf("La media dei compiti del corso Java di Veronica è del %.2f: ", mediaVeronicainJava);
        }
    }

