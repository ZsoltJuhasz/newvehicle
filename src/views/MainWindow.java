/*
 * File: MainWindow.java
 * Created Date: 2021-09-24 22:21:42
 * Author: Juhasz Zsolt Attila
 * Original Project: revehicle
 * Original Author: Sallai Andras
 * Github: https://github.com/ZsoltJuhasz
 * -----
 * Last Modified: 2021-10-09
 * Modified By: Juhasz Zsolt Attila
 * -----
 * Copyright (c) 2021 Sallai Andras
 * 
 * GNU GPL v2
 */

package views;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class MainWindow extends JFrame {

    public JLabel vehicleLabel;
    public JPanel controlPanel;
    public JPanel formPanel;
    public JPanel buttonPanel;
    public JLabel plateLabel;
    public JTextField plateNumberField;
    public JLabel brandLabel;
    public JTextField brandField;
    public JLabel yearLabel;
    public JTextField yearField;
    public JButton addButton;
    public JButton delButton;
    public JButton saveButton;

    public DefaultTableModel vehicleModel;
    public JTable vehicleTable;
    public JScrollPane vehicleScrollPane;

    public MainWindow() {

        initGUI();

    }

    private void initGUI() {

        makeControlPanel();
        addEveryLabel();
        addEveryPanel();
        loadVehicleTable();
        setLayout();

    }

    private void makeControlPanel() {
        this.controlPanel = new JPanel();
        this.controlPanel.setLayout(new BoxLayout(this.controlPanel, BoxLayout.LINE_AXIS));
        this.controlPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    }

    private void addEveryLabel() {
        makeVehicleLabel("Járművek");
        makePlateNumberLabel("Rendszám");
        makeBrandLabel("Márka");
        makeYearLabel("Év");
    }

    private void addEveryPanel() {
        makeFormPanel();
        makeButtonPanel();
    }

    private void makePlateNumberLabel(String label) {
        this.plateLabel = new JLabel(label);
        this.plateLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        this.plateLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10));
        this.plateNumberField = new JTextField();
    }

    private void makeBrandLabel(String label) {
        this.brandLabel = new JLabel(label);
        this.brandLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        this.brandLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10));
        this.brandField = new JTextField();
    }

    private void makeYearLabel(String text) {
        this.yearLabel = new JLabel(text);
        this.yearLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        this.yearLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10));
        this.yearField = new JTextField();
    }

    private void fillOutFormPanel() {
        this.formPanel.add(this.plateLabel);
        this.formPanel.add(this.plateNumberField);
        this.formPanel.add(this.brandLabel);
        this.formPanel.add(this.brandField);
        this.formPanel.add(this.yearLabel);
        this.formPanel.add(this.yearField);
    }

    private void makeFormPanel() {
        this.formPanel = new JPanel();
        this.formPanel.setLayout(new GridLayout(3, 2));
        this.controlPanel.add(this.formPanel);
        fillOutFormPanel();

    }

    private void makeButtons() {
        this.addButton = new JButton("Hozzáadás");
        this.delButton = new JButton("Törlés");
        this.saveButton = new JButton("Mentés");
    }

    private void addButtons() {
        this.buttonPanel.add(this.addButton);
        this.buttonPanel.add(this.delButton);
        this.buttonPanel.add(this.saveButton);
        this.controlPanel.add(this.buttonPanel);
    }

    private void makeButtonPanel() {
        this.buttonPanel = new JPanel();
        this.buttonPanel.setLayout(new BoxLayout(this.buttonPanel, BoxLayout.PAGE_AXIS));
        makeButtons();
        addButtons();
    }

    private void loadVehicleTable() {
        this.vehicleModel = new DefaultTableModel();
        this.vehicleTable = new JTable(vehicleModel);
        this.vehicleScrollPane = new JScrollPane(this.vehicleTable);
        this.vehicleScrollPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        Object[] tableLabels = new Object[] { "Rendszám", "Márka", "Év" };
        this.vehicleModel.setColumnIdentifiers(tableLabels);
    }

    private void makeVehicleLabel(String label) {
        this.vehicleLabel = new JLabel(label);
        this.vehicleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        this.vehicleLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    }

    private void fillWindow() {
        this.add(this.vehicleLabel);
        this.add(this.controlPanel);
        this.add(this.vehicleScrollPane);
    }

    private void setLayout() {
        fillWindow();
        this.setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
    }
}