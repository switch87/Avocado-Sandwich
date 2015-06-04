package be.pellingert.avocadoSandwich.view;

import be.pellingert.avocadoSandwich.controller.KwadrantController;
import be.pellingert.avocadoSandwich.model.KernKwadrant;
import be.pellingert.avocadoSandwich.model.SearchItem;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by gp on 3/06/15.
 */
public class InputPanel extends JPanel {
    private JTextField searchTextField;
    private JList searchListBox;
    private JScrollPane scrollPane;
    private KwadrantController controller;
    private ArrayList<SearchItem> searchArrayList;
    private int[] listBoxCounter;

    public InputPanel(KwadrantController controller) {
        this.controller = controller;
        initComponents();
        layoutComponents();
        initListeners();
    }

    private void initComponents() {


        searchTextField = new JTextField("");
        searchArrayList = new ArrayList<>();

        searchListBox = new JList();
        scrollPane = new JScrollPane(searchListBox);
        fillSearchListBox();

    }

    private void layoutComponents() {
        setLayout(new GridLayout(1, 5));
        add(searchTextField);
        add(scrollPane);
        //add(searchListBox);
    }

    private void initListeners() {
        searchTextField.addActionListener(e -> {
            fillSearchListBox();
        });
        searchListBox.addListSelectionListener(e -> {
            if (searchListBox.getSelectedIndex()!=-1) {
                    controller.changeSelectionIndex(((SearchItem)(searchListBox.getSelectedValue())).getId());
                }
            });
    }

    private void fillSearchListBox() {
        searchListBox.setSelectedIndex(-1);
        SearchItem newItem;
        searchArrayList.clear();
        Object[] kwadrantArray= (controller.getKernKwadrantArrayList().toArray());
        for (int i =0; i < kwadrantArray.length; i++) {
            if (((KernKwadrant)(kwadrantArray[i])).kwaliteit.contains(searchTextField.getText())) {
                newItem = new SearchItem(((KernKwadrant)(kwadrantArray[i])).kwaliteit,i);

                    searchArrayList.add(newItem);
            }
            if (((KernKwadrant)(kwadrantArray[i])).valkuil.contains(searchTextField.getText())) {
                newItem = new SearchItem(((KernKwadrant)(kwadrantArray[i])).valkuil,i);

                searchArrayList.add(newItem);
            }
            if (((KernKwadrant)(kwadrantArray[i])).allergie.contains(searchTextField.getText())) {
                newItem = new SearchItem(((KernKwadrant)(kwadrantArray[i])).allergie,i);

                searchArrayList.add(newItem);
            }
            if (((KernKwadrant)(kwadrantArray[i])).uitdaging.contains(searchTextField.getText())) {
                newItem = new SearchItem(((KernKwadrant)(kwadrantArray[i])).uitdaging,i);

                searchArrayList.add(newItem);
            }}

        Collections.sort(searchArrayList);
        searchListBox.setListData(searchArrayList.toArray());


    }
}
