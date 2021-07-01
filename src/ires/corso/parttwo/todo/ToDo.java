package ires.corso.parttwo.todo;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Comparator;

public class ToDo implements Serializable, Cloneable
    {
        protected final Long id;
        private static Long idIncr = 0L;
        private String title;
        private String description;
        protected LocalDate insertionDate;
        private LocalDate deliveryDate;
        private enum priority {
            ALTA,
            MEDIA,
            BASSA
        }
        private enum state {
            DA_FARE,
            IN_ESECUZIONE,
            ANNULLATA,
            COMPLETATA
        }
        //costruttore che inizializza il parametro id a ++idIncr
        public ToDo(String title, String description, LocalDate insertionDate, LocalDate deliveryDate) {
            this.id = getNewId();
            this.title = title;
            this.description = description;
            this.insertionDate = insertionDate;
            this.deliveryDate = deliveryDate;
        }

        //costruttore 2
        public ToDo(Long id, String title, String description, LocalDate insertionDate, LocalDate deliveryDate) {
            this.id = id;
            this.title = title;
            this.description = description;
            this.insertionDate = insertionDate;
            this.deliveryDate = deliveryDate;
        }

        //getter di tutto
        public Long getId() {
            return id;
        }

        public long getNewId(){
            idIncr = ++idIncr;
            return idIncr;
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

        //--------------------------------------------------------------------------------------------

        //setter di title, description, data consegna
        public void setTitle(String title) {
            this.title = title;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public void setDeliveryDate(LocalDate deliveryDate) {
            this.deliveryDate = deliveryDate;
        }

        //----------------------------------------------------------------------------------------------

        public ToDo cloneForUpdate() {
            // fabbrica una copia esatta del To-Do (compreso l'ID)

            ToDo newToDo = new ToDo(this.id, this.title, this.description, this.insertionDate, this.deliveryDate);
            return newToDo;
        }
    }

