/*
 * File: LoadVehicle.java
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

package models;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class LoadVehicle {
    ArrayList<String> vehicles;
    public LoadVehicle() {
        vehicles = new ArrayList<>();
    }//A LoadVehicle metódus vége

    public ArrayList<Vehicle> load(){
    //A járművek listáját tárlojuk benne:
    ArrayList<Vehicle> vehicleList = new ArrayList<>();
    try {
    FileReader fileReader = new FileReader("data.txt");
    Scanner scanner = new Scanner(fileReader);
    //Ciklus amivel bejárjuk a fájlt:
    while(scanner.hasNext()) {
    String line = scanner.nextLine();
    String[] lineArray = line.split(":");
    Vehicle vehicle = new Vehicle();
    vehicle.ordinal = lineArray[0];
    vehicle.brand = lineArray[1];
    vehicle.year = lineArray[2];
    vehicleList.add(vehicle);
    }//while vége
    scanner.close();

    } catch (FileNotFoundException e) {
    System.err.println("Hiba! A fájl nem található");
    }//A try vége
    return vehicleList;
    }
}
