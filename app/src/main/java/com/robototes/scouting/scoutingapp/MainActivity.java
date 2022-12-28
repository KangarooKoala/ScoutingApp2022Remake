package com.robototes.scouting.scoutingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static <T> T getRandFromArray(T[] arr) {
        int index = (int) (arr.length * Math.random());
        return arr[index];
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources res = getResources();
        TextView splashText = (TextView) findViewById(R.id.splash_view);
        String[] splashes = res.getStringArray(R.array.splashes);
        splashText.setText(getRandFromArray(splashes));

        Button startButton = (Button) findViewById(R.id.start_button);

        EditText matchNumber = (EditText) findViewById(R.id.match_number);
        EditText teamNumber = (EditText) findViewById(R.id.team_number);
        EditText name = (EditText) findViewById(R.id.name);
    }
}