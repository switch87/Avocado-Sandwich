package be.pellingert.avocadoSandwich;

import be.pellingert.avocadoSandwich.controller.KwadrantController;

/**
 * Created by gp on 3/06/15.
 */
public class testClass {
    public static void main(String[] args) {
        /*for (KernKwadrant kwadrant: KernKwadrant.loadKwadrants()){
            System.out.println(kwadrant.kwaliteit +"\t"+ kwadrant.uitdaging +"\t"+kwadrant.allergie +"\t"+kwadrant.valkuil);
        }*/

        new KwadrantController();
    }
}
