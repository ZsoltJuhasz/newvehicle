/*
 * File: Vehicle.java
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

/**
 * A járművek bármilyen kerekes és kerék nélküli eszközök lehetnek.
 * Lehet akár egy Lada, egy szekér. De monjuk az utóbbi típusának
 * a feliírása nem könnyű ebben az oszhtályban. Rendszáma
 * meg pláne nincs a szekereknek, bicikliknek. De mivel
 * személyautókat eladó cégnek készül, jó lesz ez így.
 */

public class Vehicle {
    // ordinal tároló:
    public String ordinal;
    // brand tároló:
    public String brand;
    // year tároló:
    public String year;    
}// A Vehicle vége
