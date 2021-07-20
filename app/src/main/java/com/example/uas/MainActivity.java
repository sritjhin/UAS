package com.example.uas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    /*
     Students odd id (NIM ganjil): Implement a simulation of 2 battles between Cavalry vs Infantry AND
    Infantry vs (Cavalry :q+ Range)
     */

    public static int getRandomNumber(int min, int max) {
        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnBattle = findViewById(R.id.btnBattle);
        Button btnBattle2 = findViewById(R.id.btnBattle2);
        ImageView ivLeft = findViewById(R.id.ivLeft);
        ImageView ivRight = findViewById(R.id.ivRight);
        ivLeft.setVisibility(View.GONE);
        ivRight.setVisibility(View.GONE);

        btnBattle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double cavalryAtk = 1, infantryAtk = 1;

                int totalCavalryHero = getRandomNumber(1, 5);
                int totalCavalryArmy = getRandomNumber(1, 100000);

                int totalInfantryHero = getRandomNumber(1, 5);
                int totalInfantryArmy = getRandomNumber(1, 100000);

                cavalryAtk = totalCavalryArmy + (40 / 100 * totalCavalryHero * totalCavalryArmy);
                infantryAtk = totalInfantryArmy + (40 / 100 * totalInfantryHero * totalInfantryArmy);

                cavalryAtk *= 0.4;
                infantryAtk *= 0.1;

                if (cavalryAtk > infantryAtk) {
                    ivLeft.setVisibility(View.VISIBLE);
                    ivRight.setVisibility(View.GONE);
                } else {
                    ivRight.setVisibility(View.VISIBLE);
                    ivLeft.setVisibility(View.GONE);
                }
            }
        });

        btnBattle2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double cavalryAtk = 1, infantryAtk = 1;

                int totalInfantryHero = getRandomNumber(1, 5);
                int totalInfantryArmy = getRandomNumber(1, 100000);

                int totalCavalryHero = getRandomNumber(1, 5);
                int totalCavalryArmy = getRandomNumber(1, 100000);
                int totalArcherArmy = getRandomNumber(1,100000 - totalCavalryArmy);

                cavalryAtk = totalCavalryArmy + (40 / 100 * totalCavalryHero * totalCavalryArmy);
                infantryAtk = totalInfantryArmy + (40 / 100 * totalInfantryHero * totalInfantryArmy);

                cavalryAtk *= 0.4;
                infantryAtk *= 0.1;

                double archerAtk = totalArcherArmy * 0.1;
                cavalryAtk+=archerAtk;

                if (cavalryAtk > infantryAtk) {
                    ivLeft.setVisibility(View.VISIBLE);
                    ivRight.setVisibility(View.GONE);
                } else {
                    ivRight.setVisibility(View.VISIBLE);
                    ivLeft.setVisibility(View.GONE);
                }
            }
        });
    }

}