package be.pellingert.avocadoSandwich.view;

import be.pellingert.avocadoSandwich.controller.KwadrantController;
import be.pellingert.avocadoSandwich.model.KernKwadrant;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by gp on 3/06/15.
 */
@SuppressWarnings("ALL")
public class DisplayPanel extends JPanel {
    private final KwadrantController controller;
    private ArrayList<String> kwaliteiten, valkuilen, allergieen, uitdagingen;
    private boolean freeze;
    private JLabel kwaliteit, valkuil, allergie, uitdaging;
    private JComboBox kwaliteitVal, valkuilVal, allergieVal, uitdagingVal;

    public DisplayPanel(KwadrantController controller) {
        this.controller = controller;
        initComponents();
        layoutComponents();
        initListeners();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        freeze = false;
        kwaliteiten = new ArrayList<>();
        valkuilen = new ArrayList<>();
        allergieen = new ArrayList<>();
        uitdagingen = new ArrayList<>();
        for (KernKwadrant kwadrant : controller.getKernKwadrantArrayList()) {
            kwaliteiten.add(kwadrant.kwaliteit);
            valkuilen.add(kwadrant.valkuil);
            allergieen.add(kwadrant.allergie);
            uitdagingen.add(kwadrant.uitdaging);
        }


        kwaliteit = new JLabel();
        valkuil = new JLabel();
        allergie = new JLabel();
        uitdaging = new JLabel();
        kwaliteit.setText("Kwaliteit:");
        valkuil.setText("Valkuil:");
        allergie.setText("Allergie:");
        uitdaging.setText("Uitdaging:");

        kwaliteitVal = new JComboBox(kwaliteiten.toArray());
        valkuilVal = new JComboBox(valkuilen.toArray());
        allergieVal = new JComboBox(allergieen.toArray());
        uitdagingVal = new JComboBox(uitdagingen.toArray());
    }

    private void layoutComponents() {
        setLayout(new GridLayout(4, 2));
        add(kwaliteit);
        add(valkuil);
        add(kwaliteitVal);
        add(valkuilVal);
        add(allergie);
        add(uitdaging);
        add(allergieVal);
        add(uitdagingVal);
    }

    private void initListeners() {
        kwaliteitVal.addActionListener(e -> changeSelectionIndex(kwaliteitVal.getSelectedIndex()));
        valkuilVal.addActionListener(e -> changeSelectionIndex(valkuilVal.getSelectedIndex()));
        allergieVal.addActionListener(e -> changeSelectionIndex(allergieVal.getSelectedIndex()));
        uitdagingVal.addActionListener(e -> changeSelectionIndex(uitdagingVal.getSelectedIndex()));
    }

    void changeSelectionIndex(int selectedIndex) {

        if (!freeze) {
            freeze = true;
            kwaliteitVal.setSelectedIndex(selectedIndex);
            valkuilVal.setSelectedIndex(selectedIndex);
            allergieVal.setSelectedIndex(selectedIndex);
            uitdagingVal.setSelectedIndex(selectedIndex);
            freeze = false;
        }
    }
}
