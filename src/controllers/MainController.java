/*
 * File: MainController.java
 * Created Date: 2021-09-24 22:21:42
 * Author: Juhasz Zsolt Attila SZOFT 2N
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

package controllers;

import java.util.ArrayList;
import models.LoadVehicle;
import models.Vehicle;
import views.MainWindow;

public class MainController {
    MainWindow mainWindow;
    LoadVehicle loadVehicle;

    public MainController(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
        this.loadVehicle = new LoadVehicle();
        goThroughVehicleList();

        // TODO A névtelen metódus tartalmát ki kell szervezni
        // TODO A függvény tartalmát is több részre bontani

        this.mainWindow.addButton.addActionListener(event -> {
            addVehicle();
        });
        // TODO: Törlés megvalósítása
        this.mainWindow.delButton.addActionListener(event -> {
            deleteVehicle();
        });
        // TODO: Mentés megvalósítása
        this.mainWindow.saveButton.addActionListener(event -> {
            saveVehicle();
        });

    }

    private void goThroughVehicleList() {
        ArrayList<Vehicle> vehicleList = this.loadVehicle.load();
        for (Vehicle vehicle : vehicleList) {
            this.mainWindow.vehicleModel.addRow(new Object[] { vehicle.ordinal, vehicle.brand, vehicle.year });
        }
    }

    private void addModellContent() {
        System.out.println("Hozzáadás...");
        String ordinal = this.mainWindow.plateNumberField.getText();
        String brand = this.mainWindow.brandField.getText();
        String year = this.mainWindow.yearField.getText();
        this.mainWindow.vehicleModel.addRow(new Object[] { ordinal, brand, year });
    }

    private void setFieldEmpty() {
        this.mainWindow.plateNumberField.setText("");
        this.mainWindow.brandField.setText("");
        this.mainWindow.yearField.setText("");
    }

    private void addVehicle() {
        System.out.println("Hozzáadás...");
        addModellContent();
        setFieldEmpty();
    }

    private void deleteVehicle(){
        System.out.println("Törlés...");
    }

    private void saveVehicle(){
        System.out.println("Mentés...");
    }
}
