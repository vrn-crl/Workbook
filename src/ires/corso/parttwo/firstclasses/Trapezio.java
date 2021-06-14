package ires.corso.parttwo.firstclasses;

public class Trapezio extends MasterShape{
    public Trapezio(int bM, int b, int h){
        this.bM = bM;
        this.b = b;
        this.h = h;
    }

    public int getH(){
        return h;
    }

    public int getBM(){
        return bM;
    }

    public int getB(){
        return b;
    }

    public void setL1(int l1, int l2){ //lato obliquo1
        this.l1 = l1;
        this.l2 = l2;
    }
    @Override
    public int computeArea(){
        return ((this.getBM() + this.getB())* this.getH())/2;
    }

    @Override
    public int computePerimeter(){
       int l_perimeter = (2);
       return l_perimeter * 4;
    }
}
