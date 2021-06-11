package ires.corso.parttwo.firstclasses;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

public class Videocamera {
    // Includete:
    // - almeno un campo int/long
    // - almeno un campo Stringa
    // - almeno un campo boolean

    private int fps;
    private String res;
    private String model;
    private boolean isExpensive;

    public Videocamera(String model){
        this.model = model;
        //this.res= res;
    }
    //un costruttore diverso da quello di default che accetta almeno 2 argomenti e li imposta come valore dei campi

    public void resFrRate(int fps, String res){    //costruttore che setta risoluzione e frameRate dell' oggetto
        this.fps = fps;
        this.res = res;

    }

    public String getModel() {
      return this.model;
    }

    public String setIsExpensive() {
        if (model.equals("Red")){
            this.isExpensive = true;
            return ("sono decisamente costosa!");
        }
        else this.isExpensive=false;
        return ("ho un prezzo abbordabile:)");
    }

    public String prettyPrint(){
            return ("Sono una videocamera di marca " + this.model + " con un frame rate di " + this.fps + "fps, risoluzione di " + this.res + " e " + this.setIsExpensive());
        }
    }


