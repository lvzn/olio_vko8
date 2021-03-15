package com.example.bottledispenser;

import android.view.View;
import android.widget.TextView;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class BottleDispenser {
    private static BottleDispenser bd = new BottleDispenser();
    private int bottles;
    // The array for the Bottle-objects
    // private Bottle[] bottle_array;
    private double money;
    StringBuilder sb = new StringBuilder();
    String purchase;
    ArrayList<Bottle> bottlesList = new ArrayList<>();
    private BottleDispenser() {
        bottles = 5;
        money = 0;
        //  Add Bottle-objects to the array
        for(int i = 1;i<=bottles;i++) {
            // Use the default constructor to create new Bottles
            Bottle temp = new Bottle(i);
            bottlesList.add(temp);
        }
    }

    public static BottleDispenser getInstance() {
        return bd;
    }

    public void addMoney(View v, TextView text, int amount) {
        money += amount;
        text.setText("Klink! Added more money!");
        System.out.println("Klink! Added more money!");
    }

    public String buyBottle(int bottleType, View v, TextView text) {
        if (bottles == 0) {
            text.setText("No more bottles!");
        } else if (money == 0 || money < bottlesList.get(bottleType - 1).getPrice()) {
            text.setText("Add more money!");
        } else {
            bottles -= 1;
            money -= bottlesList.get(bottleType - 1).getPrice();
            text.setText("KACHUNK! " + bottlesList.get(bottleType - 1).getName() + " came out of the dispenser!");
            sb.append("Receipt:\n");
            sb.append(bottlesList.get(bottleType - 1).getName() + ";");
            sb.append(bottlesList.get(bottleType - 1).getPrice());
            purchase = sb.toString();
            sb.delete(0, sb.length());
            return purchase;
        }
        return "empty";
    }

    public void returnMoney(View v, TextView text) {
        text.setText(String.format("Klink klink. Money came out! You got %.2f€ back.\n", money));
        money = 0;
    }

    public void listBottles() {
        int i = 1;
        for (Bottle bepis : bottlesList) {
            System.out.print(i + ". Name: " + bepis.getName()+"\n"+
                    "\tSize: " + bepis.getSize() + "\tPrice: " + bepis.getPrice() + "\n");
            i++;
        }
    }
    public void removeBottle() {
        bottlesList.remove(bottles-1);
        bottles--;
    }
}
