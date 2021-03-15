package com.example.bottledispenser;

public class Bottle {
    private int identifier = 1;
    private String name = "Pepsi Max";
    private String manufacturer = "Pepsi";
    private double total_energy = 0.3;
    private double size = 0.5;
    private double price = 1.80;
    public Bottle(int id){
        switch (id) {
            case 1:
                break;
            case 2:
                identifier = 2;
                size = 1.5;
                price = 2.2;
                break;
            case 3:
                identifier = 3;
                name = "Coca-Cola Zero";
                manufacturer = "Coca-Cola";
                price = 2.0;
                break;
            case 4:
                identifier = 4;
                name = "Coca-Cola Zero";
                manufacturer = "Coca-Cola";
                size = 1.5;
                price = 2.5;
                break;
            case 5:
                identifier = 5;
                name = "Fanta Zero";
                manufacturer = "Sinebrychoff";
                price = 1.95;
                break;
            default:
                break;
        }

    }
    public Bottle(String name, String manuf, float totE){

    }
    public String getName(){
        return name;
    }
    public String getManufacturer(){
        return manufacturer;
    }
    public double getEnergy(){
        return total_energy;
    }
    public double getSize(){
        return size;
    }
    public double getPrice(){
        return price;
    }
}