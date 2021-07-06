package ires.corso.parttwo.todo;
import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Comparator;

public class ToDo implements Serializable, Cloneable
    {
        protected enum Priorities {
            ALTA,
            MEDIA,
            BASSA
        }

        protected enum State {
            DA_FARE,
            IN_ESECUZIONE,
            ANNULLATA,
            COMPLETATA
        }

//variabili di istanza
        protected Long id;
        private String title;
        private String description;
        protected LocalDate insertionDate;
        private LocalDate deliveryDate;
        private Priorities priority;
        private State status;

        //costruttore che inizializza il parametro id a ++idIncr
        public ToDo(String t, String d, LocalDate deliveryDate, Priorities p, State s) throws IOException {
            this.title = t;
            this.description = d;
            this.insertionDate = LocalDate.now();
            this.deliveryDate = deliveryDate;
            priority = p;
            status = s;
        }

        //costruttore 2 privato
            private ToDo(String title, String description, LocalDate insertionDate, LocalDate deliveryDate){
            //this.id =id;
            this.title = title;
            this.description = description;
            this.insertionDate = insertionDate;
            this.deliveryDate = deliveryDate;
        }

        //getter di tutto
        public Long getId() {
            return id;
        }

        public String getTitle() {
            return title;
        }

        public String getDescription() {
            return description;
        }

        public LocalDate getInsertionDate() {
            return insertionDate;
        }

        public LocalDate getDeliveryDate() {
            return deliveryDate;
        }

        public Priorities getPriority() {
            return priority;
        }

        public State getStatus() {
            return status;
        }
//--------------------------------------------------------------------------------------------

        public void setTitle(String title) {
            this.title = title;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public void setDeliveryDate(LocalDate deliveryDate) {
            this.deliveryDate = deliveryDate;
        }

        public void setPriority(Priorities priority) {
            this.priority = priority;
        }

        public void setStatus(State status) {
            this.status = status;
        }

        public void setId(Long id) {
            this.id = id;
        }
//----------------------------------------------------------------------------------------------

        public ToDo cloneForUpdate() throws CloneNotSupportedException {

                ToDo copiedToDo = null;
                try{
                    copiedToDo = (ToDo) clone();
                }
                catch (CloneNotSupportedException cnse){
                    System.out.println("error");
                }
                return copiedToDo;
        }

        public String prettyPrint(){
            String s = String.format(" ID: %d \n TITOLO: %s \n DESCRIZIONE: %s \n CREATO IL: %s \n CON SCADENZA IL: %s \n CON PRIORITà: %s \n CON STATO: %s", getId(), getTitle(), getDescription(),getInsertionDate().toString(), getDeliveryDate().toString(), getPriority().toString(), getStatus().toString());
            return s;
        }
    }

