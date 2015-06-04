package be.pellingert.avocadoSandwich.view;

import be.pellingert.avocadoSandwich.controller.KwadrantController;

import javax.swing.*;
import java.awt.*;

/**
 * Created by gp on 3/06/15.
 */
public class KwadrantFrame extends JFrame{
    private KwadrantController controller;
    private InputPanel inputPanel;
    private DisplayPanel displayPanel;

    public KwadrantFrame(KwadrantController controller){
        super("Avocado Sandwich");
        this.controller=controller;
        initComponents();
        layoutComponents();
        setVisible(true);
    }

    private void layoutComponents() {
        setLayout(new GridLayout(2, 1));
        add(inputPanel);
        add(displayPanel);

    }

    private void initComponents() {
        inputPanel = new InputPanel(controller);

        displayPanel=new DisplayPanel(controller);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(500, 400);
        setLocation(20, 20);
    }


    public void changeSelectionIndex(int index) {
        displayPanel.changeSelectionIndex(index);
    }
}
