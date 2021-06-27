package ires.corso.parttwo.collection.università;

public class Student {
    private String name;
    private String surname;
    private String id;

    //- Student (nome, cognome, codiceStudente, tutti String)
    public Student (String name, String surname, String id){
        this.name = name;
        this.surname = surname;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getId() {
        return id;
    }

    public void doAssignment (){

    }
}
