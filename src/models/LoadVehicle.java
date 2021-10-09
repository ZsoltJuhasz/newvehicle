/*
 * File: LoadVehicle.java
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

package models;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class LoadVehicle {
    ArrayList<String> vehicles;

    public LoadVehicle() {
        vehicles = new ArrayList<>();
    }

    public ArrayList<Vehicle> load() {
        ArrayList<Vehicle> vehicleList = new ArrayList<>();
        try {
           vehicleList = attemptToReadFile(); 
        } catch (FileNotFoundException e) {
            System.err.println("Hiba! A fájl nem található");
        } 

        return vehicleList;
    }

    private ArrayList<Vehicle> attemptToReadFile() throws FileNotFoundException{
        ArrayList<Vehicle> vehicleList = new ArrayList<>();
        FileReader fr = new FileReader("data.txt");
        Scanner sc = new Scanner(fr);

        while(sc.hasNext()){
            String line = sc.nextLine();
            String[] lineArray = line.split(":");
            Vehicle vehicle = new Vehicle();
            vehicle.ordinal = lineArray[0];
            vehicle.brand = lineArray[1];
            vehicle.year = lineArray[2];
            vehicleList.add(vehicle);
        }
        sc.close();
        return vehicleList;
    }
       
        
}
