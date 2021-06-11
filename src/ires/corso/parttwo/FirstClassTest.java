package ires.corso.parttwo;

import ires.corso.parttwo.firstclasses.Videocamera;

public class FirstClassTest {

    public static void main(String [] args){

        Videocamera cam1 = new Videocamera ("Red"); // 3840×2160 resolution
        Videocamera cam2 = new Videocamera("Nikon"); // 2048x1080 resolution
        cam1.resFrRate(120, "4K");
        cam2.resFrRate(60, "2K");
       /* System.out.println(cam1.setIsExpensive());
        System.out.println(cam1.getModel());
        System.out.println(cam2.setIsExpensive());
        System.out.println(cam2.getModel());*/

        System.out.printf(cam1.prettyPrint() + "\n" + cam2.prettyPrint());
    }
}
