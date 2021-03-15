package com.example.bottledispenser;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    int pos;
    String purchase;
    Button buy;
    Button money;
    Button returnMoney;
    Button receipt;
    TextView text;
    TextView progr;
    SeekBar coins;
    Spinner choice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        money = (Button) findViewById(R.id.add_money);
        buy = (Button) findViewById(R.id.buy_bottle);
        text = (TextView) findViewById(R.id.textView);
        returnMoney = (Button) findViewById(R.id.return_money);
        receipt = (Button) findViewById(R.id.print_receipt);
        coins = (SeekBar) findViewById(R.id.seekBar);
        progr = (TextView) findViewById(R.id.progress);
        choice = (Spinner) findViewById(R.id.spinner);
        choice.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                pos = position;
                System.out.println(pos);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        coins.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progr.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    BottleDispenser bDispenser = BottleDispenser.getInstance();
    public void addMoney(View v) {
        int money = coins.getProgress();
        bDispenser.addMoney(v, text, money);
        coins.setProgress(0);
    }
    public void buyBottle(View v) {
        purchase = bDispenser.buyBottle(pos+1, v, text);
    }
    public void returnMoney(View v) {
        bDispenser.returnMoney(v, text);
    }
    public void printReceipt(View v) {
        FileOutputStream fos = null;
        try {
            fos = openFileOutput("receipt.txt", MODE_PRIVATE);
            fos.write(purchase.getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

