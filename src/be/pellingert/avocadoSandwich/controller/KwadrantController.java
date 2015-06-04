package be.pellingert.avocadoSandwich.controller;

import be.pellingert.avocadoSandwich.model.KernKwadrant;
import be.pellingert.avocadoSandwich.view.KwadrantFrame;

import java.util.ArrayList;

/**
 * Created by gp on 3/06/15.
 */
public class KwadrantController {
    private KwadrantFrame view;
    private ArrayList<KernKwadrant> kernKwadrantArrayList;

    public KwadrantController(){
        init();
    }

    private void init() {
        kernKwadrantArrayList = KernKwadrant.loadKwadrants();
        view = new KwadrantFrame(this);
    }

    public ArrayList<KernKwadrant> getKernKwadrantArrayList() {
        return kernKwadrantArrayList;
    }

    public void changeSelectionIndex(int index) {
        view.changeSelectionIndex(index);
    }
}
