package ires.corso.parttwo.collection.università;

public class Course {

        private String title;
        private String area;
        private String description;

        //- Course (titolo, descrizione, settore)
        public Course (String title, String description, String area){
            this.title = title;
            this.description = description;
            this.area = area;
        }

    public String getTitle() {
        return title;
    }
}
